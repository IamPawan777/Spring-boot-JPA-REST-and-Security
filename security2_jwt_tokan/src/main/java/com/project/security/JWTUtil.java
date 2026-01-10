package com.project.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
	
	private final String SECRET_KEY = "asdblkjkljkjk9jsdklskldkljij8j080jkld90v90x90vu000bjbjhbhbhnjbjvgggvgr6utrgyur6u7d9udv90su90vus";		// 3. secret key
	private final long TOKEN_EXPIRY_DURATION = 5*1000*60;

	
	private SecretKey getSecretKey() {			// 1. header
		byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(decode);
		
//		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}
 	
	// generate token
	public String createToken(String email) {										// 2. payload
//		 Map<String, Object> claims = new HashMap<>();
//	     claims.put("role", role);
//	     claims.put("fullName", fullName);
	     
	     String tokan = Jwts
				.builder()
				.subject(email)				// unique user id
//				.claims(claims) // Add custom claims including role
				.issuedAt(new Date(System.currentTimeMillis()))				// setting creation time
				.expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRY_DURATION ))   // setting expire
				.signWith(getSecretKey())
				.compact();
		
		return tokan;
	}
	
	
	
//	public boolean isValidateToken(String token) {
//		String userIdFromToken = getUserIdFromToken(token);
//		System.out.println("User Id Retrived from token : "+userIdFromToken);
//		
//		return userIdFromToken.equalsIgnoreCase(token) && isTokenNotExpired(token);
//	}
	
	
	// decode- 1.Extract username (email) from token
	public String getUserIdFromToken(String token) {
		return Jwts.parser()
				.verifyWith(getSecretKey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	// decode- 2. Extract role from token
	private boolean isTokenNotExpired(String token) {
		Date expiryTime = Jwts.parser()
							.verifyWith(getSecretKey())
							.build()
							.parseSignedClaims(token)
							.getPayload()
							.getExpiration();
		
		System.out.println("Util: Token Expiry Time: "+expiryTime);
		return expiryTime.after(new Date());			// expire time after curr time
	}
	
	
	// above both combined...
	public boolean isValidToken(String token, String requestEmailId) {
		String userIdFromToken = getUserIdFromToken(token);
		System.out.println("Util: User id retrived from token : "+userIdFromToken);
		return userIdFromToken.equalsIgnoreCase(requestEmailId) && isTokenNotExpired(token);
	}
	
	
}
