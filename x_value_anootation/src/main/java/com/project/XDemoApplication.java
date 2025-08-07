package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.db.DatabaseConfiguration;

@SpringBootApplication
public class XDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(XDemoApplication.class, args);
		DatabaseConfiguration dbcon =  (DatabaseConfiguration)con.getBean("dbCre");		
		
		System.out.println(dbcon.getName());
		System.out.println(dbcon.getDbPort());
		System.out.println(dbcon.getDbURL());
		System.out.println(dbcon.getDbUsername());
		System.out.println(dbcon.getDbPass());
		
		System.out.println(dbcon.getPostgralDB().getPostURL());
	}

}
