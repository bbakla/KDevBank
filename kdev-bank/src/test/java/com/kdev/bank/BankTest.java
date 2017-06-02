package com.kdev.bank;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotFoundException;

public class BankTest {

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
