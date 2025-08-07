package com.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Product {
	
	@NotEmpty(message = "should not be empty")
	@NotNull(message = "should not be null")
	@NotBlank(message = "should not be blanck")
	private String id;
	
	@NotEmpty(message = "should not be empty")
	@NotNull(message = "should not be null")
	@NotBlank(message = "should not be blanck")
	private String name;
	
//	@Email
	@NotEmpty(message = "should not be empty")
	@NotNull(message = "should not be null")
	@NotBlank(message = "should not be blanck")
	private String price;
}
