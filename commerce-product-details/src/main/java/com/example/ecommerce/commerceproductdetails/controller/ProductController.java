package com.example.ecommerce.commerceproductdetails.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.ecommerce.commerceproductdetails.exception.ProductNotFoundException;
import com.example.ecommerce.commerceproductdetails.model.ProductEntity;
import com.example.ecommerce.commerceproductdetails.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;

	@GetMapping
    public ResponseEntity<List<ProductEntity>> getProductList() {
		//List<ProductEntity> pe = productService.getProductList();
		LOGGER.info("get list of Product::"+productService.getProductList());
        return new ResponseEntity<List<ProductEntity>>(productService.getProductList(), new HttpHeaders(), HttpStatus.OK);
     
	}
	
	@GetMapping("/productCode/{product_code}")
    public ResponseEntity<ProductEntity> getProductListByProductCode(@PathVariable("product_code") Long product_code)
     {
		//ProductEntity pList = productService.getProductByCode(product_code);
		LOGGER.info("get Product based on productCode::"+productService.getProductByCode(product_code));
		return new ResponseEntity<ProductEntity>(productService.getProductByCode(product_code),new HttpHeaders(), HttpStatus.OK);
     
	}
	
	@GetMapping("/brandName/{brandName}")
    public ResponseEntity<List<ProductEntity>> getProductListByBrandNameCode(@PathVariable("brandName") String brandName)
    {
		//List<ProductEntity> pList = productService.getProductByBrandName(brandName);
		LOGGER.info("get Product based on brandName::"+productService.getProductByBrandName(brandName));
	   return new ResponseEntity<List<ProductEntity>>(productService.getProductByBrandName(brandName),new HttpHeaders(), HttpStatus.OK);
     
	}
	
	@GetMapping("/productName/{productName}")
    public ResponseEntity<List<ProductEntity>> getProductListByProductName(@PathVariable("productName") String productName)
     {
		//List<ProductEntity> pList = productService.getProductByProductName(productName);
		LOGGER.info("get Product based on brandName::"+productService.getProductByProductName(productName));
	   return new ResponseEntity<List<ProductEntity>>(productService.getProductByProductName(productName),new HttpHeaders(), HttpStatus.OK);
     
	}
	
	
}
