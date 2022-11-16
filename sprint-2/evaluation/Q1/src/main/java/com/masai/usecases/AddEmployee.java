package com.masai.usecases;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Address;
import com.masai.model.Department;
import com.masai.model.Employee;

public class AddEmployee {
	
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDaoImpl();
		Employee emp = new Employee();
		emp.setEmpName("Ramesh");
		emp.setSalary(80000);
		emp.setAddress( new Address("Mumbai", "MH", "451236"));
		
		dao.addEmployee(emp);
		
	}
	
	
	
	

}
