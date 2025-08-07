package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.entity.Employee;

public interface EmployeeRepository_JPQL extends JpaRepository<Employee, Integer>{
	
	// @Query(value = "SELECT * FROM employee", nativeQuery = true)		// native
	@Query(value = "SELECT e FROM Employee e", nativeQuery = false)		// JPQL
	public List<Employee> loadAllEmployee();
	
	
	@Query(value = "SELECT e FROM Employee e WHERE name = ?1AND city = :city")
	public List<Employee> loadRecordByNameAge(String name, @Param("city") String city);
	
}
