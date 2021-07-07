package com.revature.db.entity;

import java.sql.Timestamp;

public class Transfer {
	private int transactionId;
	private Timestamp dateAndTime;
	private int amount;
	private String creditOrDebit;
	
	public Transfer(int transactionId, Timestamp time, int amount, String creditOrDebit) {
		super();
		this.transactionId = transactionId;
		this.dateAndTime = time;
		this.amount = amount;
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

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp time) {
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
