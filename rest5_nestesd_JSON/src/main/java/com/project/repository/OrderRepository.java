package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}
