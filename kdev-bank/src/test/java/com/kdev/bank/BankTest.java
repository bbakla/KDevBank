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
  
}
