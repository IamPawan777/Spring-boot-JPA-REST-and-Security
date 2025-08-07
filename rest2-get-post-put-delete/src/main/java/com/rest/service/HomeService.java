package com.rest.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	public String getMethod() {
		return "Returing GET method....";
	}
	
	public String postMethod() {
		return "return Post method";
	}
	
	public String putMethod() {
		return "return Put method";
	}
	
	public String deleteMethod() {
		return "return delete method";
	}
}
