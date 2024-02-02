/*
* Copyright 2019-2019 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package io.kubernetes.client.examples;

import io.kubernetes.client.examples.models.HTTPRoute;
import io.kubernetes.client.examples.models.HTTPRouteList;
import io.kubernetes.client.examples.models.HTTPRouteSpec;
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInner;
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerBackendRefsInner;
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerMatchesInner;
import io.kubernetes.client.examples.models.HTTPRouteSpecRulesInnerMatchesInnerPath;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1ConfigMapList;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.kubernetes.client.util.generic.KubernetesApiResponse;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 */
@SpringBootTest
@Testcontainers
public class ClusterIT {

	@Value("${NAMESPACE:default}")
	private final String namespace = "default";

	@Autowired
	private GenericKubernetesApi<HTTPRoute, HTTPRouteList> configs;

	@Autowired
	private GenericKubernetesApi<V1ConfigMap, V1ConfigMapList> maps;

	@Container
	public static GenericContainer<?> configserver = new GenericContainer<>(
			DockerImageName.parse("springcloud/configserver")).withExposedPorts(8888);

	private String name;

	@AfterEach
	public void after() {
		if (name != null) {
			configs.delete(namespace, name);
		}
	}

	@Test
	void createHTTPRouteAndCheckStatus() throws Exception {
		var before = maps.list(namespace).getObject().getItems().size();

		var route = new HTTPRoute();
		route.setKind("HTTPRoute");
		route.setApiVersion("gateway.networking.k8s.io/v1");

		var metadata = new V1ObjectMeta();
		metadata.setGenerateName("route-");
		metadata.setNamespace(namespace);
		route.setMetadata(metadata);

		var spec = new HTTPRouteSpec();
		spec.addHostnamesItem("test.example.com");
		HTTPRouteSpecRulesInner rule = new HTTPRouteSpecRulesInner();
		HTTPRouteSpecRulesInnerMatchesInner matches = new HTTPRouteSpecRulesInnerMatchesInner();
		matches.setPath(new HTTPRouteSpecRulesInnerMatchesInnerPath()
				.type(HTTPRouteSpecRulesInnerMatchesInnerPath.TypeEnum.PATHPREFIX).value("/"));
		rule.addMatchesItem(matches);
		rule.addBackendRefsItem(getBackend("primary", 8080, 90));
		rule.addBackendRefsItem(getBackend("secondary", 8080, 10));
		spec.addRulesItem(rule);
		route.setSpec(spec);

		var response = configs.create(route);
		Assertions.assertTrue(response.isSuccess());
		HTTPRoute result = response.getObject();
		assertThat(result).isNotNull();
		name = result.getMetadata().getName();
		Awaitility.await().atMost(Duration.ofMinutes(1)).until(() -> {
			KubernetesApiResponse<HTTPRoute> config = configs.get(namespace, result.getMetadata().getName());
			// TODO: await the route appearing in the gateway
			return config != null && //
					config.getObject() != null && //
					config.getObject().getStatus() != null;
		});

		assertThat(maps.list(namespace).getObject().getItems().size()).isEqualTo(before + 1);

	}

	private HTTPRouteSpecRulesInnerBackendRefsInner getBackend(String name, int port, int weight) {
		HTTPRouteSpecRulesInnerBackendRefsInner backend = new HTTPRouteSpecRulesInnerBackendRefsInner();
		backend.setName(name);
		backend.setWeight(weight);
		backend.setPort(port);
		return backend;
	}

}
