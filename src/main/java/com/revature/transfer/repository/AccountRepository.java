package com.revature.transfer.repository;

import com.revature.transfer.exceptions.InsufficientAmountException;
import com.revature.transfer.exceptions.InvalidAccountDetailsException;

public interface AccountRepository {
	void loadAccount(int accountNumber) throws InvalidAccountDetailsException;
	void debit(int accountNumber, double amount) throws InsufficientAmountException;
	void credit(int accountNumber, double amount);
	double updateAccount(int accountNumber, double updatedAmount);
}
