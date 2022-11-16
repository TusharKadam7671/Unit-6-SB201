package com.masai.usecases;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Department;
import com.masai.model.Employee;

public class AddDepartment {
	
	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		Department dept = new Department();
		dept.setDeptName("Sales");
		dept.setLocation("Pune");
		
		dao.addDepartment(dept);
		
	}
	
	
	

}
