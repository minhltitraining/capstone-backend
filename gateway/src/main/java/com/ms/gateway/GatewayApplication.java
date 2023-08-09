package com.ms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	@Bean
	RouteLocator adminRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("ad", rs->rs.path("/admin/**")
				.uri("lb://app-admin"))
				.build();
	}
	
	@Bean
	RouteLocator vendorRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("vn", rs->rs.path("/ms/**")
				.uri("lb://app-vendor"))
				.build();
	}
	@Bean
	RouteLocator customerRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("cs", rs->rs.path("/customer/**")
				.uri("lb://app-customer"))
				.build();
	}
	@Bean
	RouteLocator feedbackRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("fb", rs->rs.path("/feedback/**")
				.uri("lb://app-feedback"))
				.build();
	}
	@Bean
	RouteLocator foodRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("fd", rs->rs.path("/food/**")
				.uri("lb://app-food"))
				.build();
	}
	@Bean
	RouteLocator cartRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("ct", rs->rs.path("/cart/**")
				.uri("lb://app-cart"))
				.build();
	}
}
