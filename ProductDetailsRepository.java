package com.example.demo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductDetailsRepository extends CrudRepository<ProductDetails, Long>{

//List<ProductDetails> findByProductnameIgnoreCase(String productName);
	List<ProductDetails> findByProductname(Optional<String> si);

	@Query("select b from ProductDetails b where b.productId = :productId")	
	List<ProductDetails> findByproductId(@Param("productId") Long productId);
	
	
}
