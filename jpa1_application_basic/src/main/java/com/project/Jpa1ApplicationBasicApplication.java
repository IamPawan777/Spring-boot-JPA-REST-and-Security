package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.db.DBOperationSavaAll;
import com.project.db.DBOperationSave;

@SpringBootApplication
public class Jpa1ApplicationBasicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Jpa1ApplicationBasicApplication.class, args);
		
		DBOperationSave db = (DBOperationSave)container.getBean(DBOperationSave.class);
//		db.addProductInfo();
//		db.addOrderInfo();
		
		DBOperationSavaAll db2 = container.getBean(DBOperationSavaAll.class);
		db2.addProductSaveAll();
		db2.checkNoOfRows();
//		db2.deleteAllRecords();
		db2.getAllRecords();
		
	}

}
