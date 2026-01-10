package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.RequestDTO;
import com.project.dto.ResponseDTO;
import com.project.entity.Employee;
import com.project.repository.EmployeeRepo;

@Service
public class EmployeeService {	
	private EmployeeRepo employeeRepo;
	@Autowired
	public void setEmployeeRepo(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public String addEmpDetails(RequestDTO requestDTO) {
		Employee emp = new Employee();
		emp.setEname(requestDTO.getName());
		emp.setEsalary(requestDTO.getSalary());
		employeeRepo.save(emp);
		
		return "Employee details added successfully";
	}
	
	public List<ResponseDTO> getEmpDetails(){
		return employeeRepo.findEmpDetains();
	}
	
}
