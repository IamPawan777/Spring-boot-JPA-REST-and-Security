package com.project.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class SecondService {
	private final FirstService firstService;
	public SecondService(@Lazy FirstService firstService) {
		this.firstService = firstService;
	}
	
	int age = 32;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String printerSecond() {
		return firstService.getName();	
	}
}
