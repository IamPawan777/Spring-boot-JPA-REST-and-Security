package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userServie;
	
	@PostMapping("/add/user")
	public String addUser() {
		
		return "User added...";
	}
}
