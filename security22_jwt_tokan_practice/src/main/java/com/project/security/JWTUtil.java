package com.project.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
    
    private final String SECRET_KEY = "asdblkjkljkjk9jsdklskldkljij8j080jkld90v90x90vu000bjbjhbhbhnjbjvgggvgr6utrgyur6u7d9udv90su90vus";
    private final long TOKEN_EXPIRY_DURATION = 10 * 60 * 1000; 		// 10 minutes

    private SecretKey getSecretKey() {
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }
    
    // Generate token with role information
    public String createToken(String email, String role,  String fullName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("fullName", fullName);
        
        return Jwts.builder()
                .subject(email)
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRY_DURATION))
                .signWith(getSecretKey())
                .compact();
    }
    
    // Extract username (email) from token
    public String getUserIdFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }
    
    // Extract role from token
    public String getRoleFromToken(String token) {
        return extractAllClaims(token).get("role", String.class);
    }
    
    // Extract full name from token
    public String getFullNameFromToken(String token) {
        return extractAllClaims(token).get("fullName", String.class);
    }
    
    // Extract expiration date from token
    public Date getExpirationDateFromToken(String token) {
        return extractAllClaims(token).getExpiration();
    }
    
    // Check if token is expired
    public boolean isTokenNotExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.after(new Date());
    }
    
    // Validate token
    public boolean isValidToken(String token, String username) {
        try {
            String userIdFromToken = getUserIdFromToken(token);
            return userIdFromToken.equalsIgnoreCase(username) && isTokenNotExpired(token);
        } catch (Exception e) {
            System.out.println("Token validation error: " + e.getMessage());
            return false;
        }
    }
    
    // Extract all claims from token - FIXED METHOD
    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            System.out.println("Error parsing token: " + e.getMessage());
            throw new RuntimeException("Invalid token format", e);
        }
    }
}