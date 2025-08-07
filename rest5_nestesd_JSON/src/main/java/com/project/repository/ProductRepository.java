package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.ProductInfo;

public interface ProductRepository extends JpaRepository<ProductInfo, Integer> {

}
