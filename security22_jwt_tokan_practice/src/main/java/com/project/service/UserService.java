package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dto.ChangePasswordDto;
import com.project.dto.UserInformationDto;
import com.project.dto.UserLoginDto;
import com.project.entiry.UserInformation;
import com.project.repository.UserRepository;
import com.project.rolesEnum.Role;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String signupUser(UserInformationDto dto) {
		//entity to DTO		
		if(userRepository.findById(dto.getEmail()).isPresent()) {
			return "Email Already Existed, Please Try Again...!";
		}
		else {
			// Set default role if not provided
			 UserInformation userInfo = new UserInformation();
	            userInfo.setEmail(dto.getEmail());
	            userInfo.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
	            userInfo.setMobile(dto.getMobile());
	            userInfo.setFullName(dto.getFullName());
	            userInfo.setRole(dto.getRole() != null ? dto.getRole() : Role.ROLE_USER);
	            
	            userRepository.save(userInfo);
	            return "User registered successfully with role: " + userInfo.getRole();
		}
	}
	
	

	public String signinUser(UserLoginDto userLoginDto) {
		Optional<UserInformation> userOptional = userRepository.findById(userLoginDto.getEmail());
        if(userOptional.isPresent()) {
            UserInformation user = userOptional.get();
            // Check if password matches using encoder
            if(bCryptPasswordEncoder.matches(userLoginDto.getPassword(), user.getPassword())) {
                return "User Login Success. Welcome " + user.getFullName() + "! Role: " + user.getRole().name();
            }
        }
        
        return "Invalid Credential, Try Again..!";
	}

	
	
	public String changePassword(ChangePasswordDto changePassword, String userId) {
		Optional<UserInformation> byId = userRepository.findById(userId);
        
        if(byId.isPresent()) {
            UserInformation userInformation = byId.get();
            
            // Verify old password first
            if(!bCryptPasswordEncoder.matches(changePassword.getOldPassword(), userInformation.getPassword())) {
                return "Old password is incorrect";
            }
            
            // Verify new password and confirm password match
            if(!changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
                return "New password and confirm password do not match";
            }
            
            userInformation.setPassword(bCryptPasswordEncoder.encode(changePassword.getNewPassword()));
            userRepository.save(userInformation);
            
            return "User Password changed Successfully";
        }
        else {
            return "User not found: " + userId;
        }
	}

	
	
	public String deleteProfile(String userId) {
		Optional<UserInformation> byId = userRepository.findById(userId);
		
		if(byId.isPresent()) {
			userRepository.deleteById(userId);
			return "user deleted Successfully";
		}
		else {
			return "User not Found "+userId;
		}		
	}
	

}
