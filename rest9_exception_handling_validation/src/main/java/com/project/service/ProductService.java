package com.project.service;

import org.springframework.stereotype.Service;

import com.project.dto.Product;

@Service
public class ProductService {
	
	public String addProduct(Product product) {				
		String name = product.getName();
		System.out.println(name.charAt(9));
		
		return "added successfully" ;
		
	}
	
}
