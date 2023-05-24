package com.neosoft.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApiGatewayApplication.class, args);
	}

}
