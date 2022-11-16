package com.masai.service;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AccountException;
import com.masai.exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;
import com.masai.repository.AccountDao;


@Service
public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
	private AccountDao dao;

	@Override
	public Account openAccount(Account acc) throws AccountException {
		// TODO Auto-generated method stub
		return dao.save(acc);
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		// TODO Auto-generated method stub
		
		if(dao.findById(accno).isPresent())
		{
			Account deletedacc = dao.findById(accno).get();
			
			dao.delete(deletedacc);
			
			return deletedacc;
		}
		else
		{
			throw new AccountException("Account not found");
		}
		
	}

	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
		// TODO Auto-generated method stub
		if(dao.findById(accno).isPresent())
		{
			Account acc = dao.findById(accno).get();
			
			acc.setBalance(acc.getBalance() + amount);
			
			dao.save(acc);
			
			return acc;
		}
		else
		{
			throw new AccountException("Account not found");
		}
		
		
	}

	@Override
	public Account withdrawAmount(int accno, Integer amount) throws AccountException, InsufficientFundException {
		// TODO Auto-generated method stub
		if(dao.findById(accno).isPresent())
		{
			Account acc = dao.findById(accno).get();
			
			
			if(acc.getBalance() > amount)
			{
				acc.setBalance(acc.getBalance() - amount);
				
				dao.save(acc);
				
				return acc;
				
			}
			else
			{
				throw new InsufficientFundException("Balance is not sufficient");
			}
			
		}
		else
		{
			throw new AccountException("Account not found");
		}
		
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException {
		// TODO Auto-generated method stub
		
		if(dao.findById(dto.getSrcAccno()).isPresent() && dao.findById(dto.getDesAccno()).isPresent())
		{
			Account srcacc = dao.findById(dto.getSrcAccno()).get();
			Account desacc = dao.findById(dto.getDesAccno()).get();
			
			if(srcacc.getBalance() > dto.getAmount())
			{
				srcacc.setBalance( srcacc.getBalance() - dto.getAmount() );
				desacc.setBalance( desacc.getBalance() + dto.getAmount() );
				
				dao.save(srcacc);
				dao.save(desacc);
				
				return "Money trasfered successfully";
			}
			else
			{
				throw new InsufficientFundException("Balance is not sufficient in account");
			}
		}
		else
		{
			throw new AccountException("Account is not found");
		}
		
	}

}
