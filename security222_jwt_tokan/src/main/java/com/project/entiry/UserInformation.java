package com.project.entiry;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.rolesEnum.RoleType;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Info_JWT")
@Builder
public class UserInformation implements UserDetails {
	
	@Id
	private String email;
	
	private String fullName;
	private String password;
	private String mobile;
	
//	 @Enumerated(EnumType.STRING)
//	 @Column(	nullable = false)
//	 private RoleType role;
	
//	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private RoleType roles; 
	
	// all roles.... 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Collections.singletonList(new SimpleGrantedAuthority(roles.name()));
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + roles.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}
	
}
