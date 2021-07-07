package com.revature.transfer.repository;

import java.sql.Timestamp;
import java.util.Date;

import com.revature.db.entity.Transfer;
import com.revature.db.repository.AccountRepositoryDb;
import com.revature.db.repository.AccountRepositoryDbImpl;
import com.revature.db.repository.TransferRepository;
import com.revature.db.repository.TransferRepositoryImpl;
import com.revature.transfer.exceptions.InsufficientAmountException;
import com.revature.transfer.exceptions.InvalidAccountDetailsException;

public class AccountRepositoryImpl implements AccountRepository {

	AccountRepositoryDb accountDb = new AccountRepositoryDbImpl();
	TransferRepository transferDb = new TransferRepositoryImpl();
	
	private static int trans_id = 1230;

	public void loadAccount(int accountNumber) throws InvalidAccountDetailsException {
		if(accountDb.check(accountNumber)) {
		}else {
			throw new InvalidAccountDetailsException();
		}
	}

	public void debit(int accountNumber, double amount) throws InsufficientAmountException {
		if (accountDb.balance(accountNumber) >= amount) {
			updateAccount(accountNumber, accountDb.balance(accountNumber) - amount);
			Timestamp time=new Timestamp(new Date().getTime());
			transferDb.save(new Transfer(trans_id, time, (int)amount, "debit"));
		} else {
			throw new InsufficientAmountException();
		}
	}

	public void credit(int accountNumber, double amount) {
		updateAccount(accountNumber, accountDb.balance(accountNumber) + amount);
		Timestamp time=new Timestamp(new Date().getTime());
		transferDb.save(new Transfer(trans_id, time, (int)amount, "credit"));
		trans_id += 1;
	}

	public void updateAccount(int accountNumber, double updatedAmount) {
		accountDb.update(accountNumber, (int)updatedAmount);
	}

}
