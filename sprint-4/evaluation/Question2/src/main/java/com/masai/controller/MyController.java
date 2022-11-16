package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AccountException;
import com.masai.exception.InsufficientFundException;
import com.masai.model.Account;
import com.masai.model.AccountDTO;
import com.masai.service.AccountService;

@RestController
public class MyController {
	
	
	@Autowired
	private AccountService aService;
	
	
//	http://localhost:8888/accounts
	
	@PostMapping("/accounts")
	public ResponseEntity<Account> openAccountHandler(@RequestBody Account acc) throws AccountException
	{
		Account saved = aService.openAccount(acc);
		
		return new ResponseEntity<Account>(saved, HttpStatus.CREATED);
	}
	
//	http://localhost:8888/accounts/2
	
	@DeleteMapping("/accounts/{accno}")
	public ResponseEntity<Account> closeAccountHandler(@PathVariable("accno") Integer accountNo) throws AccountException
	{
		Account deleted = aService.closeAccount(accountNo);
		
		return new ResponseEntity<Account>(deleted, HttpStatus.ACCEPTED);
		
	}
	
//	http://localhost:8888/accounts/deposit/3/5000
	
	@PutMapping("/accounts/deposit/{accno}/{amount}")
	public ResponseEntity<Account> depositeAmountHandler(@PathVariable("accno") Integer accountNo,
			@PathVariable("amount") Integer amount) throws AccountException
	{
		Account deposited = aService.depositAmount(accountNo, amount);
		
		return new ResponseEntity<Account>(deposited, HttpStatus.ACCEPTED);
	}
	
	
//	http://localhost:8888/accounts/withdraw/3/4444
	
	@PutMapping("/accounts/withdraw/{accno}/{amount}")
	public ResponseEntity<Account> withdrawAmountHandler(@PathVariable("accno") int accountNo,
			@PathVariable("amount") Integer amount) throws AccountException, InsufficientFundException
	{
		Account withdraw = aService.withdrawAmount(accountNo, amount);
		
		return new ResponseEntity<Account>(withdraw,HttpStatus.CREATED);
	}
	
	
//	http://localhost:8888/accounts/dto
	
	@PostMapping("accounts/dto")
	public ResponseEntity<String> transferAmountHandler(@RequestBody AccountDTO dto) throws AccountException, InsufficientFundException
	{
		String str = aService.transferAmount(dto);
		
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

}
