package org.example;

public class BankAccount {
    int accountNumber;
    String accountName;
    double balance;

    public BankAccount(int number, String name, double balance) {
        this.accountNumber = number;
        this.accountName = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Account's name: " + accountName + "\n" + "Account's number: " + accountNumber + "\n"
                + "Account's balance: " + balance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new NegativeAmountException("You can't add this amount");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount, balance);
        }
        balance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
