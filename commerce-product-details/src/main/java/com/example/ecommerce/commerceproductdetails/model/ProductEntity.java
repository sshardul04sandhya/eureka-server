package com.example.ecommerce.commerceproductdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

	@Column(name = "product_brand_name")
	private String brandName;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private String price;

	@Id
	@Column(name = "product_code")
	private Long product_code;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Long product_code) {
		this.product_code = product_code;
	}

	@Override
	public String toString() {
		return "ProductEntity [brandName=" + brandName + ", productName=" + productName + ", price=" + price
				+ ", product_code=" + product_code + "]";
	}

	public ProductEntity(String brandName, String productName, String price) {
		super();
		this.brandName = brandName;
		this.productName = productName;
		this.price = price;
	}

	protected ProductEntity() {
	}

}
