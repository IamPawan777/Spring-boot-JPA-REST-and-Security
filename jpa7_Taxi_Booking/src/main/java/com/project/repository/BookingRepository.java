package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
