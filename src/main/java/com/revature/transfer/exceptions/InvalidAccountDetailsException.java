package com.revature.transfer.exceptions;

@SuppressWarnings("serial")
public class InvalidAccountDetailsException extends Exception {
	@Override
	public String getMessage() {
		return "Invalid Account number: ";
	}
}
