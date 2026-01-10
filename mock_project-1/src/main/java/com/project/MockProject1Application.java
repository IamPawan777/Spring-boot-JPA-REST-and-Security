package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * Question: create 2 classes and both uses each other perperties using REST-API design?
 * =================================================================
 * Answer:
 * - In this condition circular depandancy problem will occures.
 * - resolve by ***@lazy***
 * - Direct access of properties (variable) is not possible, access by ***getter*** and ***setter***.
 * - No need of ***CommandLineRunner*** interface along with ***.run()*** method.
 * 
 * 
*/


@SpringBootApplication
public class MockProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MockProject1Application.class, args);
	}

}
