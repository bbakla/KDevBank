package com.kdev.bank;

import java.math.BigDecimal;

import com.kdev.bank.exception.AccountNotEmptyException;
import com.kdev.bank.exception.NotEnoughMoneyInTheAccountException;

public class Account {

    private String accountNumber;
    private String name;
    private BigDecimal balance = new BigDecimal(0).setScale(2, 1);
    private boolean closed;

    public Account(String name, String accountNumber) {
	if (name == null || accountNumber == null) {
	    throw new IllegalArgumentException(
		    "Customer name or account number are not allowed to be null");
	}
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

    public void deposit(BigDecimal amount) {
	if (amount == null) {
	    throw new IllegalArgumentException("Amount was null");
	}

	if (amount.compareTo(BigDecimal.ZERO) >= 0) {
	    amount.setScale(2, 1);
	    balance = balance.add(amount).setScale(2, 1);
	} else {
	    throw new IllegalArgumentException(
		    "Amount to be added is lower than zero");
	}
    }

    public BigDecimal getBalance() {
	return balance;
    }

    public void withdraw(BigDecimal amount)
	    throws NotEnoughMoneyInTheAccountException {
	if (!isValid(amount))
	    throw new IllegalArgumentException(
		    "Please provide a positive amount.");
	if (balance.subtract(amount).compareTo(BigDecimal.ZERO) < 0)
	    throw new NotEnoughMoneyInTheAccountException();
	balance = balance.subtract(amount);

    }

    private boolean isValid(BigDecimal amount) {
	if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
	    return false;
	}
	return true;
    }
}
