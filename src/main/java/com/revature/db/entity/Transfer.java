package com.revature.db.entity;

import java.sql.Time;

public class Transfer {
	private int transactionId;
	private Time dateAndTime;
	private int amount;
	private String creditOrDebit;
	private int balance;
	
	public Transfer(int transactionId, Time dateAndTime, int amount, String creditOrDebit, int balance) {
		super();
		this.transactionId = transactionId;
		this.dateAndTime = dateAndTime;
		this.amount = amount;
		this.creditOrDebit = creditOrDebit;
		this.balance = balance;
	}
	
	public Transfer() {

	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Time getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Time dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCreditOrDebit() {
		return creditOrDebit;
	}

	public void setCreditOrDebit(String creditOrDebit) {
		this.creditOrDebit = creditOrDebit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transfer [transactionId=" + transactionId + ", dateAndTime=" + dateAndTime + ", amount=" + amount
				+ ", creditOrDebit=" + creditOrDebit + ", balance=" + balance + "]";
	}
	
}
