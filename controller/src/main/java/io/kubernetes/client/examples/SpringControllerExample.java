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
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.kubernetes.client.examples.models.HTTPRoute;
import io.kubernetes.client.examples.models.HTTPRouteList;
import io.kubernetes.client.examples.reconciler.ParentReconciler;
import io.kubernetes.client.examples.reconciler.SubReconciler;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.extended.controller.reconciler.Result;
import io.kubernetes.client.informer.SharedIndexInformer;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
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
					.watch((q) -> ControllerBuilder.controllerWatchBuilder(HTTPRoute.class, q)
							.withResyncPeriod(Duration.ofHours(1)).build()) //
					.withWorkerCount(2);
			return builder.withReconciler(reconciler).withName("routeController").build();
		}

		@Bean
		public GenericKubernetesApi<HTTPRoute, HTTPRouteList> routeApi(ApiClient apiClient) {
			return new GenericKubernetesApi<>(HTTPRoute.class, HTTPRouteList.class, "gateway.networking.k8s.io", "v1",
					"httproutes", apiClient);
		}

		@Bean
		public SharedIndexInformer<HTTPRoute> nodeInformer(ApiClient apiClient,
				SharedInformerFactory sharedInformerFactory,
				GenericKubernetesApi<HTTPRoute, HTTPRouteList> routeApi) {
			return sharedInformerFactory.sharedIndexInformerFor(routeApi, HTTPRoute.class, 0);
		}

		@Bean
		public ParentReconciler<HTTPRoute, HTTPRouteList> routeReconciler(
				SharedIndexInformer<HTTPRoute> parentInformer, ApiClient routeApi) {
			if (log.isDebugEnabled()) {
				routeApi.setDebugging(true);
			}
			return new ParentReconciler<>(parentInformer, routeApi,
					new SubReconciler<HTTPRoute>() {

						@Override
						public Result reconcile(HTTPRoute parent) {
							log.info("Reconciling: " + parent.getKind() + " - " + parent.getMetadata().getName());
							return new Result(false);
						}

					});
		}

	}

}
