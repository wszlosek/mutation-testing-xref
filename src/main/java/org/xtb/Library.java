package org.xtb;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public void borrowBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
        } else {
            throw new IllegalStateException("Book not found or already borrowed");
        }
    }

    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
        } else {
            throw new IllegalStateException("Book not found or wasn't borrowed");
        }
    }
}