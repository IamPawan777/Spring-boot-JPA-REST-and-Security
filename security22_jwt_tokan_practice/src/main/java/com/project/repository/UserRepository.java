package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entiry.UserInformation;

@Repository
public interface UserRepository extends JpaRepository<UserInformation, String> {

	UserInformation findByEmailAndPassword(String email, String password);

}
