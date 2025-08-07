package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.project.aws.UseAWS;
import com.project.google.UseGoogle;


//@PropertySource(value = {"aws-database.properties", "google-credintial.properties"})
@SpringBootApplication
public class XDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(XDemoApplication.class, args);
		
		UseAWS aws =  (UseAWS)con.getBean("awsBean");
		UseAWS aws1 =  (UseAWS)con.getBean("awsBean");		// singleton Scope by default
		UseAWS aws2 =  (UseAWS)con.getBean("awsBean");		// singleton Scope
		System.out.println(aws);
		System.out.println(aws1);
		System.out.println(aws2);
	 	System.out.println(aws.getAwsURL());
	 	System.out.println(aws.getAwsUser());
	 	System.out.println(aws.getAwsPass());
	 	
	 	UseGoogle google =  (UseGoogle)con.getBean("googleBean");
	 	System.out.println(google);
	 	System.out.println(google.getG_User());
	 	System.out.println(google.getG_Data());
	}

}
