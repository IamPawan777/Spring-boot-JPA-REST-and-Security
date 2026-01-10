package com.project.security;

import java.io.IOException;
import java.util.Collection;
//import java.util.Collections;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		String authHeader = request.getHeader("Authorization");		
		String userId = null;
		String token = null;
		
		if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
			System.out.println("Filter: Token Present: "+authHeader);
			token = authHeader.substring(7);
//			System.out.println("Token Present2: "+token);
			
			// getting user name form token..
			userId = jwtUtil.getUserIdFromToken(token);
			System.out.println("Filter: Request Token can form user: "+userId);
			
			 String roleFromToken = jwtUtil.getRoleFromToken(token);
             System.out.println("Filter: Role from token: " + roleFromToken);
		}
//		else {
//			System.out.println("Token not Present... ");
//		}	
		
		if(userId != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			System.out.println("filter: getting user info. form database");
			
			// user info form database
			UserDetails userByUsername = userDetailsServiceAuthentication.loadUserByUsername(userId);
			//...............
//			 String roleFromToken = jwtUtil.getRoleFromToken(token);
//	            System.out.println("Filter: Role from token: " + roleFromToken);
			//.............
			// now passing user id to token validator
			System.out.println("Filter: Validate token expire or not...match user name");
			boolean isValidToken = jwtUtil.isValidToken(token, userByUsername.getUsername());
			System.out.println("Filter: Token validation result: "+ isValidToken);
			
			if(isValidToken) {
				Collection<SimpleGrantedAuthority> authories;
				System.out.println("JwtTokenFilter: Setting security context.");
				
				
				UsernamePasswordAuthenticationToken authentication =
            	        new UsernamePasswordAuthenticationToken(
            	            userByUsername, 
            	            null,
            	            userByUsername.getAuthorities()
//            	            Collections.singletonList(new SimpleGrantedAuthority(roleFromToken))
            	        );// roles

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			else {
                System.out.println("Token is Invalid");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
                return;
            }
			
		}
		else {
            System.out.println("Filter: No valid Authorization header found");
        }
		
		filterChain.doFilter(request, response);
		
	}
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//	        throws ServletException, IOException {
//	    
//	    String authHeader = request.getHeader("Authorization");
//	    String userId = null;
//	    String token = null;
//	    
//	    if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
//	        System.out.println("Filter: Authorization Header Present: " + authHeader);
//	        token = authHeader.substring(7);
//	        
//	        try {
//	            userId = jwtUtil.getUserIdFromToken(token);
//	            String roleFromToken = jwtUtil.getRoleFromToken(token);
//	            
//	            
//	            if (roleFromToken != null && roleFromToken.startsWith("ROLE_")) {
//	                roleFromToken = roleFromToken.substring(5); // Removes "ROLE_"
//	            }
//	            
//	            
//	            System.out.println("Filter: User from token: " + userId);
//	            System.out.println("Filter: Role from token: " + roleFromToken);
//	            
//	            if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//	                UserDetails userByUsername = userDetailsServiceAuthentication.loadUserByUsername(userId);
//	                
//	                boolean isValidToken = jwtUtil.isValidToken(token, userByUsername.getUsername());
//	                
//	                if(isValidToken) {
//	                    // Handle role conversion safely
////	                    Collection<SimpleGrantedAuthority> authorities;
////	                    
////	                    if (roleFromToken != null && !roleFromToken.trim().isEmpty()) {
////	                        authorities = Collections.singletonList(new SimpleGrantedAuthority(roleFromToken));
////	                    } else {
////	                        authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
////	                    }
//	                    
//	                	UsernamePasswordAuthenticationToken authentication =
//	                	        new UsernamePasswordAuthenticationToken(
//	                	            userByUsername, 
//	                	            null,
//	                	            userByUsername.getAuthorities()
////	                	            Collections.singletonList(new SimpleGrantedAuthority(roleFromToken))
//	                	        );
//
//	                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//	                    SecurityContextHolder.getContext().setAuthentication(authentication);
//	                    System.out.println("Filter: Authentication set successfully");
//	                }
//	            }
//	        } catch (Exception e) {
//	            System.out.println("Filter: Error processing token: " + e.getMessage());
//	        }
//	    }
//	    
//	    filterChain.doFilter(request, response);
//	}

}
