package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int e_id;
	private String name;
	private int age;
	private float salary;
	private String city;
	private String gender;
	private long pin;
	private String countary;
	
//	public Employee() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public Employee(String name, int age, float salary, String city, String gender, long pin, String countary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.city = city;
		this.gender = gender;
		this.pin = pin;
		this.countary = countary;
	}
	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", city=" + city
				+ ", gender=" + gender + ", pin=" + pin + ", countary=" + countary + "]";
	}
	
}
