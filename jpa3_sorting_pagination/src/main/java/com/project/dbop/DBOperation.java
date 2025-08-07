package com.project.dbop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.project.entity.Employee;
import com.project.repository.EmployeeRepository;

@Component
public class DBOperation {

//    private final Jpa3SortingPaginationApplication jpa3SortingPaginationApplication;
	@Autowired
	EmployeeRepository empRepo;
	
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
	
	
	// sorting
	public void getSortedOrder() {		
		Sort sort = Sort.by("age").descending();				// sort by age property//		
		List<Employee> list = empRepo.findAll(sort);
		for(Employee x : list) {
			System.out.println(x);
		}
	}
	
	
	
	//pagination 
	//first page till no of page
	public void getInitalEmpInformation(int NoOfRecord) {
		Page<Employee> all = empRepo.findAll(Pageable.ofSize(NoOfRecord));
		all.forEach(System.out::println);
		
	}
	
	// page arrange with P.K.
	public void getFixEmpInformation(int pageNo, int NoOfRecord) {
		List<Employee> all = empRepo.findAll(PageRequest.of(pageNo, NoOfRecord)).getContent();
		all.forEach(System.out::println);
	}
	
	//pages arrange with age ......
	public void getFixSortedEmpInformation(int pageNo, int NoOfRecord) {
		Sort sort = Sort.by("age");	
		Page<Employee> page = empRepo.findAll(PageRequest.of(pageNo, NoOfRecord, sort));
		page.forEach(System.out::println);
		
	}

	

}
