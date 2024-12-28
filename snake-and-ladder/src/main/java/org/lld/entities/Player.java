package org.lld.entities;

import lombok.Data;
import org.lld.enums.Color;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private String name;
    private Color color;
    private Cell currentCell;
    private List<Move> moveList = new ArrayList<>();
}
