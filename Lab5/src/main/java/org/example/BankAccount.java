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
        return "Назва аккаунту: " + accountName +"/n" + "Номер аккаунту: " + accountNumber +"/n"
                + "Баланс аккаунту: " + Balance;
    }

    public void deposit(double amount){
        if(amount > 0) Balance += amount;
        else if (amount <= 0) {
            throw new NegativeAmountException(
                    "You can't add this number");
        }
    }
    public void withdraw(double amount){
        if(amount > 0) Balance -= amount;
        else if (amount < 0) {
            throw new NegativeAmountException(
                    "Сума не може бути від'ємною");
        }
        else if (amount > balance) {
            throw new InsufficientFundsException(
                    "Недостатньо коштів на рахунку");
        }
    }


}
