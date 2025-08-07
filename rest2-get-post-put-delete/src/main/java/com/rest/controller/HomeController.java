package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping(path = "/getdata", method = RequestMethod.GET)
	public String  getMethod() {
		return homeService.getMethod();
	}
	
	@RequestMapping(path = "print/postdata", method = {RequestMethod.POST, RequestMethod.GET})				// both http method 
	public String postMethod() {
		return homeService.postMethod();
	}
	
	 
	@RequestMapping(path = {"/putdata", "/updatadata"}, method = RequestMethod.PUT)					//both endpoint for same method
	public String putMethod() {
		return homeService.putMethod();
	}
	
	
	@RequestMapping(path = "/deletedata", method = RequestMethod.DELETE)
	public String deleteMethod() {
		return homeService.deleteMethod();
	}
}
