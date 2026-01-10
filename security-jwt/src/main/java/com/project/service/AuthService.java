package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.config.JwtUtil;
import com.project.entity.LoginForm;
import com.project.entity.UserData;
import com.project.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
    private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	public String signupUser(UserData myUser) {
	    Optional<UserData> existUser = userRepository.findByUsername(myUser.getUsername());
	    
	    if(existUser.isPresent()) {  // Changed from != null to isPresent()
	        return "Username Already Existed, Please insert new User..!";
	    }
	    else {
	        String role = myUser.getRole().toUpperCase();
	        if (!role.startsWith("ROLE_")) {
	            role = "ROLE_" + role;
	        }
	        
	        UserData userInfo = new UserData(myUser.getUsername(), 
	                bCryptPasswordEncoder.encode(myUser.getPassword()), role);
	        
	        userRepository.save(userInfo);
	        return "User Created Successfully...!";
	    }
	}
	
	
	
//	public String authetication(String username, String password) {
//		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//		return jwtUtil.generateToken(userDetails);
//	}
	
	public String logInUser(@RequestBody LoginForm loginForm) {
	    try {	        
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
		            loginForm.getUsername(), 
		            loginForm.getPassword()
		    ));
	        
	        if (authenticate.isAuthenticated()) {
	            UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginForm.getUsername());
	            return jwtUtil.generateToken(userDetails);
	        }
	        return "Invalid Credential";
	        
	    } 
	    catch (AuthenticationException e) {
	        return "Invalid Credential: " + e.getMessage();
	    }
	}

}
