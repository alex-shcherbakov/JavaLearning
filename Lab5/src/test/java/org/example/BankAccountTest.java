package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    @Test
    public void testDeposit() throws NegativeAmountException {
        BankAccount account = new BankAccount(1, "Max", 200);
        account.deposit(500);
        assertEquals(700, account.getBalance());
    }

    @Test
    public void testDepositWithNegativeAmount() {
        BankAccount account = new BankAccount(1, "Sasha", 1000);
        assertThrows(NegativeAmountException.class, () -> {
            account.deposit(-500);
        });
    }

    @Test
    public void testWithdraw() throws NegativeAmountException, InsufficientFundsException {
        BankAccount account = new BankAccount(1, "Alice", 1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawWithNegativeAmount() {
        BankAccount account = new BankAccount(1, "Alice", 1000);
        assertThrows(NegativeAmountException.class, () -> {
            account.withdraw(-500);
        });
    }
    @Test
    public void testWithdrawWithInsufficientFunds() {
        BankAccount account = new BankAccount(1, "Alice", 1000);
        assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(1500);
        });
    }

    @Test
    public void testGetAccountSummary() {
        BankAccount account = new BankAccount(1, "Alice", 1000);
        String expected = "Account's name: Alice\nAccount's number: 1\nAccount's balance: 1000.0";
        assertEquals(expected, account.getAccountSummary());
    }

}