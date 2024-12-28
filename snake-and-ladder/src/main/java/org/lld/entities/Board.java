package org.lld.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    private Integer boardSize;
    private List<Snake> snakeList = new ArrayList<>();
    private List<Ladder> ladders = new ArrayList<>();
}
