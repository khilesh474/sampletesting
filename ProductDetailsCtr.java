package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsCtr {

	
	@Autowired
	private ProductDetailsRepository repository;
	
	
	@RequestMapping(value="/ProductDetails", method=RequestMethod.GET)
	ResponseEntity<Object> getProductDetails(@RequestParam("si") Optional<String> si){
		try {
		Iterable<ProductDetails> res;
		if(si.isPresent())
			res = repository.findByProductname(si);
		else
			res = repository.findAll();
		return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>( new MyJSONWrapper("Error", e.getMessage()), HttpStatus.BAD_REQUEST);	
			
		}				
	}
	
	@RequestMapping(value="/ProductDetails/{id}", method=RequestMethod.GET)
	ResponseEntity<Object> getProductDetailsById(@PathVariable("id") Long id){
		try {
		Optional<ProductDetails> res = repository.findById(id);
		
		if(res.isPresent()) {
			return new ResponseEntity<Object>(res, HttpStatus.OK);			
		}
		else
			return new ResponseEntity<Object>(new MyJSONWrapper("Error", "No such object"), HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<Object>( new MyJSONWrapper("Error", e.getMessage()), HttpStatus.BAD_REQUEST);						
		}		
	}
	@RequestMapping(value="/ProductDetails", method = RequestMethod.POST)
	ResponseEntity<Object> insertUser(@RequestBody ProductDetails u) {
		try {
			ProductDetails res = repository.save(u);
		return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>( new MyJSONWrapper("Error", e.getMessage()), HttpStatus.BAD_REQUEST);						
		}		
		
	}
	
	@RequestMapping(value = "/ProductDetails/{id}", method = RequestMethod.PUT)
	ResponseEntity<Object> updateUser(@RequestBody ProductDetails u, @PathVariable("id") Long id){
		try {
		u.setProductId(id);
		ProductDetails res = repository.save(u);
		return new ResponseEntity<Object>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>( new MyJSONWrapper("Error", e.getMessage()), HttpStatus.BAD_REQUEST);						
		}		
	}
	
	@RequestMapping(value = "/ProductDetails/{id}", method = RequestMethod.DELETE)
	ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
		try {
		Optional<ProductDetails> u = repository.findById(id);

		if(u.isPresent()) {
			repository.delete(u.get());
			return new ResponseEntity<Object>(new MyJSONWrapper("deleted"), HttpStatus.OK);			
		}
		else
			return new ResponseEntity<Object>(new MyJSONWrapper("Error","no such object."), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Object>( new MyJSONWrapper("Error", e.getMessage()), HttpStatus.BAD_REQUEST);						
		}		
	}
}




