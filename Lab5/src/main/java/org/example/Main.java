package org.example;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            BankAccount account1 = bank.createAccount("Клієнт 1", 1000);
            BankAccount account2 = bank.createAccount("Клієнт 2", 500);

            account1.deposit(200);
            account2.withdraw(300);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            bank.transferMoney(1, 2, 300);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());
        } catch (AccountNotFoundException | InsufficientFundsException | NegativeAmountException e) {
            e.printStackTrace();
        }

    }
}