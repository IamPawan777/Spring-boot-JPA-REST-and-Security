package com.project.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoResponse {
	private int pProductId;
	private String pName;
	private double pPrice;
	private int pQuantity;
	private List<String> pSpecification;
}
