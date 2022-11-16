package com.masai;

import java.util.Objects;

import org.springframework.stereotype.Component;


@Component
public class Student {
	
	private int roll;
	private String name;
	private String address;
	private String email;
	private int marks;
	
	
	

	public Student(int roll, String name, String address, String email, int marks) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
		this.email = email;
		this.marks = marks;
	}


	


	public int getRoll() {
		return roll;
	}





	public String getName() {
		return name;
	}





	public String getAddress() {
		return address;
	}





	public String getEmail() {
		return email;
	}





	public int getMarks() {
		return marks;
	}





	@Override
	public int hashCode() {
		return Objects.hash(address, email, marks, name, roll);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email) && marks == other.marks
				&& Objects.equals(name, other.name) && roll == other.roll;
	}




	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", address=" + address + ", email=" + email + ", marks="
				+ marks + "]";
	}
	
	
	
	
	

}
