package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.FirstService;
import com.project.service.SecondService;


@RestController
public class HomeController {
	
	@Autowired
	public FirstService firstService;
	@Autowired
	public SecondService secondService;
	
	
	@GetMapping("/get/first")
	public int printerFirst() {
		return firstService.printerFirst();
	}
	
	@GetMapping("/get/second")
	public String printerSecond() {
		return secondService.printerSecond();
	}
}
