package com.kdev.bank;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotFoundException;

public class BankTest {

    @Test(expected = AccountNotFoundException.class)
    public void lookup_account_that_does_not_exist_throws_BankAccountNotFoundException()
	    throws AccountNotFoundException {
	Bank bank = new Bank();
	bank.lookupAccountByNumber("123456");
    }

    @Test
    public void lookup_account_that_exists_returns_the_account() throws AccountNotFoundException {
	// Given:
	Bank bank = new Bank();
	String name = "Mihaela";
	// When:
	String accountNumber = bank.openAccount(name);
	// Then/When:
	Account account = bank.lookupAccountByNumber(accountNumber);
	assertNotNull(account);
	assertEquals(name, account.getName());
	assertEquals(accountNumber, account.getAccountNumber());
    }

    @Test
    public void can_bank_create_account() throws AccountNotFoundException {
	Bank bank = new Bank();
	String accountNumber = bank.openAccount("John Doe");
	Account account = bank.lookupAccountByNumber(accountNumber);
	assertNotNull(account);
    }

    @Test
    public void is_account_owner_name_set_correctly() {
	Bank bank = new Bank();
	String account = bank.openAccount("John Doe");
	// assertEquals("John Doe", account.getName());
    }

    @Test
    public void bank_account_id_is_unique() {
	Bank bank = new Bank();
	String account = bank.openAccount("John Doe");
	String account2 = bank.openAccount("Jane Doe");
	// assertNotEquals(account.getAccountNumber(),
	// account2.getAccountNumber());
    }

}
