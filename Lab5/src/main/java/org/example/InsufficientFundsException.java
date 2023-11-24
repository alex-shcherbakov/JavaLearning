package org.example;
public class InsufficientFundsException extends Exception {
    private double withdrwedAmount;
    private double balance;
    public InsufficientFundsException(double withdrwedAmount, double balance) {
        super("Withdraw failed. " +
                "You're trying to withdraw " + withdrwedAmount + " but the current balance is " + balance);
        this.withdrwedAmount = withdrwedAmount;
        this.balance = balance;
    }

    public double getWithdrwedAmount(){
        return this.withdrwedAmount;
    }
    public double getBalance(){
        return this.balance;
    }

    public void setWithdrwedAmount(double withdrwedAmount){
        this.withdrwedAmount = withdrwedAmount;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

}
