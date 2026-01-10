package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.RequestDTO;
import com.project.dto.ResponseDTO;
import com.project.service.EmployeeService;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add/details")
	public ResponseEntity<?> addEmpDetails(@RequestBody RequestDTO requestDTO) {
		String msg = employeeService.addEmpDetails(requestDTO);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/fetch/details")
	public List<ResponseDTO> getEmpDetails(){
		return employeeService.getEmpDetails();
	}
}
