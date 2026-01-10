package com.project.transformer;

import com.project.dto.request.CustomerRequest;
import com.project.dto.response.CustomerResponse;
import com.project.entity.Customer;


// this class host entity to DTO and vice versa things...
public class CustomerTransformer {
	//DTO -> Entity
	public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
//		Customer customer = new Customer();
//		customer.setName(customerRequest.getName());
//		customer.setAge(customerRequest.getAge());
//		customer.setEmailId(customerRequest.getEmailId());
//		customer.setGender(customerRequest.getGender());
//		return customer;
		return Customer.builder()
				.name(customerRequest.getName())
				.age(customerRequest.getAge())
				.emailId(customerRequest.getEmailId())
				.password(customerRequest.getPassword())
				.gender(customerRequest.getGender())
				.build();
	}
	
	
	// Entity -> DTO
	public static CustomerResponse customerTocustomerResponse(Customer customer) {
//		CustomerResponse customerResponse = new  CustomerResponse();
//		customerResponse.setName(customer.getName());
//		customerResponse.setAge(customer.getAge());
//		customerResponse.setEmailId(customer.getEmailId());
//		return customerResponse;
		CustomerResponse customerResponse = CustomerResponse.builder()
				.name(customer.getName())
				.age(customer.getAge())
				.emailId(customer.getEmailId())
				.build();
		return customerResponse;

	}
}
