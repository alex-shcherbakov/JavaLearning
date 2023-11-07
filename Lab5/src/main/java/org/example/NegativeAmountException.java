package org.example;

public class NegativeAmountException extends Exception{
    private double amount;
    public NegativeAmountException(double amount){
        super("Operation failed." +
                " You can't deposit a negative sum.");
        this.amount = amount;
    }


    public double getAmount(){
        return this.amount;
    }
}
