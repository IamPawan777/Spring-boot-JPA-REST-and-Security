package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.RequestDto;
import com.project.dto.ResponseDto;
import com.project.entity.Student;
import com.project.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public ResponseDto addStudent(RequestDto requestDto) {
		Student student = new Student(requestDto.getName(), requestDto.getFees(), requestDto.getAddress(), requestDto.getEmail());
		studentRepository.save(student);
		
		ResponseDto response = new ResponseDto();
		response.setName(student.getName());
		response.setFees(student.getFees());
		response.setAddress(student.getAddress());
		return response;		
	}

	public List<ResponseDto> getAllStudent() {
//		List<Student> list = studentRepository.findAll();
//		return list.stream()
//				.map(student -> new ResponseDto(
//					student.getName(),
//					student.getFees(),
//					student.getAddress()
//					))
//				.toList();
		
		//.....OR....
		
		List<ResponseDto> response = studentRepository.getAllStudent();
		return response;		
	}
	
	

	public ResponseDto getStudent(Long id) {
		Optional<Student> byId = studentRepository.findById(id);
		if(!byId.isPresent()) {
			return new ResponseDto();
		}
		Student student = byId.get();
		return new ResponseDto(student.getName(), student.getFees(), student.getAddress());	
	}

	public String updateStudent(Long id, RequestDto requestDto) throws Exception {
		Optional<Student> byId = studentRepository.findById(id);
		if(!byId.isPresent()) {
			throw new Exception("Given Id not present in DB...");
		}
		Student student = byId.get();
		student.setName(requestDto.getName());
		student.setFees(requestDto.getFees());
		student.setAddress(requestDto.getAddress());
		studentRepository.save(student);
		return "Added Successfully";
		
	}

	public String deleteStudent(String email) throws Exception {
		List<Student> byEmail = studentRepository.findByEmail(email);		// email can be more so List
		if(byEmail.isEmpty()) {
			throw new Exception("Given Id not present in DB");
		}
//		Student student = byEmail.get();
		studentRepository.deleteAll(byEmail);
		return "Delete A/C Successfully";
		
	}
	
	
}
