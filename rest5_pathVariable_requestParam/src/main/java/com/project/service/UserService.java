package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.UserDetails;
import com.project.repository.UserRepository;
import com.project.request.UserRequest;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public String addUserInfo(UserRequest userRequest) {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(userRequest.getEmail());
		userDetails.setName(userRequest.getName());
		userDetails.setAge(userRequest.getAge());
		userDetails.setGender(userRequest.getGender());
		userDetails.setMobile(userRequest.getMobile());
		userDetails.setCity(userRequest.getCity());
		userDetails.setCountary(userRequest.getCountary());
		userDetails.setPassword(userRequest.getPassword());
		userDetails.setQualification(userRequest.getQualification());
		
		userRepository.save(userDetails);
		
		
		return "user created Successfully";
	}

	public List<UserDetails> getAllUser() {
		//request -> Entity -> response
		return userRepository.findAll();
	}

	public List<UserDetails> getByGenderAndCity(String gender, String city) {
		// TODO Auto-generated method stub
		return userRepository.findByGenderAndCity(gender, city);
	}

	public List<UserDetails> getByCity(String city) {
		// TODO Auto-generated method stub
		return userRepository.findByCity(city);
	}

	public List<UserDetails> getByCityAndGender(String city, String gender) {
		// TODO Auto-generated method stub
		
			return userRepository.findByGenderAndCity(gender, city);
	}

	public List<UserDetails> getByGender(String gender) {
		// TODO Auto-generated method stub
		return userRepository.findByGender(gender);
	}


	public String updatePassword(String newPassword, String emailId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> byId = userRepository.findById(emailId);
		if (byId.isPresent()) {
			UserDetails user = byId.get();
			user.setPassword(newPassword);
			userRepository.save(user);
			return "password updated...!..Successfully";
		}
		else {
			return "E-mail id not found....!...Failed";
		}
		
	}

	public String deleteByEmail(String emailId) {
		// TODO Auto-generated method stub
		Optional<UserDetails> byId = userRepository.findById(emailId);
		if(byId.isPresent()) {
			userRepository.deleteById(emailId);
			return "deleted Successfully";			
		}
		else {
			return "faild not exits";
		}
	}


}
