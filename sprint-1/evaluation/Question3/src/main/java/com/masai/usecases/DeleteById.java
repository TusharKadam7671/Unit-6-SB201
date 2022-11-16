package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AccountDao;
import com.masai.dao.AccountDaoImpl;
import com.masai.entities.Account;

public class DeleteById {
	
	public static void delete()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id");
		
		int id = sc.nextInt();
		
		AccountDao dao = new AccountDaoImpl();
		
		String s = dao.deleteAccountById(id);
		
		System.out.println(s);
	}

}
