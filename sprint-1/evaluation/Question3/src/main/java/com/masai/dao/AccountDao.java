package com.masai.dao;

import com.masai.entities.Account;

public interface AccountDao {

	public Account findById(int id);
	public String save(Account account);
	public String deleteAccountById(int id);
	public String withdraw(double amount,int accountId);
	public String deposit(double amount,int accountId);
	
}
