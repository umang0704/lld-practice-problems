package org.lld.validators;

import org.lld.entities.Book;
import org.lld.repo.Library;

import java.util.Map;

public class BookValidator {
    /**
     * Check if book exists
     * @param library
     * @param name
     * @param author
     * @return
     */
    public boolean checkIfBookExists(Library library, String name, String author) {
        Map<String, Book> books = library.getBooks();
        return books.entrySet()
                .stream()
                .anyMatch(entry -> bookWithNameAndAuthor(entry.getValue(), name, author));
    }

    /**
     *  Checks is books properties valid
     * @param name
     * @param author
     * @param pages
     * @return
     */
    public boolean isBookPropertiesValid(String name, String author, int pages){
        return !name.isBlank()
                && !author.isBlank()
                && pages != 0;
    }

    /**
     * Match book name and author
     * @param existing
     * @param name
     * @param author
     * @return
     */
    private boolean bookWithNameAndAuthor(Book existing, String name, String author) {
        return existing.getName().equalsIgnoreCase(name) && existing.getAuthor().equalsIgnoreCase(author);
    }
}
