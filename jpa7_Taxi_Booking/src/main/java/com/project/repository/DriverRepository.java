package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

	@Query(value =  "SELECT * FROM driver WHERE cab_id = :cabId", nativeQuery = true )
	Driver getDriverByCabId(@Param("cabId") float cabId);
}
