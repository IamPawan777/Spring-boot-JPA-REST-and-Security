package com.project.entity;

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
@Table(name = "STD_DATA")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	private String name;
	private int age;
	private float fees;
	private String city;
	private String gender;
	private long pin;
	
	public Student(String name, int age, float fees, String city, String gender, long pin) {
		super();
		this.name = name;
		this.age = age;
		this.fees = fees;
		this.city = city;
		this.gender = gender;
		this.pin = pin;
	}

//	public Student() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", name=" + name + ", age=" + age + ", fees=" + fees + ", city=" + city
				+ ", gender=" + gender + ", pin=" + pin + "]";
	} 
	
		
	
}
