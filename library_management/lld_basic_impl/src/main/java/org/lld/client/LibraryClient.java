package org.lld.client;

import lombok.extern.slf4j.Slf4j;
import org.lld.repo.LibraryRepo;
import org.lld.service.LibraryService;

@Slf4j
public class LibraryClient {

    /**
     * 1. Create Book
     * 2. Update Book
     * 3. Get All Books
     * 4. Delete Book
     * 5. Search Book by title
     * 6. Search Book by author
     *
     * 1. Crete User
     * 2. Update User
     * 3. Borrow Book
     * 4. Return Book
     * 5. Get All Books Borrowed By User
     *
     */
    public void startLibrary(){
        System.out.println("Starting Library...");
        LibraryService library = LibraryService.getInstance();
        library.initiateLibrary();

        String user1Id = library.createUser("Umang", "9999999999");
        String user2Id = library.createUser("Khushi", "9999999991");

        String book1Id = library.createBook("C++", "Some Legend", 1);

        library.borrowBook(user1Id,book1Id);


    }

}
