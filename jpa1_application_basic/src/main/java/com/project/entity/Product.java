package com.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_Table")
public class Product {
	@Id
	private int p_id;	
	private String name;
	@Column(name="Rate")	
	private double p_cost;

	
	
	
//	public Product(int p_id, String name, double p_cost) {
//		super();
//		this.p_id = p_id;
//		this.name = name;
//		this.p_cost = p_cost;
//	}
//
//	public Product() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getP_cost() {
		return p_cost;
	}

	public void setP_cost(double p_cost) {
		this.p_cost = p_cost;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", name=" + name + ", p_cost=" + p_cost + "]";
	}

	
}
