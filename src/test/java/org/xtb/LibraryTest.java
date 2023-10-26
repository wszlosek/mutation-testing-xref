package org.xtb;

import org.junit.jupiter.api.Test;
import org.xtb.Book;
import org.xtb.Library;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    Library library = new Library();

    @Test
    public void testAddAndFindBook() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook(book);
        assertEquals(book, library.findBookByTitle("The Great Gatsby"));
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("Moby Dick", "Herman Melville");
        library.addBook(book);
        library.borrowBook("Moby Dick");
        assertTrue(book.isBorrowed());
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee");
        library.addBook(book);
        library.borrowBook("To Kill a Mockingbird");
        library.returnBook("To Kill a Mockingbird");
        assertFalse(book.isBorrowed());
    }

//    @Test
//    public void testAddMultipleBooksAndFindOne() {
//        Book book1 = new Book("Book 1", "Author 1");
//        Book book2 = new Book("Book 2", "Author 2");
//        library.addBook(book1);
//        library.addBook(book2);
//
//        assertEquals(book2, library.findBookByTitle("Book 2"));
//    }
//
//    @Test
//    public void testBookAuthorExists() {
//        Book book = new Book("To Kill a Mockingbird", "Harper Lee");
//        assertEquals("Harper Lee", book.getAuthor());
//    }
//
//    @Test
//    public void testBookAuthorIsEmpty() {
//        Book book = new Book("To Kill a Mockingbird", "");
//        assertEquals("", book.getAuthor());
//    }
//
//    @Test
//    public void testBookAuthorIsNull() {
//        Book book = new Book("To Kill a Mockingbird", "");
//        assertEquals("", book.getAuthor());
//    }
}