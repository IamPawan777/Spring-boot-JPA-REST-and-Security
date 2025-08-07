package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.UserDetails;
import com.project.request.UserDetailsUpdate;
import com.project.request.UserRequest;
import com.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@PostMapping("user/signup")
	public String addUserinfo(@RequestBody UserRequest userRequest) {
		return userService.addUserInfo(userRequest);
	}
	
	@GetMapping("load/user")
	public List<UserDetails> getAllUser() {
		return userService.getAllUser();
	}
	
	// @PathVariable.......(specially update)
	// loaclhost:............/load/gender/{MALE}
	@GetMapping("/load/gender/{gender}/{city}")
	public List<UserDetails> getByGenderAndCity(@PathVariable String gender, @PathVariable String city){
		return userService.getByGenderAndCity(gender, city);
	}
	
	// @RequestParameter......(key=value)...
	// localhost:...............?city=HyD&gender=male
	@GetMapping("/load/city")
	public List<UserDetails> getByCity(@RequestParam("city")  String city){
		return userService.getByCity(city);
	}
	
	@GetMapping("load/get/optional")
	public List<UserDetails> getByCityAndGender(@RequestParam(required = false) String city, @RequestParam(required = false) String gender){		// option city and gender
		if(city != null && gender != null)
			return userService.getByCityAndGender(city, gender);
		else if(city != null && gender == null)
			return userService.getByCity(city);
		else if(city == null && gender != null)
			return userService.getByGender(gender);
		else
			return userService.getAllUser();
	}
	
	
	// update something
	@PutMapping("/update/{emailId}")
	public String updatePassword(@PathVariable String emailId, @RequestBody UserDetailsUpdate updateUser) {		
		return userService.updatePassword(updateUser.getNewPassword(), emailId);
	}
	
	
	
	@DeleteMapping("/delete/{email}")
	public String deleteByEmail(@PathVariable("email") String emailId) {
		return userService.deleteByEmail(emailId);
	}
	
	
	
	 
	
}
