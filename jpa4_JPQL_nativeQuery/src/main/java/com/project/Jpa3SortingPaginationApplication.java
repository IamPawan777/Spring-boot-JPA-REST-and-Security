package com.project;

import com.project.dbop.DBOperation;
import com.project.dbop.DBOperation_JPQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Jpa3SortingPaginationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container =   SpringApplication.run(Jpa3SortingPaginationApplication.class, args);
		
		DBOperation bean = container.getBean(DBOperation.class);
//		bean.addEmpData();
		
//		bean.getAllRecord();
//		bean.getRecorViaAge("22", "india");
//		bean.getRecordViaGenderName(32, "male");
//		bean.addElement(13, "Pawsan", 22, 12.2f, "Lodhiyana", "Male", 1212, "Nepal");
//		bean.deleteDataEmp(13);
		
		
		
		DBOperation_JPQL bean2 = container.getBean(DBOperation_JPQL.class);
//		bean2.getAllRecords();
		bean2.getRecordByNameAge("Sita", "delhi");
		
	}

}
