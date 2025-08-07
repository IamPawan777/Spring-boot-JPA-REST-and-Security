package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, Integer> {

}
