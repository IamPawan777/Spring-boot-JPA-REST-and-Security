package com.project.entity;

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
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private float cab_id;
	
	private String cabNumber;
	private String cabModel;
	private double cabPerKmRate;
	private boolean cabAvailable;
}
