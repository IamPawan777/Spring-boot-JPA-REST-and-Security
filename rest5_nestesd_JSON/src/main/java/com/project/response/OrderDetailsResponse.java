package com.project.response;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsResponse {
	private String name;
//	private String email;
//	private String mobile;
	private String totalAmount;
	
	private List<ProductInfoResponse> productinfo;
	
	private DelivaryAddressResponse delivaryAddress;
	
	private PaymentDetailsResponse paymentDetails;
}
