package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import com.project.entity.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	
	private String name;
	private int age;
	
	@Column(unique = true, nullable = false)
	private String emailId;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_ID")
	private List<Booking> booking = new ArrayList<>();
	
	
}
