package com.project.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Amazon_OrderDetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	private String name;
	private String email;
	private String mobile;
	private String totalAmount;
	
//	@Cascade(CascadeType.ALL)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductInfo> productinfo;
	
	@OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private DelivaryAddress delivaryAddress;
	
	@OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private PaymentDetails paymentDetails;
}

