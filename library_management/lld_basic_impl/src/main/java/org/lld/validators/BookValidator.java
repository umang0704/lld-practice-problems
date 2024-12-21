package org.lld.validators;

import org.lld.exceptions.LibraryException;
import org.lld.repo.LibraryRepo;

import java.text.MessageFormat;

import static java.text.MessageFormat.format;

public class BookValidator {

    /**
     * Validate new book details
     *
     * @param title
     * @param author
     * @param count
     * @return true/false
     */
    public boolean isBookDetailsValid(String title, String author, int count) {
        if (count < 0) {
            throw new LibraryException(format("INVALID_BOOK_COUNT:{0}", count));
        }

        if (title.isBlank()) {
            throw new LibraryException(format("INVALID_BOOK_TITLE:{0}", count));
        }

        if (author.isBlank()) {
            throw new LibraryException(format("INVALID_BOOK_TITLE:{0}", count));
        }

        return true;
    }

    public void idempotencyCheck(LibraryRepo libraryRepo, String title) {
        boolean bookWithTitleExists = libraryRepo
                .getTitleToBookMapping()
                .containsKey(title);
        if (bookWithTitleExists) {
            String bookId = libraryRepo
                    .getTitleToBookMapping()
                    .get(title);
            throw new LibraryException(
                    format("BOOK_TITLE_EXISTS:BOOK_ID:{0}", bookId));
        }
    }
}
