package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.dto.ResponseDTO;
import com.project.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	@Query("Select new com.project.dto.ResponseDTO(e.ename, AVG(e.esalary)) From Employee e Group By e.ename")
	List<ResponseDTO> findEmpDetains();
}
