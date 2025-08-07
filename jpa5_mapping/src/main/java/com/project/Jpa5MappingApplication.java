package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.db.DBOperation;

@SpringBootApplication
public class Jpa5MappingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Jpa5MappingApplication.class, args);

		DBOperation bean = container.getBean(DBOperation.class);
		bean.addRecords();
	}

}
