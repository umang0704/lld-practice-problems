package org.lld.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBookDto {
    private String name;
    private String author;
    private int pages;
    private int quantity;
}
