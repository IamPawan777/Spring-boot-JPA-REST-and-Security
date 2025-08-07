package com.project.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Student;
import com.project.repository.StundetRepository;

import jakarta.transaction.Transactional;

@Component
public class DBOperationDlt {
	
	@Autowired
	StundetRepository studentRepo;

	public void dltRecordById(int id) {
		studentRepo.deleteById(id);
		
	}
	
	@Transactional
	public void dltRecordByName(String name) {
		int dlt = studentRepo.deleteByName(name);
		System.out.println(dlt);
	}
	
	public void updeteSomeData(int id, String city) {		
//		Optional<Student> student = studentRepo.findById(id);
//		Student s = student.get();
//		// OR.....
		Student student = studentRepo.findById(id).get();
		student.setCity(city);
		studentRepo.save(student);
	}
}
