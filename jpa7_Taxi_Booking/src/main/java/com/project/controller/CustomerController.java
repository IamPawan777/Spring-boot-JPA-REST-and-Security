package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.request.CustomerRequest;
import com.project.dto.response.CustomerResponse;
import com.project.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.addCustomer(customerRequest);
	}
	
	@GetMapping("/get/customer-id/{id}")
	public CustomerResponse getCustomer(@PathVariable("id") int customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@GetMapping("/get/adult")
	public List<CustomerResponse> getAdult(@RequestParam int age){
		return customerService.getAdult(age);
	}
}
