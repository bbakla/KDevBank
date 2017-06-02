package com.kdev.bank;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotFoundException;

public class ListTotalBankAmountTest {

    @Test
    public void new_bank_has_no_amount() {
	// Given/When
	Bank bank = new Bank();
	// Then
	assertEquals(new BigDecimal(0), bank.getTotalAmount());
    }

    @Test
    public void bank_with_accounts_with_no_balance_has_zero_total_amount() {
	// Given
	Bank bank = new Bank();
	String firstCustomerName = "Mihaela";
	bank.openAccount(firstCustomerName);

	String secondCustomerName = "Baris";
	bank.openAccount(secondCustomerName);
	// When
	BigDecimal totalAmount = bank.getTotalAmount();
	// Then
	assertEquals(BigDecimal.ZERO, totalAmount);
    }

    @Test
    public void bank_with_accounts_has_total_amount_as_the_the_sum_of_accounts_balance()
	    throws AccountNotFoundException {
	// Given
	Bank bank = new Bank();
	String customerName = "Mihaela";
	String accountNumber = bank.openAccount(customerName);
	Account customerAccount = bank.lookupAccountByNumber(accountNumber);
	BigDecimal amount = new BigDecimal(1000);
	customerAccount.deposit(amount);
	// When
	BigDecimal totalAmount = bank.getTotalAmount();
	// Then
	assertEquals(amount, totalAmount);
    }

    @Test
    public void closing_an_account_does_not_affect_total_amount()
	    throws AccountNotFoundException {
	// Given
	Bank bank = new Bank();
	String firstCustomerName = "Mihaela";
	String firstAccountNumber = bank.openAccount(firstCustomerName);
	Account firstCustomerAccount = bank
		.lookupAccountByNumber(firstAccountNumber);
	BigDecimal amount = new BigDecimal(1000);
	firstCustomerAccount.deposit(amount);

	String secondCustomerName = "Baris";
	String secondAccountNumber = bank.openAccount(secondCustomerName);
	bank.closeAccount(secondAccountNumber);
	// When
	BigDecimal totalAmount = bank.getTotalAmount();
	// Then
	assertEquals(amount, totalAmount);
    }

    @Test
    public void bank_with_accounts_has_total_amount_affected_by_withdraw()
	    throws AccountNotFoundException {
	// Given
	Bank bank = new Bank();
	String customerName = "Mihaela";
	String accountNumber = bank.openAccount(customerName);
	Account customerAccount = bank.lookupAccountByNumber(accountNumber);
	BigDecimal amount = new BigDecimal(1000);
	customerAccount.deposit(amount);
	// When
	BigDecimal totalAmount = bank.getTotalAmount();
	// Then
	assertEquals(amount, totalAmount);

	// When
	customerAccount.withdraw(amount);
	totalAmount = bank.getTotalAmount();
	// Then
	assertEquals(BigDecimal.ZERO, totalAmount);
    }
}
