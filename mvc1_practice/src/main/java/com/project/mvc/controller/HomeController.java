package com.project.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/homePage")
	public String getHome() {
		System.out.println("Processing Request...");
		return "home";		// view name
	}
//	
	@RequestMapping(method = RequestMethod.GET, path = "/registerPage")
	public String postHome() {
		System.out.println("Processing Responce...");
		return "register";
	}
}
