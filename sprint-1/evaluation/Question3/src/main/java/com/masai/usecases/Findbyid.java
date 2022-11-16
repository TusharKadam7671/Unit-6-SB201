package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AccountDao;
import com.masai.dao.AccountDaoImpl;
import com.masai.entities.Account;

public class Findbyid {
	
	public static void find()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id");
		
		int id = sc.nextInt();
		
		AccountDao dao = new AccountDaoImpl();
		
		Account ac = dao.findById(id);
		
		if(ac==null)
		{
			System.out.println("Account not found");
		}else
		{
			System.out.println(ac);
		}
	}

}
