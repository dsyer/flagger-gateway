/*
Copyright 2020 The Kubernetes Authors.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.kubernetes.client.examples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfig;
import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfigList;
import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfigSpec;
import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfigSpecRoutesInner;
import com.vmware.tanzu.models.V1SpringCloudGatewayRouteConfigSpecService;

import io.k8s.networking.gateway.models.V1HTTPRoute;
import io.k8s.networking.gateway.models.V1HTTPRouteList;
import io.kubernetes.client.examples.reconciler.ChildProvider;
import io.kubernetes.client.examples.reconciler.ChildReconciler;
import io.kubernetes.client.examples.reconciler.ParentReconciler;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.util.generic.GenericKubernetesApi;

@SpringBootApplication
public class SpringControllerExample {

	public static void main(String[] args) {
		SpringApplication.run(SpringControllerExample.class, args);
	}

	@Configuration
	public static class AppConfig {

		private static Log log = LogFactory.getLog(AppConfig.class);

		@Bean
		public CommandLineRunner commandLineRunner(SharedInformerFactory sharedInformerFactory, Controller controller) {
			return args -> Executors.newSingleThreadExecutor().execute(() -> {
				System.out.println("starting informers..");
				sharedInformerFactory.startAllRegisteredInformers();

				System.out.println("running controller..");
				controller.run();
			});
		}

		@Bean
		public Controller routeController(SharedInformerFactory sharedInformerFactory,
				ParentReconciler<?, ?> reconciler) {
			var builder = ControllerBuilder //
					.defaultBuilder(sharedInformerFactory)//
					.watch((q) -> ControllerBuilder.controllerWatchBuilder(V1HTTPRoute.class, q)
							.withResyncPeriod(Duration.ofHours(1)).build()) //
					.withWorkerCount(2);
			return builder.withReconciler(reconciler).withName("routeController").build();
		}

		@Bean
		public GenericKubernetesApi<V1SpringCloudGatewayRouteConfig, V1SpringCloudGatewayRouteConfigList> springRouteApi(
				ApiClient apiClient) {
			return new GenericKubernetesApi<>(V1SpringCloudGatewayRouteConfig.class,
					V1SpringCloudGatewayRouteConfigList.class, "tanzu.vmware.com", "v1",
					"springcloudgatewayrouteconfigs",
					apiClient);
		}

		@Bean
		public GenericKubernetesApi<V1HTTPRoute, V1HTTPRouteList> routeApi(ApiClient apiClient) {
			return new GenericKubernetesApi<>(V1HTTPRoute.class, V1HTTPRouteList.class, "gateway.networking.k8s.io",
					"v1",
					"httproutes", apiClient);
		}

		@Bean
		public SharedIndexInformer<V1HTTPRoute> nodeInformer(ApiClient apiClient,
				SharedInformerFactory sharedInformerFactory,
				GenericKubernetesApi<V1HTTPRoute, V1HTTPRouteList> routeApi) {
			return sharedInformerFactory.sharedIndexInformerFor(routeApi, V1HTTPRoute.class, 0);
		}

		@Bean
		public ParentReconciler<V1HTTPRoute, V1HTTPRouteList> routeReconciler(
				SharedIndexInformer<V1HTTPRoute> parentInformer, ApiClient routeApi,
				GenericKubernetesApi<V1SpringCloudGatewayRouteConfig, V1SpringCloudGatewayRouteConfigList> springRouteApi) {
			if (log.isDebugEnabled()) {
				routeApi.setDebugging(true);
			}
			return new ParentReconciler<>(parentInformer, routeApi,
					new ChildReconciler<>(springRouteApi, new SpringRouteReconciler()));
		}

		private static class SpringRouteReconciler
				implements ChildProvider<V1HTTPRoute, V1SpringCloudGatewayRouteConfig> {

			private static Log log = LogFactory.getLog(SpringRouteReconciler.class);

			@Override
			public void mergeBeforeUpdate(V1SpringCloudGatewayRouteConfig current,
					V1SpringCloudGatewayRouteConfig desired) {
				current.setSpec(desired.getSpec());
			}

			@Override
			public boolean semanticEquals(V1SpringCloudGatewayRouteConfig actual,
					V1SpringCloudGatewayRouteConfig desired) {
				return desired.getSpec().equals(actual.getSpec());
			}

			@Override
			public V1SpringCloudGatewayRouteConfig desired(V1HTTPRoute parent) {
				String name = parent.getMetadata().getName();
				V1SpringCloudGatewayRouteConfig config = new V1SpringCloudGatewayRouteConfig();
				config.setKind("SpringCloudGatewayRouteConfig");
				config.setApiVersion("tanzu.vmware.com/v1");
				var metadata = new V1ObjectMeta();
				metadata.setName(parent.getMetadata().getName());
				metadata.setNamespace(parent.getMetadata().getNamespace());
				config.setMetadata(metadata);
				V1SpringCloudGatewayRouteConfigSpecService service = new V1SpringCloudGatewayRouteConfigSpecService();
				service.setName(name);
				config.setSpec(new V1SpringCloudGatewayRouteConfigSpec());
				config.getSpec().setService(service);
				config.getSpec().setRoutes(new ArrayList<>());
				parent.getSpec().getRules().forEach(rule -> {
					rule.getBackendRefs().forEach(backend -> {
						V1SpringCloudGatewayRouteConfigSpecRoutesInner route = new V1SpringCloudGatewayRouteConfigSpecRoutesInner();
						route.addFiltersItem("stripPrefix=1");
						route.addFiltersItem("Weight=" + name + "," + backend.getWeight());
						route.addPredicatesItem("Path=/" + name);
						route.setUri("http://" + backend.getName() + ":" + backend.getPort());
						config.getSpec().getRoutes().add(route);
					});
				});
				return config;
			}
		}
	}

}
