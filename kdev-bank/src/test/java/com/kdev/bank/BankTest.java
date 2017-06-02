package com.kdev.bank;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {

  @Test
  public void does_bank_account_exist() {

  }

  @Test
  public void can_bank_create_account() {
    Bank bank = new Bank();
    BankAccount account = bank.createAccount("John Doe");
    assertNotNull(account);
  }
  
  @Test
  public void is_account_owner_name_set_correctly() {
    Bank bank = new Bank();
    BankAccount account = bank.createAccount("John Doe");
    assertEquals("John Doe", account.getCustomerName());
  }
  
  @Test
  public void bank_account_id_is_unique() {
    Bank bank = new Bank();
    BankAccount account = bank.createAccount("John Doe");
    BankAccount account2 = bank.createAccount("Jane Doe");
    assertNotEquals(account.getAccountNumber(), account2.getAccountNumber());
  }
  
}
