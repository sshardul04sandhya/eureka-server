package com.example.ecommerce.commerceeurekaserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CommerceEurekaServerApplication {

	private static final Logger LOGGER = LogManager.getLogger(CommerceEurekaServerApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("Eureka Main method::called");
		SpringApplication.run(CommerceEurekaServerApplication.class, args);
	}

}
