package com.project.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoRequest {
	private int pProductId;
	private String pName;
	private double pPrice;
	private int pQuantity;
	private List<String> pSpecification;
}
