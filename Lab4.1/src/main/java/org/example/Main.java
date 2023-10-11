package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Checker checker = new Checker();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String testWord = scanner.nextLine();
        boolean result = checker.isPalindrome(testWord);
        if (result) {
            System.out.println("Word '" + testWord + "' is a palindrome.");
        } else {
            System.out.println("Word '" + testWord + "' isn't a palindrome.");
        }
    }

    }
