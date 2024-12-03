package org.lld.dao;

import org.lld.entities.Book;
import org.lld.entities.BookMetric;
import org.lld.repo.Library;

import java.util.Map;

public class LibraryDao {


    /**
     * Add book
     * @param library
     * @param book
     * @return
     */

    public synchronized String addBook(Library library,Book book){
        Map<String, Book> books = library.getBooks();
        books.put(book.getId(),book);
        return book.getId();
    }

    /**
     * Add book metric
     * @param library
     * @param bookMetric
     * @return
     */
    public synchronized boolean addBookMetric(Library library, BookMetric bookMetric){
        Map<String, BookMetric> bookMetrics = library.getBookMetric();
        bookMetrics.put(bookMetric.getBookId(),bookMetric);
        return true;
    }

    public synchronized String getBookId(String ){
        return null;
    }
}
