package com.project;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.project.dao.EmployeeDao;
import com.project.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		EmployeeDao bean = run.getBean(EmployeeDao.class);
		
//		Employee e1 = new Employee();
//		e1.setName("Naina ");
//		e1.setProfession("Donor");
//		e1.setSalary(10);
//		bean.save(e1);
		
		
		
		// sorting..........		
		Sort sort = Sort.by("salary").descending();					// sort by salary property
		
		List<Employee> all = bean.findAll(sort);
		all.forEach(x -> System.out.println(x));
		System.out.println("....................");
		
		
		
		// pagination and sorting..........
		Pageable pageable= PageRequest.of(2, 4, sort);					// staring to end (page no),   no of page in one webpage
		Page<Employee> page = bean.findAll(pageable);
		page.get().forEach(x -> System.out.println(x));
		
		System.out.println("current page content: "+page.getContent());		
		System.out.println("one page size: "+page.getSize());
		System.out.println("current page: "+page.getNumber());
		System.out.println("total element in table: "+page.getTotalElements());
		System.out.println("total pages set:" +page.getTotalPages());
		
		
		
		
	}

}
