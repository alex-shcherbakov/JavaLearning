package org.example;

public class Checker {
    public boolean isPalindrome(String word) {
        word = word.replaceAll("\\s", "").toLowerCase();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
