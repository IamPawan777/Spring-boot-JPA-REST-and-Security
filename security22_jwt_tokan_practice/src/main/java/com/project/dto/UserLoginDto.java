package com.project.dto;

import com.project.rolesEnum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
	
	private String email;
	private String password;
	private Role role; 

}
