package org.lld.services;

import lombok.extern.slf4j.Slf4j;
import org.lld.entities.*;
import org.lld.enums.GameState;
import org.lld.utils.scanner.ScannerUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Slf4j
public class GameService {
    private static final ScannerUtils scanner = ScannerUtils.getScannerUtils();
    private final SnakeService snakeService;
    private final PlayerService playerService;

    public GameService() {
        this.snakeService = new SnakeService();
        this.playerService = new PlayerService();
    }

    public Game getProcessBoardSize(Game game) {
        Integer boardSize = scanner.getInt("Board Size");

        if (null == boardSize || boardSize < 1 || boardSize > 100) {
            log.info("Invalid Board Size, should between 0 and 100");
            return game;
        }
        Board board = new Board();
        board.setBoardSize(boardSize);

        game.setBoard(board);

        return game;
    }

    public Game getSnakeDetails(Game game) {
        Board board = game.getBoard();
        List<Snake> snakeList = board.getSnakeList();
        if (null != snakeList && snakeList.size() != 0 && !scanner.continueWish()) {
            return game;
        }
        return snakeService.getSnakeDetails(game);
    }

    public Game getPlayerDetails(Game game) {
        List<Player> players = game.getPlayers();
        if (null != players && players.size() != 0 && !scanner.continueWish()) {
            return game;
        }
        return playerService.getPlayerDetails(game);
    }

    public Game startGame(Game game) {
        GameState state = game.getState();
        if (state == GameState.IN_PROGRESS) {
            log.info("Game already started.");
            return game;
        }
        if (!isBoardReady.test(game.getBoard())) {
            log.info("Please entry board details.");
            return game;
        }

        if(game.getPlayers().size()!=0){
            log.info("Please entry player details.");
            return game;
        }

        game.setDice(new Dice(6));
        game.setCurrentPlayer(game.getPlayers().get(0));
        game.setState(GameState.IN_PROGRESS);

        return game;
    }

    private final Predicate<Board> isBoardReady =
            board -> Optional.ofNullable(board)
                .filter(boardDetails -> null != boardDetails.getBoardSize())
                .filter(boardDetails -> boardDetails.getSnakeList().size() != 0)
                .filter(boardDetails -> boardDetails.getLadders().size() != 0)
                .isPresent();

}
