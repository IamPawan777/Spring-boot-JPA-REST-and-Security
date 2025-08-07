package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


//@PropertySource(value = {"aws-database.properties", "google-credintial.properties"})
@SpringBootApplication
public class XDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(XDemoApplication.class, args);
		
		Product bean = (Product)con.getBean("product");
		System.out.println(bean);
	}

}
