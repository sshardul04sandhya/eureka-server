package com.example.ecommerce.commerceeurekaserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaServerApplication {

	private static final Logger LOGGER = LogManager.getLogger(NetflixEurekaServerApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("eureka server started..");
		SpringApplication.run(NetflixEurekaServerApplication.class, args);
	}

}
