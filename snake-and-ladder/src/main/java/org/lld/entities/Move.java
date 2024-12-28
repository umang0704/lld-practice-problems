package org.lld.entities;

import lombok.Data;

@Data
public class Move {
    private Cell currentCell;
    private Cell endCell;
    private Integer diceOutcome;
    private Boolean ladderClimb;
    private Boolean snakeBite;
}
