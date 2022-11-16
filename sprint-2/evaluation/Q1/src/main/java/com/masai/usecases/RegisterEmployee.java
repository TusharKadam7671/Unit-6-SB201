package com.masai.usecases;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.exception.EmployeeException;

public class RegisterEmployee {
	
	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.registerEmployeeTODepartment(2, 1);
		} catch (EmployeeException | DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
