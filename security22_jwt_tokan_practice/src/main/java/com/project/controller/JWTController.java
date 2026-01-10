package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.rolesEnum.Role;
import com.project.security.JWTUtil;

@RestController
public class JWTController {
	
	@Autowired
	JWTUtil jwtUtil;
	
	@GetMapping("/jwt/create/token/{emailId}")
	public String getToken(@PathVariable String emailId, String fullname, String role) {
		return jwtUtil.createToken(emailId, fullname, role );
	}
	
	@GetMapping("/jwt/validate/token")
	public boolean validToken() {
		return jwtUtil.isValidToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhQGdtYWlsLmNvbSIsImlhdCI6MTc1NTYzODQ2NSwiZXhwIjoxNzU1NjM4NzY1fQ.t-B3cQz5C0Owm7EfHCOIOt22NgSP8MCaL7VXFJxblXARmMhUwInEFAciW8gF9SrRr7pBevyQzEAsA2tnRBdIZw", "a@gmail.com");
	}
}
