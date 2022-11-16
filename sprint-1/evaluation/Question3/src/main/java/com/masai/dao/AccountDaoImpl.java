package com.masai.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.connectivity.GetConnection;
import com.masai.entities.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public Account findById(int id) {
		
		EntityManager em = GetConnection.getConnection().createEntityManager();
		
		Account account = em.find(Account.class, id);
		
		if(account != null)
		{
			em.close();
			return account;
		}else
		{
			em.close();
			return null;
		}
		
		
		
	}

	@Override
	public String save(Account account) {
		
		String s = "Account saved";
		
		EntityManager em = GetConnection.getConnection().createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		em.close();
		
		
		
		return s;

	}

	@Override
	public String deleteAccountById(int id) {
		
		
		
		EntityManager em = GetConnection.getConnection().createEntityManager();
		
		Account account = em.find(Account.class, id);
		
		if(account != null)
		{
			em.getTransaction().begin();
			
			em.remove(account);
			
			em.getTransaction().commit();
			
			em.close();
			
			return "Account deleted";
		}else
		{
			return "Account not found";
		}
		
		
		
		
		
	}

	@Override
	public String withdraw(double amount, int accountId) {
		
		EntityManager em = GetConnection.getConnection().createEntityManager();
		
		Account account = em.find(Account.class, accountId);
		
		if(account==null)
		{
			return "account not found";
		}else
		{
			if(amount>account.getBalance())
			{
				return "balance is not sufficient";
			}else
			{
				em.getTransaction().begin();
				
				account.setBalance(account.getBalance()-amount);
				
				em.getTransaction().commit();
				
				em.close();
				
				return "Amount withdrawn successfully";
			}
		}
	}

	@Override
	public String deposit(double amount, int accountId) {
		
		EntityManager em = GetConnection.getConnection().createEntityManager();
		
		Account account = em.find(Account.class, accountId);
		
		if(account==null)
		{
			return "account not found";
		}else
		{
			em.getTransaction().begin();
			
			account.setBalance(account.getBalance()+amount);
			
			em.getTransaction().commit();
			
			em.close();
			
			return "Amount deposited successfully";
		}
		
	}

}
