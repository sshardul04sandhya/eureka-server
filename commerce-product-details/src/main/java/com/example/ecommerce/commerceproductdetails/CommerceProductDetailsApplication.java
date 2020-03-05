package com.example.ecommerce.commerceproductdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@EnableHystrixDashboard
@EnableCircuitBreaker*/
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.example.ecommerce.commerceproductdetails.feignservice")
public class CommerceProductDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceProductDetailsApplication.class, args);
	}
	
		  @Bean
		  public RestTemplate getRestTemplate() 
		  { return new RestTemplate(); }
	 

}
