package com.example.demo;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  
	  private Long productId;
	  private String productName;
	  private Double productPrice;
	  private String productDetails;
	  private Image productImage;
	
	  
	  
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public Image getProductImage() {
		return productImage;
	}
	public void setProductImage(Image productImage) {
		this.productImage = productImage;
	}
	  
	  

}
