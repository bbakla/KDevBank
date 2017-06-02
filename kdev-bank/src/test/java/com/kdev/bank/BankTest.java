package com.kdev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import static org.junit.Assert.*;

import com.kdev.bank.exception.AccountNotFoundException;

public class BankTest {

  @Test(expected = AccountNotFoundException.class)
  public void lookup_account_that_does_not_exist_throws_BankAccountNotFoundException()
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

  @Test
  public void can_bank_create_account() {
    Bank bank = new Bank();
    BankAccount account = bank.createAccount("John Doe");
    assertNotNull(account);
  }
  
}
