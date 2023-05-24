package com.neosoft.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceEurekaServerApplication.class, args);
	}

}
