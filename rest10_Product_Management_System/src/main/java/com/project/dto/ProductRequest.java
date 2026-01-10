package com.project.dto;

import lombok.Data;

@Data
public class ProductRequest {
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private Double quantity;
}
