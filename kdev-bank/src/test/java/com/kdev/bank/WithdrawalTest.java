package com.kdev.bank;

import java.math.BigDecimal;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotFoundException;

public class WithdrawalTest {

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_negative_amount_throws_illegal_argument_exception()
	    throws AccountNotFoundException {
	// Given
	Bank bank = new Bank();
	String customerName = "Baris";
	String accountNumber = bank.openAccount(customerName);
	Account account = bank.lookupAccountByNumber(accountNumber);
	// When/Then
	account.withdraw(new BigDecimal(-20).setScale(2, 1));
    }
}
