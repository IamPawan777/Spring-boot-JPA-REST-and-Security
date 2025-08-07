package com.project.dbop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.project.Jpa3SortingPaginationApplication;
import com.project.entity.Employee;
import com.project.repository.EmployeeRepository;

@Component
public class DBOperation {

    private final Jpa3SortingPaginationApplication jpa3SortingPaginationApplication;

//    private final Jpa3SortingPaginationApplication jpa3SortingPaginationApplication;
	@Autowired
	EmployeeRepository empRepo;

    DBOperation(Jpa3SortingPaginationApplication jpa3SortingPaginationApplication) {
        this.jpa3SortingPaginationApplication = jpa3SortingPaginationApplication;
    }
	
	public void addEmpData() {
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add(new Employee("Krishna", 32, 121.22f, "Delhi", "MALE", 1290, "India"));
		list.add(new Employee("Lokesh", 21, 1.92f, "Pune", "MALE", 9876, "Pakishtan"));
		list.add(new Employee("Bhavana", 32, 34.2f, "HYD", "FEMALE", 5670, "Lanka"));
		list.add(new Employee("Mohan", 11, 99.22f, "Banglore", "MALE", 1111, "India"));
		list.add(new Employee("Omsir", 22, 89.222f, "Haldwani", "FEMALE", 9999, "UK"));
		list.add(new Employee("Ram", 44, 1.00f, "Dehradoon", "MALE", 5671, "UK"));
		list.add(new Employee("Sita", 12, 33.22f, "Delhi", "MALE", 1290, "India"));
		list.add(new Employee("Hanuman", 88, 4.22f, "Delhi", "MALE", 1010, "India"));
		list.add(new Employee("Krishna", 32, 12121.22f, "Goa", "FEMALE", 7788, "Italy"));
		empRepo.saveAll(list);
	}
	
	
	public void getAllRecord() {
		List<Employee> list = empRepo.loadAllRecords();
		list.forEach(System.out::println);
	}
	
	public void getRecorViaAge(String age, String contary) {
		List<Employee> list = empRepo.loadEmployeeByAge(age, contary);
		list.forEach(System.out::println);
	}
	
	public void getRecordViaGenderName(int age, String gender) {
		List<Employee> list = empRepo.loadEmpGenderName(gender, age);
		list.forEach(System.out::println);
	}
	
	public void addElement(int id, String name, int age, float salary, String city, String gender, int pin, String countary ) {
		empRepo.addEmployeeRecord(id, name, age, salary, city, gender, pin, countary);
	}
	
	public void deleteDataEmp(int id) {
		int val = empRepo.deleteEmployeeRecord(id);
		System.out.println(val);
	}
	

}
