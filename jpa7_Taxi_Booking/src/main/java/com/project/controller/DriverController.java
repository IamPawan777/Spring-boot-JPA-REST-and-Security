package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.request.DriverRequest;
import com.project.dto.response.DriverResponse;
import com.project.service.DiverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	DiverService driverService;	
	
	@PostMapping("/add")
	public DriverResponse addDriver(@RequestBody DriverRequest driverRequest) {
		return driverService.addDriver(driverRequest);		
	}
}
