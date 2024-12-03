package org.lld.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class BookMetric {
    private String id = UUID.randomUUID().toString();
    private String bookId;
    private int quantity;
    private int borrowedQuantity = 0;
}
