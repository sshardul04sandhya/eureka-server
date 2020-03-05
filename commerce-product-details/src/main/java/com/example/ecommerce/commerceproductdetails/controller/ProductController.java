package com.example.ecommerce.commerceproductdetails.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.ecommerce.commerceproductdetails.feignservice.CustomerFeign;
import com.example.ecommerce.commerceproductdetails.model.ProductEntity;
import com.example.ecommerce.commerceproductdetails.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	ProductService productService;

	@Autowired
	private CustomerFeign customerFeign;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public ResponseEntity<List<ProductEntity>> getProductList() {
		LOGGER.info("running port::" + Integer.parseInt(environment.getProperty("server.port")));
		LOGGER.info("get list of Product::" + productService.getProductList());
		return new ResponseEntity<List<ProductEntity>>(productService.getProductList(), new HttpHeaders(),
				HttpStatus.OK);

	}

	@GetMapping("/productCode/{product_code}")
	public ResponseEntity<ProductEntity> getProductListByProductCode(@PathVariable("product_code") Long product_code) {
		LOGGER.info("get Product based on productCode::" + productService.getProductByCode(product_code));
		return new ResponseEntity<ProductEntity>(productService.getProductByCode(product_code), new HttpHeaders(),
				HttpStatus.OK);

	}

	@GetMapping("/brandName/{brandName}")
	public ResponseEntity<List<ProductEntity>> getProductListByBrandNameCode(
			@PathVariable("brandName") String brandName) {
		LOGGER.info("get Product based on brandName::" + productService.getProductByBrandName(brandName));
		return new ResponseEntity<List<ProductEntity>>(productService.getProductByBrandName(brandName),
				new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping("/productName/{productName}")
	public ResponseEntity<List<ProductEntity>> getProductListByProductName(
			@PathVariable("productName") String productName) {
		LOGGER.info("get Product based on brandName::" + productService.getProductByProductName(productName));
		return new ResponseEntity<List<ProductEntity>>(productService.getProductByProductName(productName),
				new HttpHeaders(), HttpStatus.OK);

	}

	/*
	 * 
	 * calling other microservice with using restTemplate
	 * 
	 * @GetMapping("/customerInfo") public ResponseEntity<List<Object>>
	 * getCustomerInfo() { List<Object> response = (List<Object>)
	 * restTemplate.getForObject("http://localhost:8097/customers", Object.class);
	 * LOGGER.info("get list of Customer::" + response); return new
	 * ResponseEntity<List<Object>>(response, HttpStatus.OK); }
	 */
	/*
	 * calling other microservices with using feignclient
	 */
	@GetMapping("/customers")
	public ResponseEntity<Object> getFeigncustomer() {
		ResponseEntity<Object> response = customerFeign.getCustomerList();
		LOGGER.info("get list of Customer::" + response);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping("/fallbackdemo")
   // @HystrixCommand(fallbackMethod = "callCustomerList_Fallback")
	public String getFallBackcustomer() {
		String res = customerFeign.getCustomerFallBack();
		return "Product Controller Details::getFallBack"+res;
	}
	
    public String callCustomerList_Fallback() {
        System.out.println("Customer Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!! No Response From Customer Service at this moment. " +
        " Service will be back shortly - " + new Date();
    }

}
