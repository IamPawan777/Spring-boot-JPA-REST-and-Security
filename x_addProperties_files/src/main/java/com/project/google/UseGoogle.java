package com.project.google;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("googleBean")
public class UseGoogle {
	
	@Value("${google.username}")
	private String g_User;
	
	@Value("${google.data}")
	private String g_Data;

	public String getG_User() {
		return g_User;
	}

	public void setG_User(String g_User) {
		this.g_User = g_User;
	}

	public String getG_Data() {
		return g_Data;
	}

	public void setG_Data(String g_Data) {
		this.g_Data = g_Data;
	}
	
}
