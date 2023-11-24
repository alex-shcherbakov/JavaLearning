package org.example;

public class InvalidBookingException extends Exception {
    public int num;
    public InvalidBookingException(int num) {
        super("You are trying to book seat that doesn't exist or already booked : " + num );
        this.num = num;
    }
    public int getNum(){
        return this.num;
    }
    public void(int num){
        this.num = num;
    }
}
