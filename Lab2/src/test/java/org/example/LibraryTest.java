package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
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
    public void testAddItem() {
        library.add(book1);
        assertEquals(1,library.items.size());
    }

    @Test
    public void testRemoveItem() {
        library.add(book1);
        library.remove(book1);
        assertEquals(0,library.items.size());
    }

    @Test
    public void testRegisterPatron() {
        library.registerPatron(patron1);
        assertTrue(library.patrons.contains(patron1));
    }

    @Test
    public void testLendItem() {
        library.add(book1);
        library.registerPatron(patron1);

        library.lendItem(patron1, book1);
        assertTrue(patron1.getBorrowedItems().contains(book1));
    }

    @Test
    public void testReturnItem(){
        library.add(book1);
        library.registerPatron(patron1);
        library.lendItem(patron1, book1);
        library.returnItem(patron1, book1);
        assertFalse(patron1.getBorrowedItems().contains(book1));

    }
}