package org.lld.service;

import org.lld.entities.Book;
import org.lld.repo.LibraryRepo;
import org.lld.validators.BookValidator;

public class BookService {

    private BookValidator bookValidator;

    public BookService() {
        this.bookValidator = new BookValidator();
    }

    /**
     * Create Book
     * @param libraryRepo
     * @param title
     * @param author
     * @param count
     * @return Book
     */
    public Book createBook(
            LibraryRepo libraryRepo,
            String title,
            String author,
            int count){
        bookValidator.isBookDetailsValid(title,author,count);
        bookValidator.idempotencyCheck(libraryRepo,title);
        Book book = new Book(title,author,count);
        libraryRepo.getBooks().put(book.getId(),book);
        libraryRepo.getTitleToBookMapping().put(book.getTitle(),book.getId());
        return book;
    }
}
