package org.example;

public class NegativeAmountException extends Exception{
    public NegativeAmountException(String errorMessage){
        super(errorMessage);
    }
}
