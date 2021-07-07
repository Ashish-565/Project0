package com.revature.transfer.services;

import com.revature.db.repository.TransferRepositoryImpl;
import com.revature.transfer.exceptions.InsufficientAmountException;
import com.revature.transfer.exceptions.InvalidAccountDetailsException;
import com.revature.transfer.repository.AccountRepository;
import com.revature.transfer.repository.AccountRepositoryImpl;

public class TransferServiceImpl implements TransferService{
	
	private AccountRepository accountRepository = new AccountRepositoryImpl();
	
	public void transfer(double amount, int fromAccount, int toAccount) {
		try {
			accountRepository.loadAccount(fromAccount);
			accountRepository.loadAccount(toAccount);
			accountRepository.debit(fromAccount, amount);
			accountRepository.credit(toAccount, amount);
		} catch (InvalidAccountDetailsException e) {
			System.out.println(e.getMessage());
		} catch (InsufficientAmountException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void transactions() {
		new TransferRepositoryImpl().getTransfers().forEach(transaction->System.out.println(transaction));
	}
	
}
