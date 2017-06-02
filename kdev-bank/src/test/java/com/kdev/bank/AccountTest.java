package com.kdev.bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

    @Test
    public void is_account_owner_name_set_correctly() {
	Account acc = new Account("John Doe", "01");
	assertEquals("John Doe", acc.getName());
    }

}
