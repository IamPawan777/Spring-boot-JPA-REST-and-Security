package com.project.dto;

import lombok.Data;

@Data
public class Rating {
	/*
	 * "rating": {
	 *  	"rate": 3, 
	 *  	"count": 400 
	 *  }
	 */
	
	private double rate;
	private int count;
}
