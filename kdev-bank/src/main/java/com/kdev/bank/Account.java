package com.kdev.bank;

import java.math.BigDecimal;

import com.kdev.bank.exception.AccountNotEmptyException;

public class Account {

    private String accountNumber;
    private String name;
    private BigDecimal balance = new BigDecimal(0).setScale(2, 1);
    private boolean closed;

    public Account(String name, String accountNumber) {
	this.name = name;
	this.accountNumber = accountNumber;
    }

    public String getName() {
	return name;
    }

    public String getAccountNumber() {
	return accountNumber;
    }

    public boolean isClosed() {
	return closed;
    }

    public void close() {
	if (balance.compareTo(BigDecimal.ZERO) > 0) {
	    throw new AccountNotEmptyException();
	}
	closed = true;
    }

    public boolean deposit(BigDecimal amount) {
	if (amount.compareTo(BigDecimal.ZERO) >= 0) {
	    amount.setScale(2, 1);
	    balance = balance.add(amount).setScale(2, 1);
	    return true;
	} else {
	    return false;
	}
    }

    public BigDecimal getBalance() {
	return balance;
    }

    public void withdraw(BigDecimal amount) {
	balance = balance.subtract(amount);

    }
}
