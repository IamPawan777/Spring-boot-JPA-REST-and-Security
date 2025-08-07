package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.service.UserService;

@Controller
public class MainController {
	
//	@Autowired								// setter injection
	private UserService userService;			
	
//	public MainController(UserService userService) {		// Constructor Injection
//		this.userService = userService;
//	}
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/createUser")
	public String registerUser() {
		String msg = userService.saveUser();
		System.out.println(msg);
		return "success";
	}
}
