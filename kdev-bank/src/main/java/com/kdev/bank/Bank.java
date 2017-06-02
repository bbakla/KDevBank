package com.kdev.bank;

public class Bank {
    
    AccountNumberGenerator accNoGenerator = new UniqueAccountNumberGenerator();
    
    public BankAccount createAccount(String customerName) {
	return new BankAccount(customerName, accNoGenerator.generateAccountNumber());
    }
    
}
