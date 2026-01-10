package com.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReelsController {
	
	@PostMapping("/api/user/upload/reel")
	public String uploadReel() {
		
		return "Reels is Successfully Upload";
	}
}
