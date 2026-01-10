package com.project.dto;

import com.project.rolesEnum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationDto {

	private String email;
	
	private String password;
	private String mobile;
	private String fullName;
	private Role role;
}
