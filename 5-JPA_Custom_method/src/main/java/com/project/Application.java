package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.entity.User;
import com.project.repository.UserDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		UserDao dao = run.getBean(UserDao.class);
		
//		User obj1 = new User();
//		obj1.setUserName("Savan");
//		obj1.setEmail("s@gmail.com");
//		obj1.setPassword("678");
//		obj1.setAddress("RTY");
//		dao.save(obj1);
		
		
		
		// get by name.....
//		User byuserName = dao.findByUserName("bharat");
//		System.out.println(byuserName);
		// or
//		List<User> allUser = dao.getAllUser1();
//		allUser.forEach(x -> System.out.println(x));
		// or
		List<User> allUser = dao.getAllUser2();
		allUser.forEach(x -> System.out.println(x));
		
		
		// get by address.....
//		System.out.println(dao.findByAddress("USA"));
		
		
		// get name and password	
//		User byUserNameAndPassword = dao.findByUserNameAndPassword("Bharat", "111");
//		System.out.println(byUserNameAndPassword);
		// or
//		User nameAndPass = dao.getNameAndPass1("Bharat", "111");
//		System.out.println(nameAndPass);
		// or
//		User nameAndPassword = dao.getNameAndPass2("Bharat", "111");
//		System.out.println(nameAndPassword);
		
		
//		List<User> byUserNameIsNull = dao.findByUserNameIsNull();
//		byUserNameIsNull.forEach(x -> System.out.println(x));
		
		
//		List<User> byUserNameLike = dao.findByUserNameLike("Apple");
//		byUserNameLike.forEach(x -> System.out.println(x));
		
		
//		List<User> byUserNameStaringWith = dao.findByUserNameContaining("Apple");
//		byUserNameStaringWith.forEach(x -> System.out.println(x));
		
//		List<User> byPasswordOrderByAsc = dao.findByOrderByPasswordAsc();
//		byPasswordOrderByAsc.forEach(x -> System.out.println(x));
		
//		boolean existByAddress = dao.existsByAddress("India");
//		System.out.println(existByAddress);
	}

}
