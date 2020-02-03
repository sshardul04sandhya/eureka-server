package com.example.ecommerce.commerceproductdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ecommerce.commerceproductdetails.exception.ProductNotFoundException;
import com.example.ecommerce.commerceproductdetails.model.ProductEntity;
import com.example.ecommerce.commerceproductdetails.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	/*
	 * getting list of product
	 */
	public List<ProductEntity> getProductList() {
		List<ProductEntity> productList = (List<ProductEntity>) repository.findAll();

		if (productList.size() > 0) {
			return productList;
		} else {
			return new ArrayList<ProductEntity>();
		}
	}

	/*
	 * getting product based on productCode
	 */
	public ProductEntity getProductByCode(Long product_code) {
		Optional<ProductEntity> pe = repository.findById(product_code);

		if (pe.isPresent()) {
			return pe.get();
		} else {
			throw new ProductNotFoundException("product: " + product_code + " not Found");
		}
	}

	/*
	 * getting product based on brandName
	 */
	public List<ProductEntity> getProductByBrandName(String brandName) {
		List<ProductEntity> pe = repository.findByBrandName(brandName);
		if (pe.size() > 0) {
			return pe;
		} else {
			return new ArrayList<ProductEntity>();
		}

	}

	/*
	 * getting product based on productName
	 */
	public List<ProductEntity> getProductByProductName(String productName) {
		List<ProductEntity> pe = repository.findByProductName(productName);
		if (pe.size() > 0) {
			return pe;
		} else {
			return new ArrayList<ProductEntity>();
		}

	}
}
