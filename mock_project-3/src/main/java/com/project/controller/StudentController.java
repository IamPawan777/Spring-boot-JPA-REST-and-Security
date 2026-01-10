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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.RequestDto;
import com.project.dto.ResponseDto;
import com.project.entity.Student;
import com.project.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add/student")
	public ResponseEntity<?> addStudent(@RequestBody RequestDto requestDto) {
		ResponseDto response = studentService.addStudent(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);	
	}
	
	
	
	@GetMapping("/get/all")
	public List<ResponseDto> getAllStudent(){
		return studentService.getAllStudent();
	}	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Long id){
		ResponseDto response = studentService.getStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	
	@PutMapping("/update/student/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody RequestDto requestDto){
		try {
			String response = studentService.updateStudent(id, requestDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/student/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") String email){
		try {
			String response = studentService.deleteStudent(email);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	
}
