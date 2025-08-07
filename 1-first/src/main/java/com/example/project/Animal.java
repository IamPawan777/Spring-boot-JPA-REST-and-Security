package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController						// create bean
public class Animal {
	
	@Autowired
	private Dog dog;				// D.I.
	@Autowired
	private Cat cat;
	
	@RequestMapping("/dog_method")			// create end point
	public String callFun1() {
		return dog.fun();
	}
	
	@RequestMapping("/cat_method")			// create end point
	public String callFun2() {
		return cat.fun();
	}
}
