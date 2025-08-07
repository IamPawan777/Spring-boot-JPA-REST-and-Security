package com.project.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductCard {
	  private int id;
	  private int userId;
	  private List<ProductInfo> productInfo;
}
