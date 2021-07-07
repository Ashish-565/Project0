package com.revature.transfer.services;

public interface TransferService {
	void transfer(double amount, int fromAccount, int toAccount);
	void transactions();
}
