package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Emp;

public interface EmpDao extends JpaRepository<Emp, Integer> {

}
