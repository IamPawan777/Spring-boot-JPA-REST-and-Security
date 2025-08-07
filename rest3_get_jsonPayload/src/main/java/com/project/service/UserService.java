package com.project.service;

import org.springframework.stereotype.Service;

import com.project.request.UserDetails;

@Service
public class UserService {
	
	public String userSignUp(UserDetails userDetails) {
		return "User sign up successfully";
	}
}
