package com.kdev.bank;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotFoundException;
import com.kdev.bank.exception.NotEnoughMoneyInTheAccountException;

public class WithdrawalTest {

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_negative_amount_throws_illegal_argument_exception()
	    throws AccountNotFoundException,
	    NotEnoughMoneyInTheAccountException {
	// Given
	Bank bank = new Bank();
	String customerName = "Baris";
	String accountNumber = bank.openAccount(customerName);
	Account account = bank.lookupAccountByNumber(accountNumber);
	// When/Then
	account.withdraw(new BigDecimal(-20).setScale(2, 1));
    }

    @Test(expected = NotEnoughMoneyInTheAccountException.class)
    public void try_withdraw_more_than_balance_throws_exception()
	    throws AccountNotFoundException,
	    NotEnoughMoneyInTheAccountException {
	// Given
	Bank bank = new Bank();
	String customerName = "Baris";
	String accountNumber = bank.openAccount(customerName);
	Account account = bank.lookupAccountByNumber(accountNumber);
	// When/Then
	account.withdraw(new BigDecimal(200).setScale(2, 1));

    }

    @Test
    public void after_witdrawial_the_balance_decreased_by_the_withdrawn_amount()
	    throws AccountNotFoundException,
	    NotEnoughMoneyInTheAccountException {
	// Given
	Bank bank = new Bank();
	String customerName = "Baris";
	String accountNumber = bank.openAccount(customerName);
	Account account = bank.lookupAccountByNumber(accountNumber);
	account.deposit(new BigDecimal(500).setScale(2, 1));
	// When
	account.withdraw(new BigDecimal(200).setScale(2, 1));
	// Then
	assertEquals(new BigDecimal(300).setScale(2, 1), account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void try_withdrawing_null_amount_throws_illegal_argument_exception()
	    throws AccountNotFoundException,
	    NotEnoughMoneyInTheAccountException {
	// Given
	Bank bank = new Bank();
	String customerName = "Baris";
	String accountNumber = bank.openAccount(customerName);
	Account account = bank.lookupAccountByNumber(accountNumber);
	account.deposit(new BigDecimal(500).setScale(2, 1));
	// When/Then
	account.withdraw(null);

    }
}
