package com.project.dto;

import com.project.Entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	private String name;
	private Integer age;
	private AddressResponseDto address;
}
