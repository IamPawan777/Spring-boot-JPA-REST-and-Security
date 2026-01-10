package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.LoginForm;
import com.project.entity.UserData;
import com.project.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody UserData myUser){
		try {
			String result = authService.signupUser(myUser);
	        return ResponseEntity.status(HttpStatus.OK).body(result);
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    }
	}
	
	
	//......RequestParam.........
//	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm){
		System.out.println("Entry: "+loginForm.getUsername()+" and "+loginForm.getPassword());
		return ResponseEntity.ok(authService.logInUser(loginForm));
	}
	
	
}
