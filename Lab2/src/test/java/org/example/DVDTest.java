package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DVDTest {
    public Library library;
    public DVD dvd1;

    @BeforeEach
    public void setUp() {
        library = new Library();
        dvd1 = new DVD("Us", "ASDFGH", 240);
    }

    @Test
    public void testSetDuration(){
        dvd1.setDuration(135);
        assertEquals(135,dvd1.getDuration());
    }
}