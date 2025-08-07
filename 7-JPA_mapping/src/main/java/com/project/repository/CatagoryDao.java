package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Catagory;

public interface CatagoryDao extends JpaRepository<Catagory, Integer> {

}
