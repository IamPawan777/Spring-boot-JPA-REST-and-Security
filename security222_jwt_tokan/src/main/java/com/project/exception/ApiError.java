package com.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiError {
	private LocalDateTime timeStamp;
	private String error;
	private HttpStatus statusCode;
	
//	public ApiError(String error, HttpStatus httpStatus) {
//		this();
//		this.error = error;
//		this.statusCode = httpStatus;
//	}
	
	
}
