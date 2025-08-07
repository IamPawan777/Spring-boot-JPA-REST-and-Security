package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDetails {
	@Id
	private String emailId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String password;
	private int age;
}
