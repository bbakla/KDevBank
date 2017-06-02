package com.kdev.bank;

import java.util.HashMap;
import java.util.Map;

import com.kdev.bank.exception.AccountNotFoundException;

public class Bank {
    
    AccountNumberGenerator accNoGenerator = new UniqueAccountNumberGenerator();
    
    public Account createAccount(String customerName) {
	return new Account(customerName, accNoGenerator.generateAccountNumber());
    }
    
  private Map<String, Account> accountsByAccNumber = new HashMap<String, Account>();

  public String openAccount(String customerName) {
    return null;
  }

  public Account lookupAccountByNumber(String accountNumber)
      throws AccountNotFoundException {
    Account account = accountsByAccNumber.get(accountNumber);
    if (account == null)
      throw new AccountNotFoundException();
    else
      return account;
  }

}
