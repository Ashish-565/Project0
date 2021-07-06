package com.revature.db.entity;

public class Amount {
	private int accountNumber;
	private int accountBalance;
	
	public Amount(int accountNumber, int accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public Amount() {

	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Amount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + "]";
	}
	
	
}
