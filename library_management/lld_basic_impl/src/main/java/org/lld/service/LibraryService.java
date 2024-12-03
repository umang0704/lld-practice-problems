package org.lld.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lld.BookMapper;
import org.lld.dao.LibraryDao;
import org.lld.entities.Book;
import org.lld.entities.BookMetric;
import org.lld.repo.Library;
import org.lld.validators.BookValidator;

@Slf4j
@NoArgsConstructor
public class LibraryService {
    private BookValidator bookValidator;
    private BookMapper bookMapper;
    private LibraryDao libraryDao;

    /**
     * Add Book with validation,
     * @param library
     * @param name
     * @param author
     * @param pages
     * @param quantity
     * @return bookId
     */
    public String addBook(Library library, String name, String author, int pages,int quantity) {

        boolean bookPropertiesValid = bookValidator.isBookPropertiesValid(name, author, pages);
        if (!bookPropertiesValid) {
            log.error("Book property not valid");
            return null;
        }

        boolean bookExists = bookValidator.checkIfBookExists(library, name, author);
        if (bookExists) {
            log.error("Book Already Exists.");
            return null;
        }

        Book book = bookMapper.createBook(name, author, pages);
        String bookId = libraryDao.addBook(library, book);

        BookMetric bookMetric = bookMapper.createBookMetric(bookId, quantity);
        libraryDao.addBookMetric(library,bookMetric);

        return bookId;
    }

    public boolean updateBookDetails(Library library, String name, String author, int page, int quantity){
        // validate properties
        boolean bookPropertiesValid = bookValidator.isBookPropertiesValid(name, author, page);
        if(!bookPropertiesValid){
            log.info("Invalid Book Properties");
            return false;
        }
        // check if book exists
//        libraryDao.addBookMetric()
        // check update conditions
        // update details
        return false;
    }
}
