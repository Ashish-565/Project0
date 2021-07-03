package com.revature.transfer;

@SuppressWarnings("serial")
public class InvalidAccountDetailsException extends Exception {
	@Override
	public String getMessage() {
		return "Invalid Account details";
	}
}
