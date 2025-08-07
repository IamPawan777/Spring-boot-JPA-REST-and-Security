package com.project;

import com.project.dbop.DBOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Jpa3SortingPaginationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container =   SpringApplication.run(Jpa3SortingPaginationApplication.class, args);
		
		DBOperation bean = container.getBean(DBOperation.class);
		bean.addEmpData();
//		bean.getSortedOrder();
		
//		bean.getInitalEmpInformation(5);
//		bean.getFixEmpInformation(1, 3);
//		bean.getFixSortedEmpInformation(1, 4);
	}

}
