package org.example;


public class Main {
    public static void main(String[] args) {
        String encryptedMessage = "t2st3ng uftujoh";
        String decodedMessage = Decoder.decodeMessage(encryptedMessage);
        System.out.println("Зашифроване повідомлення: " + encryptedMessage);
        System.out.println("Розшифроване повідомлення: " + decodedMessage);
    }
}