package com.project.request;

import lombok.Data;

@Data
public class UserDetails {
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String password;
}
