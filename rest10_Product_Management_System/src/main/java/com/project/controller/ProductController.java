package com.project.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ProductRequest;
import com.project.dto.ProductResponce;
import com.project.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest){
		Boolean saveProduct = productService.saveProduct(productRequest);
		
		if(saveProduct == false) {
			return new ResponseEntity<>("Product not save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("save successfully", HttpStatus.CREATED);		
	}
	
	
	
	
	@GetMapping("/getProducts")
	public ResponseEntity<?> getProduct(){
		List<ProductResponce> allProduct = productService.getAllProduct();
		
		if(CollectionUtils.isEmpty(allProduct)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(allProduct, HttpStatus.FOUND);		
	}
	
	
	
	
	
	@GetMapping("/getProductId/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) {
	    ProductResponce productById = productService.getProductById(id);

	    if (productById == null) {
	        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	    }

	    return new ResponseEntity<>(productById, HttpStatus.OK);
	}

	
	
	
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Integer id){
		 Boolean deleteProduct = productService.deleteProduct(id);
		
		if(!deleteProduct) {
			return new ResponseEntity<>("Product not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("Delete Success", HttpStatus.OK);		
	}
	
	
	
	
	
	
	
	
	
}
