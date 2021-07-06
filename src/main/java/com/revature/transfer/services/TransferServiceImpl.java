package com.revature.transfer.services;

import com.revature.transfer.exceptions.InvalidAccountDetailsException;
import com.revature.transfer.repository.AccountRepository;

public class TransferServiceImpl implements TransferService{
	
	private AccountRepository accountRepository;
	
	public void transfer(double amount, String fromAccount, String toAccount) {
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
		accountRepository.debit(fromAccount, amount);
		accountRepository.credit(toAccount, amount);
	}
	
}