package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.db.DBOperation;

@SpringBootApplication
public class XJdbcApplicationsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(XJdbcApplicationsApplication.class, args);
		
		DBOperation db = (DBOperation)container.getBean(DBOperation.class);
//		db.addProduct();
//		db.addProduct2();
		
//		db.deleteProduct();
//		db.deleteProduct2();
		
//		db.updateProduct();
		db.updateProduct2();
	}

}
