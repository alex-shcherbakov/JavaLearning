package org.example;
import java.util.HashMap;

public class Bank {
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccount createAccount(String accountName, double initialDeposit){
        int accountNumber = accounts.size() + 1;
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.put(accountNumber, account);
        return account;
    }
    public BankAccount findAccount(int accountNumber){
        BankAccount account = accounts.get(accountNumber);
        return account;
    }
    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount){
        BankAccount from = findAccount(fromAccountNumber);
        BankAccount to = findAccount(toAccountNumber);

        from.withdraw(amount);
        to.deposit(amount);

    }
}
