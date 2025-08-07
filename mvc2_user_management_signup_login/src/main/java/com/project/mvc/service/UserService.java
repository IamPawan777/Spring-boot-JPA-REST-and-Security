package com.project.mvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mvc.entity.UserDetails;
import com.project.mvc.repository.UserDetailsRepository;

@Service
public class UserService {

	@Autowired
	UserDetailsRepository userDetailsRepo;
	
	public String registerPage(String username, String email, String password) {
		System.out.println("received details...=>> "+username+" "+email+" "+password);
		
		Optional<UserDetails> byId = userDetailsRepo.findById(email);
		if(byId.isPresent()) {
			return "Failed Email already exist...";
		}
		else {		
			UserDetails user = new UserDetails();
			user.setEmailId(email);
			user.setUsername(username);
			user.setPassword(password);		
			userDetailsRepo.save(user);
			
			return "Successfully User AC created..";
		}
	}
	
	public String logInPage(String email, String password) {
		UserDetails byEmailIdAndPassword = userDetailsRepo.findByEmailIdAndPassword(email, password);
		
		if(byEmailIdAndPassword != null) {
			return "Welcome or environment : "+byEmailIdAndPassword.getUsername();
		}
		else {
			return "Invalid Credential plz try again..";
		}
	}
	
}
