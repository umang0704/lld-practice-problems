package org.lld.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lld.enums.GameState;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private Player currentPlayer;
    private Player winner;
    private Dice dice;
    private GameState state = GameState.INIT;
}
