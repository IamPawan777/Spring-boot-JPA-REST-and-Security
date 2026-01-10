package com.project.entiry;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.rolesEnum.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Info_JWT")
public class UserInformation implements UserDetails {
	
	@Id
	private String email;
	
	private String fullName;
	private String password;
	private String mobile;
	
//	 @Enumerated(EnumType.STRING)
////	 @Column(	nullable = false)
//	 private Role role;
	
	// all roles.... 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
		return Arrays.asList(authority);
//        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));

	}

	@Override
	public String getUsername() {
		return email;
	}
	
}
