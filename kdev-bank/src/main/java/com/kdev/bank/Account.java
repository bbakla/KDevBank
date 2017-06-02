package com.kdev.bank;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private String name;
    private BigDecimal balance;
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
	closed = true;
    }
}
