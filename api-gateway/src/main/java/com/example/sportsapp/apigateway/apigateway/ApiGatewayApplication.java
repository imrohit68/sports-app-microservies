package com.example.sportsapp.apigateway.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import java.time.Duration;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/sprotsApp/event/**")
						.filters( f -> f.rewritePath("/sprotsApp/event/(?<segment>.*)","/${segment}")
								.retry(retryConfig -> retryConfig.setRetries(3).setMethods(HttpMethod.GET).setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000),2,true))
								.circuitBreaker(config -> config.setName("event_circuit_breaker")
										.setFallbackUri("forward:/event/fallback")))
						.uri("lb://EVENT"))
				.route(p -> p
						.path("/sprotsApp/profile/**")
						.filters( f -> f.rewritePath("/sprotsApp/profile/(?<segment>.*)","/${segment}")
								.circuitBreaker(config -> config.setName("profile_circuit_breaker")
										.setFallbackUri("forward:/profile/fallback")))
						.uri("lb://PROFILE")).build();
	}

}
