package com.project.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {
	
	private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
	
	@Value("${spring.app.jwt.secretKey}")
	private String SECRET_KEY;
	
	@Value("${spring.app.jwt.expirationMs}")
	private long TOKEN_EXPIRY_DURATION;
	
	
	// getting jwt token from header....
	public String getJwtFromHeader(HttpServletRequest request) {
		String bearer = request.getHeader("Authentication");
		logger.debug("Authentication Header: {}", bearer);
		if(bearer != null && bearer.startsWith("Bearer ")) {
			return bearer.substring(7);
		}
		return null;
	}
	
	
	private SecretKey secretKey() {	
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
	}
	
	// generate/create token ||  username -> token
	public String createToken(UserDetails userDetails) {										// 2. payload
		String username = userDetails.getUsername();
		String tokan = Jwts.builder()
							.subject(username)				// unique user id
							.issuedAt(new Date())				// setting creation time
							.expiration(new Date(new Date().getTime() + TOKEN_EXPIRY_DURATION ))   // setting expire
							.signWith(secretKey())
							.compact();
		
		return tokan;
	}
	
	
	
	// Decode ||  token -> username
	public String getUserNameFromToken(String token) {
		return Jwts.parser()
					.verifyWith(secretKey())
					.build()
					.parseSignedClaims(token)
					.getPayload()
					.getSubject();
	}
	
	
	
	// check token expire...
	public boolean validateToken(String token) {
		try {
			Date expiryTime = Jwts.parser()
							.verifyWith(secretKey())
							.build()
							.parseSignedClaims(token)
							.getPayload()
							.getExpiration();
			System.out.println("Token Expiry Time: "+expiryTime);
			return true;
		}
		catch (MalformedJwtException e) {
			logger.error("Invalid Token JWT : "+e.getMessage());
		}
		catch (ExpiredJwtException e) {
			logger.error("Token Expired  : "+e.getMessage());
		}
		catch (UnsupportedJwtException e) {
			logger.error("Token Unsupported  : "+e.getMessage());
		}
		catch (IllegalArgumentException e) {
			logger.error("Claims string is empty : "+e.getMessage());
		}
		
//		return expiryTime.after(new Date());			// expire time after curr time
		return false;
	}
	
	
		
		
		
		
}
