package com.project.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.mvc.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@RequestMapping(method = RequestMethod.GET, path = "/signup")
	public String registerPage() {
		return "registration";
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/account/signup")
	public ModelAndView registerPageSecond(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		String registerPage = userService.registerPage(username, email, password);		// forword service layer
		
		// send to view layer
		
		ModelAndView model = new ModelAndView();
		model.setViewName("printingMessage");
		model.addObject("response", registerPage);
		
		return model;	
	}
	
	@RequestMapping(path = "/signin", method = RequestMethod.GET)
	public ModelAndView userlogin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	
	@RequestMapping(path = "/account/signin", method = RequestMethod.POST)
	public ModelAndView userloginSecond(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		String logInPage = userService.logInPage(email, password);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("printingMessage");
		model.addObject("response", logInPage);
		
		return model;
	}
	
	
}
