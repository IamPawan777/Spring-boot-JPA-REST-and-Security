package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value = "SELECT * FROM employee", nativeQuery = true)
	public List<Employee> loadAllRecords();
	
	@Query(value = "SELECT * FROM employee  WHERE age>?1 AND countary=?2", nativeQuery = true)
	public List<Employee> loadEmployeeByAge(String age, String countary);
	
	@Query(value = "SELECT * FROM employee WHERE  age < :empAge AND gender = :empGender", nativeQuery = true)
	public List<Employee> loadEmpGenderName(@Param("empGender") String gender, @Param("empAge") int age);
	
	
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO employee VALUES(e_id = :empID, pin= :pin, salary= :sly, age= :age, city= :city, countary= :con, gender= :gen, name= :name)", nativeQuery = true)
	public void addEmployeeRecord(@Param("empID") int id,  @Param("name") String name, @Param("age") int age, @Param("sly") float salary,  @Param("city") String city,@Param("gen") String gender, @Param("pin") int pin, @Param("con") String countary);
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM employee WHERE e_id= :employeeID", nativeQuery = true)
	public int deleteEmployeeRecord(@Param("employeeID") int e_id);
	
	
}
