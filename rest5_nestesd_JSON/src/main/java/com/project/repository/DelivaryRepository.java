package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.DelivaryAddress;

public interface DelivaryRepository extends JpaRepository<DelivaryAddress, Integer> {

}
