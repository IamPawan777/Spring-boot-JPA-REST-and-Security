package com.project.entity;

import java.sql.Date;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.entity.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	
	private String pickUp;
	private String destination;
	private float tripDistance;
	
	private Status tripStatus;
	private double billAmount;			// tripDistance * perKmRate
	
	@CreationTimestamp
	private LocalTime bookedAt;
	@UpdateTimestamp
	private Date lastUpdateAt;
	
}
