package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GetAddress {
	
	public static void getAddress()
	{
		Scanner sc = new Scanner(System.in);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		System.out.println("Enter employee id");
		int empId = sc.nextInt();
		
		String s = dao.getAddressOfEmployee(empId);
		
		System.out.println("Address of employee with id "+empId+" is: "+s);
	}

}
