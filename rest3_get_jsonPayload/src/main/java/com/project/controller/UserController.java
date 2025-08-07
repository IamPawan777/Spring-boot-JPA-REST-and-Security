package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.request.Address;
import com.project.request.UserDetails;
import com.project.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/signup")
	public String userSignup(@RequestBody UserDetails userDetails) {
		System.out.println(userDetails);
		String str = userService.userSignUp(userDetails);
		return str;		
	}
	
	@PostMapping("/address")
	public String addAddress(@RequestBody Address address) {
		System.out.println(address);
		return "address add successfully....";
	}
	
	@GetMapping("/address")				
//	@ResponseBody														automatically added by Rest-Controller..
	public Address getAddress() {
		Address address = new Address();
		address.setArea("Dillon");
		address.setCity("Kerala");
		address.setCountary("Pakishtan");
		address.setPincode(77777777);
		address.setState("Goa");
		return address;
	}
}
