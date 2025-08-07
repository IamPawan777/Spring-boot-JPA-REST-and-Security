package com.project.dto;

import lombok.Data;

@Data
public class CreaditCardInformation {
	private long cardNumber;
	private int cvv;
	private String expManthYear;
	private String amountToBePaid;
}
