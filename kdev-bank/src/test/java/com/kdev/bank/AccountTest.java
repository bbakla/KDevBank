package com.kdev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountTest {

    @Test
    public void is_account_owner_name_set_correctly() {
	Account acc = new Account("John Doe", "01");
	assertEquals("John Doe", acc.getName());
    }

    @Test
    public void account_can_be_closed() {
	Account acc = new Account("John Doe", "01");
	assertFalse(acc.isClosed());
	acc.close();
	assertTrue(acc.isClosed());
    }
}
