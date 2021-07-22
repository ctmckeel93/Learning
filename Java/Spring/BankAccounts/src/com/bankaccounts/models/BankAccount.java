package com.bankaccounts.models;
import java.util.Random;

public class BankAccount {
	
	public static int numOfAccounts;
	private static double bankRevenue;
	
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	public BankAccount() {
		this.accountNumber = Initialize();
		this.checkingBalance = 0;
		this.savingsBalance = 0;
		numOfAccounts++;
	}
	
	private String Initialize() {
		Random rng = new Random();
		String account = "";
		
		for (int i = 0; i < 10; i++) {
			account += rng.nextInt(10);
		}
		return account;
		
	}
	
	public double getChecking() {
		System.out.println(checkingBalance);
		return this.checkingBalance;
	}
	
	public double getSavings() {
		System.out.println(savingsBalance);
		return this.savingsBalance;
	}
	
	public void deposit(double amount, String account) {
		
		if (account == "checking") {
			this.checkingBalance += amount;
		}
		
		if (account == "savings") {
			this.savingsBalance += amount;
		}
		
	}
	
	public void withdraw(double amount, String account) {
		
		if (account == "checking" ) {
			if (this.checkingBalance - amount >= 0) {
				this.checkingBalance -= amount;
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		
		if (account == "savings" ) {
			if (this.savingsBalance - amount >= 0) {
				this.savingsBalance -= amount;
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
	}
	
	public double getTotalBalance() {
		System.out.println(checkingBalance + savingsBalance);
		return this.checkingBalance + this.savingsBalance;
	}
	
	
}
