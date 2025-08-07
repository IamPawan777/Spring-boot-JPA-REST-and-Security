package com.project.request;

import lombok.Data;

@Data
public class UserRequest {
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobile;
	private String password;
	private int age;
}

