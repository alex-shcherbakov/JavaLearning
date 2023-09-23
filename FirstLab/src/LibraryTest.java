import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("Test Book", "Test Author", "1234567890", 2023);
        library.addBook(book);
        assertEquals(1, library.books.size());
    }
    @Test
    void testFindBookByTitle() {
        Book book = new Book("Book1", "Author1", "1234567890", 2003);
        library.addBook(book);
        Book foundBook = library.findBookByTitle("Book1");
        assertNotNull(foundBook);
        assertEquals("Book1", foundBook.getTitle());
    }
    @Test
    void testRemoveBookByIsbn() {
        Book book = new Book("Book1", "Author1", "IT-KE-IB", 1124);
        library.addBook(book);
        library.removeBookByIsbn("IT-KE-IB");
        assertNull(library.findBookByTitle("Book1"));
    }
    @Test
    void testRemoveTwoBooks() {
        var book1 = new Book("test1","author1","123",1993);
        var book2 = new Book("test2","author2","123",1994);
        library.addBook(book1);
        library.addBook(book2);
        library.removeBookByIsbn("123");
        assertNotEquals(2,library.books.size());
    }
}