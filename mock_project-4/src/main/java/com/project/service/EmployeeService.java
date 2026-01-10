package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Entity.Employee;
import com.project.controller.EmployeeController;
import com.project.convertor.EmpConvertor;
import com.project.dto.RequestDto;
import com.project.dto.ResponseDto;
import com.project.exception.EmployeeNotFound;
import com.project.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public ResponseDto addData(RequestDto requestDto) {
		Employee employee = EmpConvertor.requestDtoToEmployee(requestDto);
		
		Employee save = employeeRepo.save(employee);
		
		ResponseDto responseDto = EmpConvertor.employeeToResponseDto(save);
		return responseDto;
	}

	public ResponseDto updateDate(Integer id, RequestDto requestDto) {
		Optional<Employee> byId = employeeRepo.findById(id);
		if(!byId.isPresent()) {
			throw new EmployeeNotFound("Not Found Nothing");
		}
		
		Employee employee = byId.get();
		EmpConvertor.updateEmployee(employee, requestDto);
		Employee save = employeeRepo.save(employee);
		
		return EmpConvertor.employeeToResponseDto(save);
	}

	public String deleteData(String name) throws Exception {
		Optional<Employee> byId = employeeRepo.findByName(name);
		if(byId.isEmpty()) {
			throw new Exception("Id Data not present...");
		}
		employeeRepo.delete(byId.get());
		return "delete Successfully";
	}

	public List<ResponseDto> getAll() {
		List<Employee> list = employeeRepo.findAll();
		
		List<ResponseDto> ans = new ArrayList<>();
		for(Employee x: list) {
			ans.add(EmpConvertor.employeeToResponseDto(x));
		}
		return ans;
	}

	
}
