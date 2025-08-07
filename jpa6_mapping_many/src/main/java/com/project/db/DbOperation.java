package com.project.db;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.entity.Laptop;
import com.project.entity.Student;
import com.project.repository.StudentRepository;

@Component
public class DbOperation {
	@Autowired
	StudentRepository studentRepo;
	
	public void addRecords() {		
		Student std = new Student();
		std.setStd_name("Harry");
		std.setAge(21);
		
		Laptop lp1 = new Laptop(1, "Dell", 12121);
		Laptop lp2 = new Laptop(2, "Acer", 40000);
		Laptop lp3 = new Laptop(3, "Apple", 8900);		
		List<Laptop> list = new ArrayList<>();
		list.add(lp1);
		list.add(lp2);
		list.add(lp3);
	
		std.setLaptops(list);
		
		studentRepo.save(std);
	}
	
	public void getRecords() {
		Student s = studentRepo.findById(1).get();
		System.out.println(s);
	}
	
	public void getAllRecords() {
		List<Student> s = studentRepo.findAll();
		s.forEach(System.out::println);
	}
	
	
}
