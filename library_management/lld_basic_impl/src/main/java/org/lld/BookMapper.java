package org.lld;

import org.lld.entities.Book;
import org.lld.entities.BookMetric;

public class BookMapper {
    /**
     * Create Book Object
     * @param name
     * @param author
     * @param pages
     * @return
     */
    public Book createBook(String name, String author, int pages){
        Book book = new Book(name,author,pages);
        return book;
    }

    /**
     * Create Book Metric
     * @param bookId
     * @param quantity
     * @return
     */
    public BookMetric createBookMetric(String bookId, int quantity){
        BookMetric bookMetric = new BookMetric();
        bookMetric.setBookId(bookId);
        bookMetric.setQuantity(quantity);
        return bookMetric;
    }
}
