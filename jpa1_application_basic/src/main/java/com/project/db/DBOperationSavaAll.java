package com.project.db;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Product;
import com.project.repository.ProductRepository;

@Component
public class DBOperationSavaAll {
	
	@Autowired
	ProductRepository productRepo;
	
	// saveAll()
	public void addProductSaveAll() {
		List<Product> list = new ArrayList<>();
		list.add(new Product(13, "Television", 12.3));
		list.add(new Product(11, "Mouse", 22.13));
		list.add(new Product(22, "Monitor", 99.12));
		list.add(new Product(33, "Fan", 1000.1));
		
		productRepo.saveAll(list);
	}
	
	// count()
	public void checkNoOfRows() {
		long count = productRepo.count();
		System.out.println("No of Rows:"+count);
	}
	
	// deleteAll()
	public void deleteAllRecords() {
		productRepo.deleteAll();
	}	
	
	public void getAllRecords() {
		List<Product> list = productRepo.findAll();
		list.forEach(System.out::println);
	}
}
