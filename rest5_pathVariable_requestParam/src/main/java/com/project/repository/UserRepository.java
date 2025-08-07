package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {

	public List<UserDetails> findByGenderAndCity(String gender, String city);

	public List<UserDetails> findByCity(String city);

	public List<UserDetails> findByGender(String gender);


}
