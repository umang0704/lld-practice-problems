package org.lld.entities;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class User {
    private String id = UUID.randomUUID().toString();
    private String name;
    private List<String> bookList;
}