package com.project.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Student;
import com.project.repository.StundetRepository;

@Component
public class DBOperation {
	@Autowired
	StundetRepository studentRepo;
	
	public void addStudentData() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Krisana", 21, 121.12f, "Delhi", "Male", 12));
		list.add(new Student("Lokesh", 23, 213.2f, "Mumbai", "Male", 23));
		list.add(new Student("Naman", 11, 23.23f, "Banglore", "Female", 11));
		list.add(new Student("Pawan", 24, 88.88f, "Hydrabad", "Male", 38));
		list.add(new Student("Harry", 34, 110.99f, "Pune", "Female", 90));
		list.add(new Student("Sam", 30, 6688.66f, "Chennei", "Male", 78));
		studentRepo.saveAll(list);
	}
	
	public void findOneRecord() {
		Optional<Student> id = studentRepo.findById(2);
		System.out.println(id);
	}
	
	public void findOneRecordByGender(String gen) {
		List<Student> list = studentRepo.findByGender(gen);
		for(Student s: list)
			System.out.println(s);
	}
	
	public void findRecordByName(String name) {
		List<Student> list =  studentRepo.findByName(name);
		for(Student s: list)
			System.out.println(s);
	}
	
	public void findRecordNameAndCity(String name, String city) {
		List<Student> list = studentRepo.findByNameAndCity(name, city);
		for(Student s: list)
			System.out.println(s);
	}
	
}
