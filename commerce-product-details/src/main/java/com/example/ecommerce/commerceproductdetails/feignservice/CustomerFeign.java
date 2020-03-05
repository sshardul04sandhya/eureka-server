package com.example.ecommerce.commerceproductdetails.feignservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RibbonClient(name = "commerce-customer-info")
@FeignClient(name = "commerce-customer-info")
public interface CustomerFeign {

	@GetMapping("/customers")
    public ResponseEntity<Object> getCustomerList();
	
	@GetMapping("/customers/fallbackdemo")
	public String getCustomerFallBack();
}
