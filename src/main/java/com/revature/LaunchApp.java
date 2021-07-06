package com.revature;

import java.util.Scanner;

import com.revature.transfer.services.TransferServiceImpl;

public class LaunchApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter amount to be transfered: ");
		double amount = scan.nextDouble();
		System.out.println("Enter from account details: ");
		String fromAccount = scan.next();
		System.out.println("Enter to account details: ");
		String toAccount = scan.next();
		
		TransferServiceImpl startApp = new TransferServiceImpl();
		startApp.transfer(amount, fromAccount, toAccount);
		
		scan.close();
	}

}
