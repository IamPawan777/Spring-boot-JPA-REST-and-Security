package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.project.entity.Student;

public interface StudentDao extends JpaRepository<Student,  Integer> {
	
}
