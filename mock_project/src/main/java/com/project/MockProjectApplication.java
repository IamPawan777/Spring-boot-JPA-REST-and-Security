package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * Question: create 2 classes and both uses each other perperties?
 * =================================================================
 * Answer:
 * - In this condition circular depandancy problem will occures.
 * - resolve by ***@lazy***
 * - recommnedate way to use constructor injection.
 * - Direct access of properties (variable) is not possible, access by ***getter*** and ***setter***.
 * - ***CommandLineRunner*** interface is implement in main class then access by ***run()*** method of both classes properites. 
 * 
 * 
*/


@SpringBootApplication
public class MockProjectApplication implements CommandLineRunner {
	@Autowired
	private First first;				// field injection
	@Autowired
	private Second second;
	
//	public MockProjectApplication(First first, Second second) {				// cunstructor injection.....
//		this.first = first;
//		this.second = second;
//	}

	public static void main(String[] args) {
		SpringApplication.run(MockProjectApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(first.printFirst());
//		System.out.println(second.printSecond());
		second.printSecond();
	}

}
