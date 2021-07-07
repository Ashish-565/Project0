package com.revature.db.entity;

import java.sql.Time;

public class Transfer {
	private int transactionId;
	private Time dateAndTime;
	private int amount;
	private String creditOrDebit;
	
	public Transfer(int transactionId, Time time, int amount2, String creditOrDebit) {
		super();
		this.transactionId = transactionId;
		this.dateAndTime = time;
		this.amount = amount2;
		this.creditOrDebit = creditOrDebit;
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

	public void setDateAndTime(Time time) {
		this.dateAndTime = time;
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

	@Override
	public String toString() {
		return "Transfer [transactionId=" + transactionId + ", dateAndTime=" + dateAndTime + ", amount=" + amount
				+ ", creditOrDebit=" + creditOrDebit + "]";
	}
	
}
