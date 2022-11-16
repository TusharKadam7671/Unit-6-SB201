package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GiveBonus {
	
	public static void giveBons()
	{
		Scanner sc = new Scanner(System.in);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		System.out.println("Enter employee id");
		int empId = sc.nextInt();
		
		System.out.println("Enter bonus amount");
		int bonus = sc.nextInt();
		
		String s = dao.giveBonusToEmployee(empId, bonus);
		
		System.out.println(s);
		
	}

}
