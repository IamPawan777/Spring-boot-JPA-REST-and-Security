package com.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

	//not posible bcz of automatically "@ResponceBody" use behind
	
//	@RequestMapping(method = RequestMethod.GET, path = "/hello")
//	public String sayHello() {
//		return "hello";					// need a view and view resolver
//	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/rest/hello")
	public String sayHello() {
		return "Rest API :  hello";
	}
		
}
