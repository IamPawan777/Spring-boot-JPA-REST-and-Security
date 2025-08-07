package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.db.DBOperation;
import com.project.db.DBOperationDlt;

@SpringBootApplication
public class Jpa2CustomFindAllApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container =  SpringApplication.run(Jpa2CustomFindAllApplication.class, args);
	 	
		DBOperation bean = container.getBean(DBOperation.class);
//	 	bean.addStudentData();
		bean.findOneRecord();
		bean.findOneRecordByGender("Male");
		bean.findRecordByName("pawan");
//		bean.findRecordNameAndCity("pawan", "Hydrabad");
		
		DBOperationDlt bean2= container.getBean(DBOperationDlt.class);
//		bean2.dltRecordById(1);
//		bean2.dltRecordByName("pawan");
//		bean2.updeteSomeData(5, "vishakhapatnam");
		
	}

}
