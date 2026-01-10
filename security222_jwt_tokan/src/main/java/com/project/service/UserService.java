package com.project.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.dto.ChangePasswordDto;
import com.project.dto.UserInformationDto;
import com.project.dto.UserLoginDto;
import com.project.entiry.UserInformation;
import com.project.repository.UserRepository;
import com.project.rolesEnum.RoleType;

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
//			UserInformation userInfo = new UserInformation(dto.getEmail(), 
//								bCryptPasswordEncoder.encode(dto.getPassword()),			// encode password...
//								dto.getMobile(), 
//								dto.getFullName()
//								dto.
//								);
			UserInformation userInfo = UserInformation.builder()
					.email(dto.getEmail())
					.fullName(dto.getFullName())
					.password(bCryptPasswordEncoder.encode(dto.getPassword()))
					.mobile(dto.getMobile())
					.roles(dto.getRoles())
//					.roles(Set.of(RoleType.USER))
//					.roles(RoleType.ADMIN)
					.build();
            
			userRepository.save(userInfo);
			
			return "User Created Successfully...!"+ userInfo.getRoles();
		}
	}
	
	

	public String signinUser(UserLoginDto userLoginDto) {
		UserInformation byEmailAndPassword = userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());		
		if(byEmailAndPassword != null) {
			return "User Login Success. WelCome "+byEmailAndPassword.getUsername();
		}
		else {
			return "Invalid Credential, Try Again..!";
		}
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
			
			return "User Password change Successfully";
		}
		else {
			return "User not found "+userId;
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
