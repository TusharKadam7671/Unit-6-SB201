package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.entities.Employee;

public class SaveEmp {
	
	public static void saveEmp()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter empId");
		int empId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter name");
		String name = sc.nextLine();
		
		System.out.println("Enter address");
		String address = sc.nextLine();
		
		System.out.println("Enter salary");
		int salary = sc.nextInt();
		
		Employee emp = new Employee(empId,name,address,salary);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		dao.save(emp);
		
	}

}
