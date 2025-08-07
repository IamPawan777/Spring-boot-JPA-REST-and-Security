package com.project.entity;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int id;
	private String p_name;
	private double p_rate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public double getP_rate() {
		return p_rate;
	}
	public void setP_rate(double p_rate) {
		this.p_rate = p_rate;
	}
	
}
