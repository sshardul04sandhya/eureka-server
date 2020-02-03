package com.example.ecommerce.commerceproductdetails.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String message) {
		    super(message);
		  }	  
}