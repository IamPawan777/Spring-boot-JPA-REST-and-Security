package com.project.security;

import org.apache.catalina.util.SessionConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.rolesEnum.Role;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	
	// password encoder
	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		System.out.println("BCryptPasswordEncoder: Instance creating");
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests((request) -> request
					.requestMatchers("/public/**").permitAll()
//					.requestMatchers("/api/**").hasAuthority("ROLE_USER")
                    .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
//                    .requestMatchers("/moderator/**").hasAnyRole("MODERATOR", "ADMIN")
					 
//	                .requestMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
//	                .requestMatchers("/api/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
	                .anyRequest().authenticated())
			.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		System.out.println("Instance of authenticationManager...! ");
		return  authenticationConfiguration.getAuthenticationManager();
	}
}
