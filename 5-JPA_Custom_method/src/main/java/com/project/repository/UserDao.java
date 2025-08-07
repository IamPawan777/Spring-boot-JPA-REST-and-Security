package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {

	
	User findByUserName(String userName);
	// or 
	@Query("SELECT u FROM User u")					// simple
	public List<User> getAllUser1();
	// or 
	@NativeQuery("SELECT * FROM User")					// native SQL
	public List<User> getAllUser2();
	
	
	User findByAddress(String address);
	 
	
	User findByUserNameAndPassword(String name, String pass);		// both true
	//  or
	@Query("SELECT u FROM User u WHERE u.userName = ?1 AND u.password = ?2")			// simple
	public User getNameAndPass1(String name, String pass);
	//or
	@Query("SELECT u FROM User u WHERE u.userName = :name AND u.password = :pass")			// param
	public User getNameAndPass2(@Param("name") String name, @Param("pass") String password); 
	
	
	List<User> findByUserNameIsNull();
		
	List<User> findByUserNameLike(String n);
	
	List<User> findByUserNameContaining(String name);
	
	List<User> findByOrderByPasswordAsc();
	
	boolean existsByAddress(String ad);

}
