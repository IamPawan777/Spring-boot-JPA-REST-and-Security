package com.project.dto;

import lombok.Data;

@Data
public class NetBankingInformation {
	private String username;
	private String password;
	private double amountToBePaid;
}
