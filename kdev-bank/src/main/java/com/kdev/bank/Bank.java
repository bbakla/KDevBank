package com.kdev.bank;

import java.util.HashMap;
import java.util.Map;

import com.kdev.bank.exception.AccountNotFoundException;

public class Bank {

  private Map<String, Account> accountsByAccNumber = new HashMap<String, Account>();

  public Account lookupAccountByNumber(String accountNumber)
      throws AccountNotFoundException {
    Account account = accountsByAccNumber.get(accountNumber);
    if (account == null)
      throw new AccountNotFoundException();
    else
      return account;
  }

  public String openAccount(String name) {
    return null;

  }
}
