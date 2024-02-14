package com.sportsapppoc.events.Events;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API DOCUMENTATION FOR EVENT MICROSERVICE",
				description = "SPORTS APP EVENT MICROSERVICE REST API DOCUMENTATION",
				version = "v1",
				contact = @Contact(
						name = " Rohit Singh",
						url = "www.rohitsingh.com",
						email = "sirohit328@gmail.com"
				)
		)
)
@EnableFeignClients
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

}
