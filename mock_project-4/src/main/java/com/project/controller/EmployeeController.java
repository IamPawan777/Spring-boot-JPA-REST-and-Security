package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.RequestDto;
import com.project.dto.ResponseDto;
import com.project.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add/data")
	public ResponseDto addData(@RequestBody RequestDto requestDto) {
		ResponseDto data = employeeService.addData(requestDto);
		return data;
	}
	
	@GetMapping("/all")
	public List<ResponseDto> getAll() {
		List<ResponseDto> list = employeeService.getAll();
		return list;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateData(@PathVariable Integer id, @RequestBody RequestDto requestDto) {
		ResponseDto response;
		try {
			response = employeeService.updateDate(id, requestDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{name}")
	public String deleleData(@PathVariable String name) {
		String str;	
		try {
			str = employeeService.deleteData(name);
		} catch (Exception e) {
			str = e.getMessage();
		}
		return str;
	}
	
}
