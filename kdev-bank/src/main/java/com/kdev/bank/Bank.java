package com.kdev.bank;

import java.util.HashMap;
import java.util.Map;

import com.kdev.bank.exception.AccountNotFoundException;

public class Bank {

    private AccountNumberGenerator accNoGenerator = new UniqueAccountNumberGenerator();
    private Map<String, Account> accountsByAccNumber = new HashMap<String, Account>();

    public String openAccount(String customerName) {
	Account acc = new Account(customerName, accNoGenerator.generateAccountNumber());
	accountsByAccNumber.put(acc.getAccountNumber(), acc);
	return acc.getAccountNumber();
    }

    public Account lookupAccountByNumber(String accountNumber) throws AccountNotFoundException {
	if (accountNumber == null)
	    throw new NullPointerException();
	Account account = accountsByAccNumber.get(accountNumber);
	if (account == null)
	    throw new AccountNotFoundException();
	else
	    return account;
    }

    public void closeAccount(String accountNumber) {
	Account acc = accountsByAccNumber.get(accountNumber);
	acc.close();
	accountsByAccNumber.remove(accountNumber);
    }

}
