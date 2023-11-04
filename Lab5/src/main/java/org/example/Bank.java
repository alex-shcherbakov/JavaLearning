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
    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account №" + accountNumber + " wasn't found");
        }

        return account;
    }


    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, NegativeAmountException, InsufficientFundsException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } finally {
            System.out.println("Transfer completed");
        }
    }
}

