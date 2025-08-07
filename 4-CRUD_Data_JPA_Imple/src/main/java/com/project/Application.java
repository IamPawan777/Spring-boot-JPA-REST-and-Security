package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.entity.Student;
import com.project.repository.StudentDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		StudentDao repo = context.getBean(StudentDao.class);
		
		Student st1 = new Student();
		st1.setName("Cat");
		st1.setAddress("Pakistan");
		
		Student st2 = new Student();
		st2.setName("Donkey");
		st2.setAddress("West Aisa");
		
		Student st3 = new Student();
		st3.setName("Extra ordianary");
		st3.setAddress("India");
		
		
		
//		// ......create........
//		repo.save(st1);
		
//		//  ......create multiple.......
//		List<Student> list = new ArrayList<>();
//		list.add(st1);
//		list.add(st2);
//		list.add(st3);
//		repo.saveAll(list);
		
		
		
		
		// ......read all (get).........
//		List<Student> all = repo.findAll();
//		all.forEach(x -> System.out.println(x));		
		
//		// ......read by Id.........
//		Optional<Student> byId = repo.findById(2);
//		System.out.println(byId);
		
		
		
		
		
//		//......update............
//		Student student = repo.findById(11).get();
//		// OR.....
//		Optional<Student> student = repo.findById(12);
//		Student s = student.get();
//		s.setName("Bisht");
//		repo.save(s);
		

		
		
		
//		//.....delete.........
//		Student st = repo.findById(11).get();
//		repo.delete(st);
//		repo.deleteById(4);
//		repo.deleteAll();
//		repo.deleteAll(list);
//		System.out.println("Delete Successfully");
		
		
	}

}
