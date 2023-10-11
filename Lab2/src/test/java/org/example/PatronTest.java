package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatronTest {
    public Library library;
    public Book book1;
    public DVD dvd1;
    public Patron patron1;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1984", "QWERTY", "Night");
        dvd1 = new DVD("Us", "ASDFGH", 240);
        patron1 = new Patron("Ann", "zxcvbn");
    }

    @Test
    public void testSetName(){
        patron1.setName("John");
        assertTrue(patron1.getName().contains("John"));
    }

    @Test
    public void testSetId(){
        patron1.setID("1234");
        assertTrue(patron1.getID().contains("1234"));
    }

}