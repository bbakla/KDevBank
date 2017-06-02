package com.kdev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.kdev.bank.exception.AccountNotEmptyException;

public class AccountTest {

    private static final String JOHN_DOE = "John Doe";

    @Test
    public void is_account_owner_name_set_correctly() {
	// Given
	Account acc = new Account(JOHN_DOE, "01");
	// When/Then
	assertEquals(JOHN_DOE, acc.getName());
    }

    @Test
    public void account_can_be_closed() {
	// Given
	Account acc = new Account(JOHN_DOE, "01");
	// When/Then
	assertFalse(acc.isClosed());

	// Given
	acc.close();
	// When/Then
	assertTrue(acc.isClosed());
    }

    @Test
    public void depositing_money_will_increase_balance_proportionally() {
	// Given
	Account acc = new Account(JOHN_DOE, "01");
	BigDecimal deposit = new BigDecimal(100);

	// When
	BigDecimal initial = acc.getBalance();
	acc.deposit(deposit);

	// Then
	BigDecimal afterAdd = acc.getBalance();
	assertEquals(initial.add(deposit), afterAdd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositing_negative_amount_money_will_not_work() {
	// Given
	Account acc = new Account(JOHN_DOE, "01");
	BigDecimal depositValue = new BigDecimal(-100);

	// When
	acc.deposit(depositValue);

	// Then
	BigDecimal afterDeposit = acc.getBalance();
	assertEquals(0, afterDeposit.longValueExact());
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositing_null_amount_money_will_not_work() {
	Account acc = new Account(JOHN_DOE, "01");
	acc.deposit(null);
    }

    @Test
    public void depositing_less_than_one_hundredth_of_a_unit_does_not_change_balance() {
	// Given
	Account acc = new Account(JOHN_DOE, "01");
	BigDecimal depositValue = new BigDecimal(0.001);

	// When
	acc.deposit(depositValue);

	// Then
	BigDecimal afterDeposit = acc.getBalance();
	assertTrue(afterDeposit.compareTo(BigDecimal.ZERO) == 0);
    }

    @Test(expected = AccountNotEmptyException.class)
    public void closing_an_account_which_is_not_empty_fails() {
	// Given
	Account acc = new Account(JOHN_DOE, "01");
	BigDecimal depositValue = new BigDecimal(1);

	// When
	acc.deposit(depositValue);

	// Then
	acc.close();
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_name_is_not_null() {
	Account acc = new Account(null, "01");
    }
}
