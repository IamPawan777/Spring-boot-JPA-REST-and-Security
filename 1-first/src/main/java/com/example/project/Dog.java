package com.example.project;

import org.springframework.stereotype.Component;

@Component					// create bean
public class Dog {
	public String fun() {
		return "I am Barking.";
	}
}
