package com.project.dto;

import com.project.Entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
	private String name;
	private Integer age;
	private AddressRequestDto address;
	private Float salary;
}
