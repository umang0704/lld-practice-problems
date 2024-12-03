package org.lld.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
public class Book {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String author;
    private int pages;

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }
}
