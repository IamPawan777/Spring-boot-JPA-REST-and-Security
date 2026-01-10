package com.project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
public class UserController {

	@GetMapping("/user/profile")
	@PreAuthorize("hasRole('USER')")  // Add this annotation
	public String getUserProfile() {
		return "Hey USER...! Welcome to Spring Security..........!";
	}
	
	
	@GetMapping("/admin/profile")
	@PreAuthorize("hasRole('ADMIN')")  // Add this annotation
	public String getAdminProfile() {
		return "Hey ADMIN...! Welcome to Spring Security..........!";
	}
	

    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getManagerTasks() {
        return "Hey USER / ADMIN...!Welcome tasks page";
    }
}
