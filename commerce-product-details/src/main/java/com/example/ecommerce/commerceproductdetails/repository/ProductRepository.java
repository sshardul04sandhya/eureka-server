package com.example.ecommerce.commerceproductdetails.repository;

import java.util.List;
import java.util.Optional;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.commerceproductdetails.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>{

	
	public List<ProductEntity> findByBrandName(String productName);
	public List<ProductEntity> findByProductName(String productName);
}
