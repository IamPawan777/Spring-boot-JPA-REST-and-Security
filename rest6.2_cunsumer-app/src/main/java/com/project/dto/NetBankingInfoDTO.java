package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NetBankingInfoDTO {
	private String username;
	private String password;
	
	private double amountToBePaid;
	// or
//	@JsonProperty("amountToBePaid")
//	private double amount;
}
