package com.masai.model;

public class Employee {
	
	private int EmpId;
	private String EmpName;
	private String department;
	private int salary;
	
	
	public Employee() {
		super();
	}

	

	public Employee(int empId, String empName, String department, int salary) {
		super();
		EmpId = empId;
		EmpName = empName;
		this.department = department;
		this.salary = salary;
	}



	public int getEmpId() {
		return EmpId;
	}


	public void setEmpId(int empId) {
		EmpId = empId;
	}


	public String getEmpName() {
		return EmpName;
	}


	public void setEmpName(String empName) {
		EmpName = empName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", department=" + department + ", salary=" + salary
				+ "]";
	}

}
