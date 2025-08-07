package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;			// setter injection
	
	public String saveUser() {
		boolean f = userDao.save();
		if(f) {
			return "registration Successfully";
		}
		else {
			return "server error";
		}
	}
}
