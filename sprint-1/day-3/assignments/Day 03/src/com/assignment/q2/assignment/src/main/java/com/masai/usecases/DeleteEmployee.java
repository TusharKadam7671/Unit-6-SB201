package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class DeleteEmployee {
	
	public static void deleteEmployee()
	{
		Scanner sc = new Scanner(System.in);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		System.out.println("Enter employee id");
		int empId = sc.nextInt();
		
		boolean value = dao.deleteEmployee(empId);
		
		if(value==true)
		{
			System.out.println("Employee removed successfully");
		}
		else
		{
			System.out.println("Employee not removed");
		}
	}

}
