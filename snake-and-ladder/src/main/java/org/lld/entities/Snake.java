package org.lld.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Snake {
    private Cell startCell;
    private Cell endCell;
}
