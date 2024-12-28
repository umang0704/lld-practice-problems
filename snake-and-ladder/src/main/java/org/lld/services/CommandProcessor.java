package org.lld.services;

import org.lld.entities.Game;

public class CommandProcessor {
    private final GameService gameService;

    public CommandProcessor() {
        this.gameService = new GameService();
    }

    public void enterBoardSize(Game game) {
        game = gameService.getProcessBoardSize(game);
    }

    public void getSnakeDetails(Game game) {
        game = gameService.getSnakeDetails(game);
    }

    public void processGetPlayers(Game game) {
        game = gameService.getPlayerDetails(game);
    }

    public void processStartGame(Game game) {
        game = gameService.startGame(game);
    }

    public void processRollDice(Game game) {

    }

    public void processEndGame(Game game) {

    }
}
