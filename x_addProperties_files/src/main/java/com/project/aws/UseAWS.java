package com.project.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("awsBean")
public class UseAWS {
	
	@Value("${aws.db.url}")
	private String awsURL;
	
	@Value("${aws.db.user}")
	private String awsUser;
	
	@Value("${aws.db.password}")
	private String awsPass;

	public String getAwsURL() {
		return awsURL;
	}

	public void setAwsURL(String awsURL) {
		this.awsURL = awsURL;
	}

	public String getAwsUser() {
		return awsUser;
	}

	public void setAwsUser(String awsUser) {
		this.awsUser = awsUser;
	}

	public String getAwsPass() {
		return awsPass;
	}

	public void setAwsPass(String awsPass) {
		this.awsPass = awsPass;
	}
	
	
}
