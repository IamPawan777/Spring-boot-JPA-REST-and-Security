package com.project.service;

import java.util.List;

import com.project.dto.ProductRequest;
import com.project.dto.ProductResponce;

public interface ProductService {
	
	public Boolean saveProduct(ProductRequest  product);
	
	public List<ProductResponce> getAllProduct();
	
	public ProductResponce getProductById(Integer id);
	
	public Boolean deleteProduct(Integer id);
}
