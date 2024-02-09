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

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfig;
import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfigList;

import io.k8s.networking.gateway.models.V1HTTPRoute;
import io.k8s.networking.gateway.models.V1HTTPRouteList;
import io.k8s.networking.gateway.models.V1HTTPRouteSpec;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInner;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerBackendRefsInner;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerMatchesInner;
import io.k8s.networking.gateway.models.V1HTTPRouteSpecRulesInnerMatchesInnerPath;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.util.generic.GenericKubernetesApi;
import io.kubernetes.client.util.generic.KubernetesApiResponse;

/**
 * @author Dave Syer
 */
@SpringBootTest
public class ClusterIT {

	@Value("${NAMESPACE:apps}")
	private final String namespace = "default";

	@Autowired
	private GenericKubernetesApi<V1HTTPRoute, V1HTTPRouteList> configs;

	@Autowired
	private GenericKubernetesApi<V1SpringCloudGatewayRouteConfig, V1SpringCloudGatewayRouteConfigList> routes;

	private String name;

	@AfterEach
	public void after() {
		if (name != null) {
			configs.delete(namespace, name);
		}
	}

	@Test
	void createV1HTTPRouteAndCheckStatus() throws Exception {

		var before = routes.list(namespace).getObject().getItems().size();

		var route = new V1HTTPRoute();
		route.setApiVersion("v1");
		route.setKind("HTTPRoute");
		route.setApiVersion("gateway.networking.k8s.io/v1");

		var metadata = new V1ObjectMeta();
		metadata.setGenerateName("route-");
		metadata.setNamespace(namespace);
		route.setMetadata(metadata);

		var spec = new V1HTTPRouteSpec();
		spec.addHostnamesItem("test.example.com");
		V1HTTPRouteSpecRulesInner rule = new V1HTTPRouteSpecRulesInner();
		V1HTTPRouteSpecRulesInnerMatchesInner matches = new V1HTTPRouteSpecRulesInnerMatchesInner();
		matches.setPath(new V1HTTPRouteSpecRulesInnerMatchesInnerPath()
				.type(V1HTTPRouteSpecRulesInnerMatchesInnerPath.TypeEnum.PATHPREFIX).value("/"));
		rule.addMatchesItem(matches);
		rule.addBackendRefsItem(getBackend("primary", 8080, 90));
		rule.addBackendRefsItem(getBackend("secondary", 8080, 10));
		spec.addRulesItem(rule);
		route.setSpec(spec);

		var response = configs.create(route);
		Assertions.assertTrue(response.isSuccess());
		V1HTTPRoute result = response.getObject();
		assertThat(result).isNotNull();
		name = result.getMetadata().getName();
		Awaitility.await().atMost(Duration.ofMinutes(1)).until(() -> {
			KubernetesApiResponse<V1HTTPRoute> config = configs.get(namespace, result.getMetadata().getName());
			return config != null && //
					config.getObject() != null;
		});

		assertThat(routes.list(namespace).getObject().getItems().size()).isEqualTo(before + 1);

	}

	private V1HTTPRouteSpecRulesInnerBackendRefsInner getBackend(String name, int port, int weight) {
		V1HTTPRouteSpecRulesInnerBackendRefsInner backend = new V1HTTPRouteSpecRulesInnerBackendRefsInner();
		backend.setName(name);
		backend.setWeight(weight);
		backend.setPort(port);
		return backend;
	}

}
