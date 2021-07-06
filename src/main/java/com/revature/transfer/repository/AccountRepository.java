package com.revature.transfer.repository;

import com.revature.transfer.exceptions.InvalidAccountDetailsException;

public interface AccountRepository {
	void loadAccount(String accountNumber) throws InvalidAccountDetailsException;
	void debit(String accountNumber, double amount);
	void credit(String accountNumber, double amount);
	double updateAccount(String accountNumber, double updatedAmount);
}
