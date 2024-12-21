package org.lld.service;

import lombok.extern.slf4j.Slf4j;
import org.lld.entities.Book;
import org.lld.entities.User;
import org.lld.exceptions.LibraryException;
import org.lld.repo.LibraryRepo;

import java.text.MessageFormat;
import java.util.Objects;

@Slf4j
public class LibraryService {
    private static LibraryService libraryService;

    private LibraryRepo libraryRepo;
    private UserService userService;
    private BookService bookService;

    private LibraryService() {
    }

    public static synchronized LibraryService getInstance() {
        if (Objects.isNull(libraryService)) {
            libraryService = new LibraryService();
        }
        return libraryService;
    }

    /**
     * Gets Library
     *
     * @return
     */
    public void initiateLibrary() {
        this.libraryRepo = new LibraryRepo();
        this.userService = new UserService();
        this.bookService = new BookService();
    }

    /**
     * Create User
     * @param name
     * @param contact
     * @return userId
     */
    public String createUser(String name, String contact) {
        try {
            User user = userService.createUser(libraryRepo, name, contact);
            System.out.println(MessageFormat.format("USER_CREATION_SUCCESS:{0}", user.getId()));
            return user.getId();
        } catch (LibraryException e) {
            String error = MessageFormat.format("ERROR_CREATING_USER:{0}", e.getMessage());
            System.out.println(error);
            return null;
        }
    }

    /**
     * Create Book
     * @param title
     * @param author
     * @param count
     * @return bookId
     */
    public String createBook(String title, String author, int count){
        try {
            Book book = bookService.createBook(libraryRepo, title, author, count);
            System.out.println(MessageFormat.format("BOOK_ADDED_SUCCESS:{0}",book.getId()));
            return book.getId();
        }catch (LibraryException e){
            String error = MessageFormat.format("ERROR_CREATING_BOOK:{0}",e.getMessage());
            System.out.println(error);
            return null;
        }
    }

    /**
     * Borrow Book
     * 1. Validate User
     * 2. Validate Book
     * 3. Borrow Book
     * @param user1Id
     * @param book1Id
     */
    public void borrowBook(String user1Id, String book1Id) {

    }
}
