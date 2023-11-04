package org.example;

import static org.junit.jupiter.api.Assertions.*;
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("John Doe", 1000.0);
        BankAccount account2 = bank.createAccount("Jane Smith", 500.0);

        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);

        try {
            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 200.0);

            System.out.println("Account 1 balance after transfer: " + account1.getBalance());
            System.out.println("Account 2 balance after transfer: " + account2.getBalance());

        } catch (AccountNotFoundException | NegativeAmountException |
                 InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}