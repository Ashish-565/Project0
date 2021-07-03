package com.revature.transfer;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {

	private Map<String, Double> account = new HashMap<String, Double>();

	public void loadAccount(String accountNumber) throws InvalidAccountDetailsException {
		throw new InvalidAccountDetailsException();
	}

	public void debit(String accountNumber, double amount) {
		if (account.get(accountNumber) >= amount) {
			System.out.println(
					"Account debited with: " + updateAccount(accountNumber, account.get(accountNumber) - amount));
		} else {
			System.out.println("Account don't have sufficient amount to debit");
		}
	}

	public void credit(String accountNumber, double amount) {
		System.out
				.println("Account credited with: " + updateAccount(accountNumber, account.get(accountNumber) + amount));
	}

	public double updateAccount(String accountNumber, double updatedAmount) {
		account.put(accountNumber, updatedAmount);
		return updatedAmount;
	}

}
