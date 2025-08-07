package com.project.newdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PostgralDB {
	
	@Value("${db.mysql.url}")
	private String postURL;

	public String getPostURL() {
		return postURL;
	}

	public void setPostURL(String postURL) {
		this.postURL = postURL;
	}
	
	
}
