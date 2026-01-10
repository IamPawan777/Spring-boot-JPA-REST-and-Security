package com.project.dto;

public class ResponseDTO {
	private String name;
	private double salary;
	
	public ResponseDTO(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
}
