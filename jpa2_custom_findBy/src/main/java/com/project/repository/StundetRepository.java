package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Student;

public interface StundetRepository extends JpaRepository<Student, Integer> {
	List<Student> findByGender(String gender);
	
	List<Student> findByName(String name);
	
	List<Student> findByNameAndCity(String name, String city);
	
	int deleteByName(String name);
}
