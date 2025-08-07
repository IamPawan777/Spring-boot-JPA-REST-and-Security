package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.OrderItem;

public interface OrderRepository extends JpaRepository<OrderItem, Double>{

}
