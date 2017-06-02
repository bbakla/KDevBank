package com.kdev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ListAccountsTest {

    @Test
    public void new_bank_has_no_accounts() {
	Bank bank = new Bank();
	assertTrue(bank.listAccountNumbers().isEmpty());
    }

    @Test
    public void opened_account_is_found_in_the_list_of_bank_accounts() {
	// Given
	Bank bank = new Bank();
	String name = "Mihaela";
	String accountNumber = bank.openAccount(name);
	// When:
	List<String> accounts = bank.listAccountNumbers();
	// Then:
	assertEquals(1, accounts.size());
	assertEquals(accountNumber, accounts.get(0));
    }

    @Test
    public void closed_account_is_not_found_in_the_list_of_bank_accounts() {
	// Given
	Bank bank = new Bank();
	String name = "Mihaela";
	String accountNumber = bank.openAccount(name);
	bank.closeAccount(accountNumber);
	// When:
	List<String> accounts = bank.listAccountNumbers();
	// Then:
	assertEquals(0, accounts.size());

    }
}
