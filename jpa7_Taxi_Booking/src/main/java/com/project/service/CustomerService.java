package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.request.CustomerRequest;
import com.project.dto.response.CustomerResponse;
import com.project.entity.Customer;
import com.project.repository.CustomerRepository;
import com.project.service.exceptions.CustomerNotFoundException;
import com.project.transformer.CustomerTransformer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository  customerRepository;
	
	public CustomerResponse addCustomer(CustomerRequest customerRequest) {
		
		Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);			//DTO -> Entity
		
		Customer saveCustomer =  customerRepository.save(customer);
		
		CustomerResponse customerResponse = CustomerTransformer.customerTocustomerResponse(saveCustomer);				//Entity -> DTO
		return customerResponse;
	}

	
	public CustomerResponse getCustomer(int customerId) {
		 Optional<Customer> id = customerRepository.findById(customerId);
		 if(id.isEmpty()) {
			 throw new CustomerNotFoundException("Invalid Customer Id...");
		 }
		 
		 Customer saveCustomer = id.get();
		 
		 // Entity -> DTO
		 CustomerResponse customerResponse = CustomerTransformer.customerTocustomerResponse(saveCustomer);				//Entity -> DTO
		 return customerResponse;
	}


	public List<CustomerResponse> getAdult(int age) {
		List<Customer> byAgeGreaterThan = customerRepository.findByAgeGreaterThan(age);
		// Entity to DTO
		List<CustomerResponse> customerResponses = new ArrayList<>();
		for(Customer customer : byAgeGreaterThan) {
			customerResponses.add(CustomerTransformer.customerTocustomerResponse(customer));
		}
		return customerResponses;
	}
	
	
	

}
