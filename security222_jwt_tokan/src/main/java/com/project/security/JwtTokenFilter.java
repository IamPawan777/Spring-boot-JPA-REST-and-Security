package com.project.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserDetailsServiceAuthentication userDetailsServiceAuthentication;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// token available in header = "Authentication"
		String JWTToken = request.getHeader("Authorization");
		
		String userId = null;
		String token = null;
		
		if(JWTToken != null && !JWTToken.isBlank() && !JWTToken.isEmpty() ) {
			System.out.println("Filter: Token Present: "+JWTToken);
			token = JWTToken.substring(7);
//			System.out.println("Token Present2: "+token);
			
			// getting user name form token..
			userId = jwtUtil.getUserIdFromToken(JWTToken);
			System.out.println("Filter: Request Token can form user: "+userId);
		}
//		else {
//			System.out.println("Token not Present... ");
//		}	
		
		if(userId != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			System.out.println("filter: getting user info. form database");
			
			// user info form database
			UserDetails userByUsername = userDetailsServiceAuthentication.loadUserByUsername(userId);
			
			// now passing user id to token validator
			System.out.println("Filter: Validate token expire or not...match user name");
			boolean isValidToken = jwtUtil.isValidToken(JWTToken, userByUsername.getUsername());
			System.out.println("Filter: Token validation result: "+ isValidToken);
			
			if(isValidToken) {
				System.out.println("JwtTokenFilter: Setting security context.");
				UsernamePasswordAuthenticationToken authentication =
						new UsernamePasswordAuthenticationToken(userByUsername, null,  userByUsername.getAuthorities());			// roles

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			else {
				System.out.println("Token is Invalid");
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
