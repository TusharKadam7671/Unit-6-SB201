package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalariedEmployee extends Employee{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int salary;
	private String email;
	
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ContractualEmployee [salary=" + salary + ", email=" + email + "]";
	}
	
	

}
