package com.example.project;

import org.springframework.stereotype.Component;

@Component
public class MyMessage {
	public String getMsg() {
		return "Hello Component Scan";
	}
}
