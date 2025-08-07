package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerClass {
	
//	@RequestMapping(method = RequestMethod.GET, path = "/hello")
//	public String sayHello() {
//		return "hello";					// need a view and view resolver
//	}
	
	
	// now it is rest endpoint
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	@ResponseBody
	public String sayHello() {
		return "Controller : hello";
	}
}
