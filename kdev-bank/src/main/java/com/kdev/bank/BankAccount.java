package com.kdev.bank;

import java.math.BigDecimal;

public class BankAccount {

  private String accountNumber;
  private String name;
  private BigDecimal balance;
  private boolean closed;
  
  public BankAccount(String name, String accountNumber) {
      this.name = name;
  }

  public String getCustomerName() {
    return name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}
