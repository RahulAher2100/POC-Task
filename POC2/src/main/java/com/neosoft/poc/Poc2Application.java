package com.neosoft.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@EntityScan
@SpringBootApplication
public class Poc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc2Application.class, args);
	}

}
