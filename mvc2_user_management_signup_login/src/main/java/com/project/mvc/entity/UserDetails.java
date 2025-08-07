package com.project.mvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDetails {
	@Id
	private String emailId;
	private String username;
	private String password;
}
