package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder rlb) {
		return rlb
				.routes()
				.route(spec -> spec
						.path("/usd-rates")
						.uri("http://api.fixer.io:80/latest?base=USD")
				)
				// you can add as many routes as you want
				// the routes can have custom filters that
				// rate limit the requests, contribute
				// custom headers, rewrite the URLs, etc.
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
