package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContectController {
	
	@GetMapping("/api/admin/contact/info")
	public String getContectInfo() {
		return "Call: +91 898209211, Email: HI@gmail.com";
	}
}
