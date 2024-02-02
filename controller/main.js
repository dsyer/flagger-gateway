import * as k8s from "@kubernetes/client-node";
import fetch from 'node-fetch';

const CUSTOMRESOURCE_GROUP = "gateway.networking.k8s.io";
const CUSTOMRESOURCE_VERSION = "v1";
const CUSTOMRESOURCE_PLURAL = "httproutes";

const GATEWAY_URL = "http://localhost:8080"

class HTTPRouteSpec {
}

class HTTPRoute {
	constructor(obj) {
		obj && Object.assign(this, obj);
	}
	apiVersion = "v1";
	kind = "HTTPRoute";
	metadata = new k8s.V1ObjectMeta();
	spec = new HTTPRouteSpec();
}

const kc = new k8s.KubeConfig();
kc.loadFromDefault();

const k8sApiRoute = kc.makeApiClient(k8s.CustomObjectsApi);

const watch = new k8s.Watch(kc);

async function watchResource() {
	log("Watching API");
	return watch.watch(
		`/apis/${CUSTOMRESOURCE_GROUP}/${CUSTOMRESOURCE_VERSION}/${CUSTOMRESOURCE_PLURAL}`,
		{},
		onEvent,
		onDone,
	);
}

function onDone(err) {
	log(`Connection closed. ${err}`);
	watchResource();
}

async function onEvent(phase, apiObj) {
	log(`Received event in phase ${phase}.`);
	if (phase == "ADDED") {
		scheduleReconcile(apiObj);
	} else if (phase == "MODIFIED") {
		try {
			scheduleReconcile(apiObj);
		} catch (err) {
			log(err);
		}
	} else if (phase == "DELETED") {
		await deleteResource(apiObj);
	} else {
		log(`Unknown event type: ${phase}`);
	}
}

async function deleteResource(obj) {
	log(`Deleted ${obj.metadata.name}`);
}

let reconcileScheduled = false;

function scheduleReconcile(obj) {
	if (!reconcileScheduled) {
		setTimeout(reconcileNow, 1000, obj);
		reconcileScheduled = true;
	}
}

async function reconcileNow(obj) {
	reconcileScheduled = false;
	const route = new HTTPRoute(obj);
	log(`Reconciling "${route.metadata.name}"`);
	var status = route.status;
	log(`Status for "${route.metadata.name}" complete: ${JSON.stringify(route.spec)}`)
	if (route.spec.rules) {
		var routes = await fetch(GATEWAY_URL + "/actuator/gateway/routes", { method: "GET" }).then(it => it.json());
		await routes.forEach(async route => {
			log(`Deleting route "${route.route_id}"`);
			await fetch(GATEWAY_URL + "/actuator/gateway/routes/" + route.route_id, { method: "DELETE" }).then(it => it.status);
		});
		await route.spec.rules.forEach(async rule => {
			await rule.backendRefs.forEach(async ref => {
				log(`Processing backend "${ref.name}": port=${ref.port} with weight ${ref.weight}`);
				var body = {
					"predicates": [
						"Path=/podinfo",
						"Weight=podinfo," + ref.weight
					],
					"filters": ["StripPrefix=1"],
					"uri": "http://" + ref.name + ":" + ref.port
				};
				await fetch(GATEWAY_URL + "/actuator/gateway/routes/" + ref.name,
					{ method: "POST", body: JSON.stringify(body), headers: { 'Content-Type': 'application/json' } }
				).then(it => it.status).then(
					status => {
						log(`Created route "${ref.name}" with status ${status}`);
					},
					err => {
						log(`Error creating route "${ref.name}": ${err}`);
					}
				);
			})
		})
		log("Refreshing...")
		await fetch(GATEWAY_URL + "/actuator/gateway/refresh", { method: "POST" }).then(res => res.status);
	}
}

async function main() {
	await watchResource();
}

function log(message) {
	console.log(`${new Date().toLocaleString()}: ${message}`);
}

process.on("unhandledRejection", (reason, p) => {
	console.log("Unhandled Rejection, reason:", reason.message);
});

main();