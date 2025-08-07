package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.UserDetails;
import com.project.repository.UserRepository;
import com.project.request.UserLoginRequest;
import com.project.request.UserRequest;
import com.project.response.UserResponse;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;

	public String addUserData(UserRequest userRequest) {
		//DTO to entity...
		UserDetails user = new UserDetails();
		user.setEmailId(userRequest.getEmailId());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setAge(userRequest.getAge());
		user.setMobile(userRequest.getMobile());
		user.setPassword(userRequest.getPassword());
		
		userRepository.save(user);			// repository needs entity
		
		return "user Created Successfully";
	}
	
	public UserResponse userLogin(UserLoginRequest userLoginRequest) {
		UserDetails byEmailIdAndPassword = userRepository.findByEmailIdAndPassword(userLoginRequest.getEmailId(), userLoginRequest.getPassword());
		
		// entity to DTO...
		UserResponse userResponse = new UserResponse();
		
		if(byEmailIdAndPassword != null) {
			userResponse.setEmailId(byEmailIdAndPassword.getEmailId());
			userResponse.setFirstName(byEmailIdAndPassword.getFirstName());
			userResponse.setLastName(byEmailIdAndPassword.getLastName());
			userResponse.setAge(byEmailIdAndPassword.getAge());
//			userResponse.setMobile(byEmailIdAndPassword.getMobile());
			return userResponse;							// controller needs DTO
		}
		else
			return null;
	}
}
