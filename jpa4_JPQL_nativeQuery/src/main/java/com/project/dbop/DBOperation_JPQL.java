package com.project.dbop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Employee;
import com.project.repository.EmployeeRepository_JPQL;

@Component
public class DBOperation_JPQL {
	@Autowired
	EmployeeRepository_JPQL empRepo;
	
	public void getAllRecords() {
		List<Employee> list = empRepo.loadAllEmployee();
		list.forEach(System.out::println);
	}
	
	public void getRecordByNameAge(String name, String city) {
		List<Employee> list = empRepo.loadRecordByNameAge(name, city);
		list.forEach(System.out::println);
	}
	
}
