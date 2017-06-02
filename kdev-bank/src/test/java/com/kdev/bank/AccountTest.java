package com.kdev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

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

    @Test
    public void depositing_money_will_increase_balance_proportionally() {
	Account acc = new Account("John Doe", "01");
	BigDecimal deposit = new BigDecimal(100);

	BigDecimal initial = acc.getBalance();
	boolean depositOk = acc.deposit(deposit);
	BigDecimal afterAdd = acc.getBalance();
	assertEquals(initial.add(deposit), afterAdd);
	assertTrue(depositOk);
    }

    @Test
    public void depositing_negative_amount_money_will_not_work() {
	Account acc = new Account("John Doe", "01");
	BigDecimal depositValue = new BigDecimal(-100);
	acc.deposit(depositValue);
	BigDecimal afterDeposit = acc.getBalance();
	assertEquals(0, afterDeposit.longValueExact());
    }

    @Test
    public void depositing_less_than_one_hundredth_of_a_unit_does_not_change_balance() {
	Account acc = new Account("John Doe", "01");
	BigDecimal depositValue = new BigDecimal(0.001);
	acc.deposit(depositValue);
	BigDecimal afterDeposit = acc.getBalance();
	assertTrue(afterDeposit.compareTo(BigDecimal.ZERO) == 0);
    }
}
