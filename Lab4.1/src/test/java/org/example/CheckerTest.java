package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    private Checker checker;
    @BeforeEach
    public void setUp(){
        checker = new Checker();
    }
    @Test
    public void testIsPalindrome() {
        assertTrue(checker.isPalindrome("carrac"));
        assertTrue(checker.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testIsNotPalindrome() {
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("I am"));
    }

    @Test
    public void testIsPalindromeEmptyString() {
        assertTrue(checker.isPalindrome(""));
    }

}