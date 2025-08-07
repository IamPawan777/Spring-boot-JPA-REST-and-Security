package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.request.CabRequest;
import com.project.dto.response.CabResponse;
import com.project.service.CabService;

@RestController
@RequestMapping("/cab")
public class CabController {
	@Autowired
	CabService cabService;
	
	
	@PostMapping("/register/driver/{driverId}")
	public CabResponse registerCab(@RequestBody CabRequest cabRequest, @PathVariable("driverId") int driverId) {
		return cabService.registerCab(cabRequest, driverId);
	}
}
