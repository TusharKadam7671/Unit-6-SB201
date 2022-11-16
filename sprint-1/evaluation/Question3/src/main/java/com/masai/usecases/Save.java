package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AccountDao;
import com.masai.dao.AccountDaoImpl;
import com.masai.entities.Account;

public class Save {
	
	public static void save()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id");
		
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter email");
		String email = sc.nextLine();
		
		System.out.println("Enter address");
		String address = sc.nextLine();
		
		System.out.println("Enter balance");
		double balance = sc.nextDouble();
		
		Account ac = new Account(id, email, address, balance);
		
		AccountDao dao = new AccountDaoImpl();
		
		String s = dao.save(ac);
		
		System.out.println(s);
		
	}

}
