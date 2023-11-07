package org.example;

public class NegativeAmountException extends Exception{
    private double amount;
    public NegativeAmountException(double amount){
        this.amount = amount;
        super("Opertion failed." +
                "you can't deposit negative sum");

    }

    public double getAmount(){
        return this.amount;
    }
}
