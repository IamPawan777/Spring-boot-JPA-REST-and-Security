package com.project.controller;

import java.util.Map;

//import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.ChangePasswordDto;
import com.project.dto.UserInformationDto;
import com.project.dto.UserLoginDto;
import com.project.entiry.UserInformation;
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
	
	
	
	@PostMapping("public/user/signup")
	public ResponseEntity<?> signupUser(@RequestBody UserInformationDto userInformationDto) {
        try {
            String result = userService.signupUser(userInformationDto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	

	@PostMapping("public/user/signin")
	public ResponseEntity<?> signinUser(@RequestBody UserLoginDto userLoginDto) {
		// validation credential...username and password
		
		String response = null;
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//			System.out.println("Credential are:"+authenticate.getCredentials());

//			String token = jwtUtil.createToken(userLoginDto.getEmail(), userLoginDto.getPassword(), userLoginDto.getRole());
			UserInformation user = (UserInformation) authenticate.getPrincipal();
            
            // FIXED: Correct parameter order - email, role, fullName
            String token = jwtUtil.createToken(
                user.getEmail(), 
                user.getRole().name(),  // This gets the actual role from the authenticated user
                user.getFullName()      // This gets the full name from the authenticated user
            );
			HttpHeaders headers = new HttpHeaders();
		    headers.add("Authorization", token);
				
		    return new ResponseEntity<String>("Welcome " + user.getFullName() + "! Role: " + user.getRole(), headers, HttpStatus.OK);
		}
		catch (BadCredentialsException e) {
			System.out.println("UserController: bad Credential in DB.");
			response = "User not present in DB. Register First...!";
			return new ResponseEntity<String>(response, HttpStatusCode.valueOf(401));
		}
		catch (Exception e) {
            response = "Authentication failed: " + e.getMessage();
            return new ResponseEntity<String>(response, HttpStatus.UNAUTHORIZED);
        }	
		
	}
	

	
		@PostMapping("api/user/change/password/{userId}")
		@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
	    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto changePassword, @PathVariable String userId) {
	        try {
	            System.out.println("Controller: finally password changing");
	            String result = userService.changePassword(changePassword, userId);
	            return ResponseEntity.ok(result);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	
	
		
		@DeleteMapping("/api/user/delete/user/{userId}")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public ResponseEntity<?> deleteProfile(@PathVariable String userId) {
	        try {
	            String result = userService.deleteProfile(userId);
	            return ResponseEntity.ok(result);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	
	
	
	  // Add a new endpoint for admin dashboard
	 	@PostMapping("/api/admin/dashboard")
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	    public ResponseEntity<?> adminDashboard() {
	        return ResponseEntity.ok("Admin Dashboard - Access granted");
	    }
	    
	    @PostMapping("/api/user/dashboard")
	    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
	    public ResponseEntity<?> userDashboard() {
	        return ResponseEntity.ok("User Dashboard - Access granted");
	    }
	    
	    @PostMapping("/public/debug/token")
	    public ResponseEntity<?> debugToken(@RequestHeader(value = "Authorization", required = false) String authHeader) {
	        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	            return ResponseEntity.badRequest().body("No valid Authorization header");
	        }
	        
	        String token = authHeader.substring(7);
	        try {
	            String userId = jwtUtil.getUserIdFromToken(token);
	            String role = jwtUtil.getRoleFromToken(token);
	            String fullName = jwtUtil.getFullNameFromToken(token);
	            
	            return ResponseEntity.ok(Map.of(
	                "user", userId,
	                "role", role,
	                "fullName", fullName
	            ));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Token parsing error: " + e.getMessage());
	        }
	    }
	
	
}
