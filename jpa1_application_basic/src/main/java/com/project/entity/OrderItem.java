package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {
	@Id
	private double orderId;
	private String catagory;
	private int totalItem;
	
//	public OrderItem() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public OrderItem(double orderId, String catagory, int totalItem) {
//		super();
//		this.orderId = orderId;
//		this.catagory = catagory;
//		this.totalItem = totalItem;
//	}
	
	
	
	public double getOrderId() {
		return orderId;
	}
	public void setOrderId(double orderId) {
		this.orderId = orderId;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	
	
}
