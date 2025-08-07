package com.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.project.items.Items;

@Component("pdt")
public class Product {
	private int p_id;
	
	@Qualifier("itm2")
	@Autowired				// field injection 
	private Items item;
	
	public Product() {
		super();
		System.out.println("Product Class...");
	}
	public Product(int p_id) {
		super();
		this.p_id = p_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}
	
}
