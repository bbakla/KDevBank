package com.kdev.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kdev.bank.exception.AccountNotFoundException;

public class Bank {

    private AccountNumberGenerator accNoGenerator = new UniqueAccountNumberGenerator();
    private Map<String, Account> accountsByAccNumber = new HashMap<String, Account>();

    public String openAccount(String customerName) {
	Account acc = new Account(customerName,
		accNoGenerator.generateAccountNumber());
	accountsByAccNumber.put(acc.getAccountNumber(), acc);
	return acc.getAccountNumber();
    }

    public Account lookupAccountByNumber(String accountNumber)
	    throws AccountNotFoundException {
	if (accountNumber == null)
	    throw new IllegalArgumentException();
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

    public List<String> listAccountNumbers() {
	List<String> accountNumbers = new ArrayList<String>();
	for (Account account : accountsByAccNumber.values()) {
	    accountNumbers.add(account.getAccountNumber());
	}
	return accountNumbers;
    }

    public BigDecimal getTotalAmount() {
	BigDecimal total = new BigDecimal(0).setScale(2, 1);
	for (Entry<String, Account> entry : accountsByAccNumber.entrySet()) {
	    total = total.add(entry.getValue().getBalance());
	}
	return total;
    }
}
