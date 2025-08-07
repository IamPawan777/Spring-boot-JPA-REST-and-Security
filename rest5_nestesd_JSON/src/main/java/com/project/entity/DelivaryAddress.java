package com.project.entity;

import com.project.request.DelivaryAddressRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Amazon_DelivaryAddress")
public class DelivaryAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	private String dStreetName;
	private String dBuildingName;
	private String dFlatNo;
	private String dCity;
	private String dState;
	private int dPinCode;
}
