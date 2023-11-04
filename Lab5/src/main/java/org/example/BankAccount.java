package org.example;

public class BankAccount {
    int accountNumber;
    String accountName;
    double Balance;

    public BankAccount(int Number, String Name, double balance){
        this.accountNumber = Number;
        this.accountName = Name;
        this.Balance = balance;
    }

    public double  getBalance(){
        return Balance;
    }
    public String getAccountSummary(){
        return "Account's name: " + accountName +"\n" + "Account's number: " + accountNumber +"\n"
                + "Account's balance: " + Balance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if(amount > 0) Balance += amount;
        else if (amount <= 0) {
            throw new NegativeAmountException(
                    "You can't add this number");
        }
    }
    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }
        if (amount > Balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        Balance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}
