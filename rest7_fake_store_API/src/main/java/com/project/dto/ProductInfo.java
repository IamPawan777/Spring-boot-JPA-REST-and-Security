package com.project.dto;

import lombok.Data;

@Data
public class ProductInfo {
	
	
	/*
	 * { 
	 * "id": 7, 
	 * "title": "White Gold Plated Princess", 
	 * "price": 9.99,
	 * "description":"Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her. Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentine's Day..."
	 *  "category": "jewelery", 
	 *  "image":"https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg", 
	 *  "rating": { 
	 *  		"rate": 3, 
	 *  		"count": 400 
	 *  		} 
	 *  }
	 */
	
	
	private int id;
	private String title;
	private double price;
	private String description;
	private String category;
	private String image;
	private Rating rating;
}
