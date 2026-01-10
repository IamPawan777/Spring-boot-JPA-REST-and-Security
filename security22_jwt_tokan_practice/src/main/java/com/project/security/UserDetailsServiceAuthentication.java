package com.project.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.entiry.UserInformation;
import com.project.repository.UserRepository;

@Component
public class UserDetailsServiceAuthentication implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// load data form DB for specific user....
		Optional<UserInformation> byId = userRepository.findById(email);		// UserService
		
		if(byId.isPresent()) {
			System.out.println("UserDetailsService: Email found: "+email);
			//return username, password, roles
			return byId.get();
		}
		else {
			System.out.println("UserDetailsService: Email not found: "+email);
			throw new UsernameNotFoundException("User not found in DB: "+email);
		}
	}

}
