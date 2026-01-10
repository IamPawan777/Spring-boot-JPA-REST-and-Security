package com.project.controller;

//import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ChangePasswordDto;
import com.project.dto.UserInformationDto;
import com.project.dto.UserLoginDto;
import com.project.security.JWTUtil;
import com.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
//	@PostMapping("/public/user/signup")
//	public String signupUser(@RequestBody UserInformationDto userInformationDto) {
//		return userService.signupUser(userInformationDto);
//	}
	
	@PostMapping("public/user/signup")
	public ResponseEntity<?> signupUser(@RequestBody UserInformationDto userInformationDto) {
        try {
            String result = userService.signupUser(userInformationDto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	
	

	@PostMapping("/public/user/signin")
	public ResponseEntity<?> signinUser(@RequestBody UserLoginDto userLoginDto) {
		// validation credential...username and password
		
		String response = null;
		
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword());
		try {
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//			System.out.println("Credential are:"+authenticate.getCredentials());
//			authenticate.get
		}
		catch (BadCredentialsException e) {
			System.out.println("UserController: bad Credential in DB.");
			response = "User not present in DB. Register First...!";
			return new ResponseEntity<String>(response, HttpStatusCode.valueOf(401));
		}
		
//		return userService.signinUser(userLoginDto);
		String token = jwtUtil.createToken(userLoginDto.getEmail());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		
		return new ResponseEntity<String>("Welcome to Home: "+userLoginDto.getEmail(), headers, HttpStatusCode.valueOf(200));
	}
	
	
	
//	@PreAuthorize("hasRole('USER')")
	@PostMapping("/api/user/change/password/{userId}")
	public String changePassword(@RequestBody ChangePasswordDto changePassword, @PathVariable String userId) {
		System.out.println("Controller: finally password changing");
		return userService.changePassword(changePassword, userId);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hashRole('USER')  ")
	@DeleteMapping("/api/user/delete/user/{userId}")
	public String deleteProfile(@PathVariable String userId) {
		return userService.deleteProfile(userId);
	}
	
	
}
