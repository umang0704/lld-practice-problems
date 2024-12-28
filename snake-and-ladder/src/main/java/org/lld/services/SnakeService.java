package org.lld.services;

import lombok.extern.slf4j.Slf4j;
import org.lld.entities.Board;
import org.lld.entities.Cell;
import org.lld.entities.Game;
import org.lld.entities.Snake;
import org.lld.utils.scanner.ScannerUtils;

import javax.swing.text.html.Option;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class SnakeService {
    private static final ScannerUtils scanner = ScannerUtils.getScannerUtils();

    public Game getSnakeDetails(Game game) {
        Integer snakeCount = scanner.getInt(SNAKE_COUNT);

        if (null == snakeCount || snakeCount < 1 || snakeCount > 10) {
            log.info("Snake count should be between 1 and 10");
            return null;
        }

        Board board = game.getBoard();

        for (int snake = 1; snake <= snakeCount; snake++) {
            Snake newSnake = createSnake(board);
            if (null == newSnake) {
                log.info("Could not create snake, due to invalid input");
                snake--;
            }

            board.getSnakeList().add(newSnake);
        }

        game.setBoard(board);

        return game;
    }

    public Snake createSnake(Board board) {

        Integer snakeStartCell = scanner.getInt(MessageFormat.format(SNAKE_START_CELL_INDEX, board.getBoardSize()));
        Integer snakeEndCell = scanner.getInt(MessageFormat.format(SNAKE_END_CELL_INDEX, board.getBoardSize()));

        if (snakeStartCell == null || snakeStartCell < 1 || snakeStartCell > board.getBoardSize()) {
            return null;
        }

        if (snakeEndCell == null || snakeEndCell < 1 || snakeEndCell > board.getBoardSize()) {
            return null;
        }

        boolean isDuplicateSnake = Optional.of(board)
                .map(Board::getSnakeList)
                .orElse(new ArrayList<>())
                .stream()
                .filter(
                        existingSnake ->
                                existingSnake.getStartCell().getIndex() == snakeStartCell
                                        && existingSnake.getEndCell().getIndex() == snakeEndCell)
                .findFirst()
                .isPresent();
        return isDuplicateSnake ? null :new Snake(new Cell(snakeStartCell), new Cell(snakeEndCell));
    }

    private static final String SNAKE_COUNT = "snake count";
    private static final String SNAKE_START_CELL_INDEX = "snake start cell index between 1 to {0}";
    private static final String SNAKE_END_CELL_INDEX = "snake end cell index between 1 to {0}";

}
