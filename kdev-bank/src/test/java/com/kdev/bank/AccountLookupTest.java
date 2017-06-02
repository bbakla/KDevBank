package com.kdev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotFoundException;

public class AccountLookupTest {

    @Test(expected = AccountNotFoundException.class)
    public void lookup_account_that_does_not_exist_throws_AccountNotFoundException()
	    throws AccountNotFoundException {
	Bank bank = new Bank();
	bank.lookupAccountByNumber("123456");
    }

    @Test
    public void lookup_account_that_exists_returns_the_account()
	    throws AccountNotFoundException {
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

    @Test(expected = NullPointerException.class)
    public void lookup_account_with_null_account_number_throws_runtime_exception()
	    throws AccountNotFoundException {
	Bank bank = new Bank();
	bank.lookupAccountByNumber(null);
    }
}
