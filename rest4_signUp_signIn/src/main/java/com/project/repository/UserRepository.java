package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {
	public UserDetails findByEmailIdAndPassword(String emailId, String password);
}
