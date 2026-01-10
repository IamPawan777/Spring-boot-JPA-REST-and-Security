package com.project.dto;

import java.util.HashSet;
import java.util.Set;

import com.project.rolesEnum.RoleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationDto {

	private String email;
	
	private String fullName;
	private String password;
	private String mobile;
	
	private RoleType roles; 
}
