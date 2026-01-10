package com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
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
			.authorizeHttpRequests((request) -> request
					.requestMatchers("/public/**").permitAll()
//					.requestMatchers("/weather/health/**").hasRole("ADMIN")
					.anyRequest().authenticated())
//			.httpBasic(Customizer.withDefaults());
			.addFilterBefore(this.jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		System.out.println("Instance of authenticationManager...! ");
		return  authenticationConfiguration.getAuthenticationManager();
	}
}
