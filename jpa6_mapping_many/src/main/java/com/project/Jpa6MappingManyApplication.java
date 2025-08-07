package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.db.DbOperation;

@SpringBootApplication
public class Jpa6MappingManyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Jpa6MappingManyApplication.class, args);
		
		DbOperation bean = container.getBean(DbOperation.class);

		//bean.addRecords();
//		bean.getRecords();
		bean.getAllRecords();
	}

}
