package com.project.exception;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.JwtException;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ApiError> userNotFoundExceptionHandler(UsernameNotFoundException exception){
		ApiError apiError = new ApiError(LocalDateTime.now(), "User not found "+exception.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiError, apiError.getStatusCode());
	}
	
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ApiError> autheticationExceptionHandler(AuthenticationException exception){
		ApiError apiError = new ApiError(LocalDateTime.now(),  "Authetication Failed Exception "+exception.getMessage(), HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(apiError, apiError.getStatusCode());
	}
	
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<ApiError> jwtExceptionHandler(JwtException exception){
		ApiError apiError = new ApiError(LocalDateTime.now(), "Invalid Jwt Token Exception "+exception.getMessage(), HttpStatus.UNAUTHORIZED);
		return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiError> accessDeniedExceptionHandler(AccessDeniedException exception){
		ApiError apiError = new ApiError(LocalDateTime.now(),  "Access Denied Exception "+exception.getMessage(), HttpStatus.FORBIDDEN);
		return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> ExceptionHandler(Exception exception){
		ApiError apiError = new ApiError(LocalDateTime.now(),  "Unextected Exception:- "+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(apiError, apiError.getStatusCode());
	}
	
}
