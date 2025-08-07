package com.project.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Address;
import com.project.entity.Employee;
import com.project.repository.EmployeeRepository;

@Component
public class DBOperation {
	@Autowired
	EmployeeRepository empRepo;
	
	public void addRecords() {
		Address add = new Address();
		add.setCity("HYD");
		add.setPin(2222);
		add.setCountary("Nepal");
		
		Employee emp = new Employee();
		emp.setName("Aithani");
		emp.setAge(88);
		emp.setAddress(add);		// 1:1
		
		empRepo.save(emp);
	}
	
	
}
