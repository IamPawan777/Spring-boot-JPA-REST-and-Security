package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class FirstService {
	public SecondService secondService;
	@Autowired
	@Lazy
	public void setSecondService(SecondService secondService) {
		this.secondService = secondService;
	}
	
	String name = "Pawan Bisht";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int printerFirst() {
		return secondService.getAge();	
	}	
}
