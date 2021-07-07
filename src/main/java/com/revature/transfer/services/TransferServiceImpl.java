package com.revature.transfer.services;

import com.revature.transfer.exceptions.InsufficientAmountException;
import com.revature.transfer.exceptions.InvalidAccountDetailsException;
import com.revature.transfer.repository.AccountRepository;

public class TransferServiceImpl implements TransferService{
	
	private AccountRepository accountRepository;
	
	public void transfer(double amount, int fromAccount, int toAccount) {
		try {
			accountRepository.loadAccount(fromAccount);
		} catch (InvalidAccountDetailsException e) {
			System.out.println(e.getMessage()+" of from Account");
		}
		try {
			accountRepository.loadAccount(toAccount);
		} catch (InvalidAccountDetailsException e) {
			System.out.println(e.getMessage()+" of to Account");
		}
		try {
			accountRepository.debit(fromAccount, amount);
		} catch (InsufficientAmountException e) {
			System.out.println(e.getMessage());
		}
		accountRepository.credit(toAccount, amount);
		
	}

	public void transactions() {
		//call transacton db
	}
	
}
