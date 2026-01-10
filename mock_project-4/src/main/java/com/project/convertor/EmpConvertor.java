package com.project.convertor;

import com.project.Entity.Address;
import com.project.Entity.Employee;
import com.project.dto.AddressRequestDto;
import com.project.dto.RequestDto;
import com.project.dto.ResponseDto;

public class EmpConvertor {
	public static Employee requestDtoToEmployee(RequestDto requestDto) {
		return Employee.builder()
				.name(requestDto.getName())
				.age(requestDto.getAge())
				.address(addressToAddressResponse(address))
				.salary(requestDto.getSalary())
				.build();
	}
	
	public static ResponseDto employeeToResponseDto(Employee employee) {
		ResponseDto responseDto = new ResponseDto();
		responseDto.setName(employee.getName());
		responseDto.setAge(employee.getAge());
		responseDto.setAddress(employee.getAddress());
		return responseDto;
	}

	public static void updateEmployee(Employee employee, RequestDto requestDto) {
		employee.setName(requestDto.getName());
		employee.setAddress(requestDto.getAddress());
	}
	
	public static AddressRequestDto addressToAddressResponse(Address address) {
		return AddressRequestDto.builder()
				.city(address.getCity())
				.streetNo(address.getStreetNo())
				.build();
	}
	

}
