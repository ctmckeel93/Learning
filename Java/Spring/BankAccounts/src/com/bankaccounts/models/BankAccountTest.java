package com.bankaccounts.models;

public class BankAccountTest {

	public static void main(String[] args) {
//		Initializing Account
		BankAccount newAccount = new BankAccount();
		
//		Testing getters
		newAccount.getChecking();
		newAccount.getSavings();
		
//		Testing checking setters
		newAccount.deposit(100, "checking");
		newAccount.withdraw(150, "checking");
		newAccount.withdraw(50, "checking");
		newAccount.getChecking();
		
//		Testing savings getters
		newAccount.deposit(100, "savings");
		newAccount.withdraw(150, "savings");
		newAccount.withdraw(50, "savings");
		newAccount.getSavings();
		
//		Testing total balance display
		newAccount.getTotalBalance();
	}

}
