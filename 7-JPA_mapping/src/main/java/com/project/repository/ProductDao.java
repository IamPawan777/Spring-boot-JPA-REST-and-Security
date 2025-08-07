package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
