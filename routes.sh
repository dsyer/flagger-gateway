#!/bin/bash

function update() {
	name=$1
	weight=$2
	body='{"predicates":["Path=/podinfo", "Weight=podinfo,'$weight'"],"filters":["StripPrefix=1"],"uri":"http://'$name':9898"}'
	curl -H "Content-Type: application/json" localhost:8080/actuator/gateway/routes/$name -d "$body"
	if [ $? -eq 0 ]; then
		echo "Updated $name to $weight"
	else
		echo "Failed to update $name to $weight"
	fi
}

while curl -s -X POST localhost:8080/actuator/gateway/refresh; do
	. <(curl -s localhost:8080/actuator/gateway/routes | jq -r '.[] | "curl -s -X DELETE localhost:8080/actuator/gateway/routes/\(.route_id)"')
	. <(kubectl get httproutes.gateway.networking.k8s.io podinfo \
		-o jsonpath='{.spec.rules[0].backendRefs}' | jq -r '.[] | "name=\(.name); weight=\(.weight); update $name $weight"')
	sleep 5
	echo
done
