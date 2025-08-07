package com.project.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mvc.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends  JpaRepository<UserDetails, String>{
	public UserDetails findByEmailIdAndPassword(String emailId ,String password);

}
