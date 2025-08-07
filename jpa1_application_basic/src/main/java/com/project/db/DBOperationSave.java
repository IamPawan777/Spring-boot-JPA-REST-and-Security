package com.project.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.OrderItem;
import com.project.entity.Product;
import com.project.repository.OrderRepository;
import com.project.repository.ProductRepository;

@Component
public class DBOperationSave {
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	// save()
	public void addProductInfo() {
		Product product = new Product();
		product.setP_id(12);
		product.setName("Frizz");
		product.setP_cost(123.32);
		
		productRepo.save(product);
	}

	// save()
	public void addOrderInfo() {
		OrderItem order = new OrderItem();
		order.setOrderId(1.1);
		order.setCatagory("Electronics");
		order.setTotalItem(20);
		
		orderRepo.save(order);	
	}
	
	
}
