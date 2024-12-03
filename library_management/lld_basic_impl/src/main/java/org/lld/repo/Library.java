package org.lld.repo;

import lombok.Data;
import org.lld.entities.Book;
import org.lld.entities.BookMetric;
import org.lld.entities.User;

import java.util.HashMap;
import java.util.Map;

@Data
public class Library {
    private Map<String, BookMetric> bookMetric = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Map<String, Book> books = new HashMap<>();
}
