package com.revature.transfer.repository;

import java.sql.Time;
import java.time.LocalTime;

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
			System.out.println(
					"Account debited with: " + updateAccount(accountNumber, accountDb.balance(accountNumber) - amount));
			LocalTime time = LocalTime.now();
			transferDb.save(new Transfer(trans_id, Time.valueOf(time), (int)amount, "debit"));
		} else {
			throw new InsufficientAmountException();
		}
	}

	public void credit(int accountNumber, double amount) {
		System.out
				.println("Account credited with: " + updateAccount(accountNumber, accountDb.balance(accountNumber) + amount));
		LocalTime time = LocalTime.now();
		transferDb.save(new Transfer(trans_id, Time.valueOf(time), (int)amount, "credit"));
		trans_id += 1;
	}

	public double updateAccount(int accountNumber, double updatedAmount) {
		accountDb.update(accountNumber, (int)updatedAmount);
		return updatedAmount;
	}

}
