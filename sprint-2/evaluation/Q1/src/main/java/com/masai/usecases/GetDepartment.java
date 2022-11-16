package com.masai.usecases;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.DepartmentException;
import com.masai.model.Department;

public class GetDepartment {
	
	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			Department dept = dao.getDepartmentDetailsByEmployeeId(2);
			
			System.out.println(dept.getDeptId());
			System.out.println(dept.getDeptName());
			System.out.println(dept.getLocation());
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
