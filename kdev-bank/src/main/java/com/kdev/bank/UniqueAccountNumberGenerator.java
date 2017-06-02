package com.kdev.bank;

public class UniqueAccountNumberGenerator implements AccountNumberGenerator {

    private int generator = 0;

    public String generateAccountNumber() {
	return String.format("%08d", generator++);
    }

}
