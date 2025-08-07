package com.project.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsRequest {
	private double pPaidAmount;
	private String pStatus;
	private String pBankTransaction;
}
