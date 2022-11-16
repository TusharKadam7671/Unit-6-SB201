package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AccountDao;
import com.masai.dao.AccountDaoImpl;

public class Deposit {

	public static void deposit()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter amount");
		
		double  amount = sc.nextDouble();
		
		System.out.println("Enter account id");
		
		int  id = sc.nextInt();
		
		AccountDao dao = new AccountDaoImpl();
		
		String s = dao.deposit(amount, id);
		
		System.out.println(s);
	}
}
