package com.example.ecommerce.commerceproductdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CommerceProductDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceProductDetailsApplication.class, args);
	}

}
