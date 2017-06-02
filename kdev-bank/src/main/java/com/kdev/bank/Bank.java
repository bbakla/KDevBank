package com.kdev.bank;

public class Bank {
    
    public BankAccount createAccount(String customerName) {
	return new BankAccount(customerName, "");
    }

}
