package org.lld.repo;

import lombok.Data;
import lombok.Getter;
import org.lld.entities.Book;
import org.lld.entities.User;

import java.util.HashMap;
import java.util.Map;

public class LibraryRepo {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Book> books = new HashMap<>();
    private Map<String,String> contactToUserMapping = new HashMap<>();

    private Map<String,String> titleToBookMapping = new HashMap<>();

    public LibraryRepo() {
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, String> getContactToUserMapping() {
        return contactToUserMapping;
    }

    public Map<String, String> getTitleToBookMapping() {
        return titleToBookMapping;
    }
}
