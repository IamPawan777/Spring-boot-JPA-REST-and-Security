package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDetails {
	
	@Id
	private String email;
	
	private String name;
	private String mobile;
	private String password;
	private int age;
	private String city;
	private String gender;
	private String qualification;
	private String countary;
}
