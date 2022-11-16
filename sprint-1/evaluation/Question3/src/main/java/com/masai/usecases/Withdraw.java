package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AccountDao;
import com.masai.dao.AccountDaoImpl;

public class Withdraw {
	
	public static void withdraw()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter amount");
		
		double  amount = sc.nextDouble();
		
		System.out.println("Enter account id");
		
		int  id = sc.nextInt();
		
		AccountDao dao = new AccountDaoImpl();
		
		String s = dao.withdraw(amount, id);
		
		System.out.println(s);
	}

}
