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

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerResponse addCustomer(CustomerRequest customerRequest) {
		// DTO -> Entity
		Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
		Customer saveCustomer =  customerRepository.save(customer);
		// Entity -> DTO
		CustomerResponse customerResponse = CustomerTransformer.customerTocustomerResponse(saveCustomer);				
		return customerResponse;
	}

	
	public CustomerResponse getCustomer(int customerId) {
		 Optional<Customer> id = customerRepository.findById(customerId);
		 if(id.isEmpty()) {
			 throw new CustomerNotFoundException("Invalid Customer Id...");
		 }		 
		 Customer saveCustomer = id.get();
		 // Entity -> DTO
		 return CustomerTransformer.customerTocustomerResponse(saveCustomer);			
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


	public List<CustomerResponse> getAll() {
		List<Customer> allCustomer = customerRepository.findAll();
		// Entity to DTO
		List<CustomerResponse> customerResponses = new ArrayList<>();
		for(Customer customer : allCustomer) {
			customerResponses.add(CustomerTransformer.customerTocustomerResponse(customer));
		}
		return customerResponses;
	}


	public String updatePassword(String emailId, String newPassword) {
		Optional<Customer> byId = customerRepository.findByEmailId(emailId);
		if (byId.isPresent()) {
			Customer user = byId.get();
			user.setPassword(newPassword);
			customerRepository.save(user);
			return "password updated..Successfully..!";
		}
		else {
			return "E-mail id not found..Failed..!";
		}
	}


	  @Transactional
	public String deleteByEmail(String emailId) {
		Optional<Customer> byId = customerRepository.findByEmailId(emailId);
		if(byId.isPresent()) {
			customerRepository.deleteByEmailId(emailId);
			return "Deleted Successfully..!";			
		}
		else {
			return "Email-Id not present..Failed..!";
		}
	}

}
