package com.sportsapppoc.users.users;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API DOCUMENTATION FOR USER MICROSERVICE",
				description = "SPORTS APP USER MICROSERVICE REST API DOCUMENTATION",
				version = "v1",
				contact = @Contact(
						name = " Rohit Singh",
						url = "www.rohitsingh.com",
						email = "sirohit328@gmail.com"
				)
		)
)
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
