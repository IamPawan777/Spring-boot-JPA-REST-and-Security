package com.project.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsRequest {
	private String name;
	private String email;
	private String mobile;
	private String totalAmount;
	
	private List<ProductInfoRequest> productinfo;
	
	private DelivaryAddressRequest delivaryAddress;
	
	private PaymentDetailsRequest paymentDetails;
}
