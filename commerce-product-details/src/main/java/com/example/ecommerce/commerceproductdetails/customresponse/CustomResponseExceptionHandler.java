package com.example.ecommerce.commerceproductdetails.customresponse;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.ecommerce.commerceproductdetails.exception.ExceptionResponse;
import com.example.ecommerce.commerceproductdetails.exception.ProductNotFoundException;

public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(ProductNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleNotFoundException(ProductNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
	    return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	  }
	

}
