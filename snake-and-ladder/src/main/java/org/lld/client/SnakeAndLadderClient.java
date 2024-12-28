package org.lld.client;


import lombok.extern.slf4j.Slf4j;
import org.lld.entities.Game;
import org.lld.enums.Commands;
import org.lld.enums.GameState;
import org.lld.services.CommandProcessor;
import org.lld.utils.scanner.ScannerUtils;

import java.text.MessageFormat;

@Slf4j
public class SnakeAndLadderClient {
    private static final ScannerUtils scanner = ScannerUtils.getScannerUtils();
    private final CommandProcessor commandProcessor;

    public SnakeAndLadderClient() {
        this.commandProcessor = new CommandProcessor();
    }

    /**
     * get player details
     * initialize game
     * start game
     */
    public void startGame() {
        Game game = new Game();
        while (true) {
            Integer commandIndex = scanner.getInt(GET_COMMAND_LOG);
            Commands command = Commands.commandMap.get(commandIndex);
            if (null == command || !game.getState().relatedCommands.contains(command)) {
                log.info(INVALID_COMMAND);
                continue;
            }
            switch (command) {
                case BOARD_SIZE -> commandProcessor.enterBoardSize(game);
                case CREATE_SNAKE -> commandProcessor.getSnakeDetails(game);
                case CREATE_PLAYER -> commandProcessor.processGetPlayers(game);
                case START_GAME -> commandProcessor.processStartGame(game);
                case ROLL_DICE -> commandProcessor.processRollDice(game);
                case END -> commandProcessor.processEndGame(game);
            }
            if (GameState.COMPLETED.equals(game.getState())) {
                log.info(MessageFormat.format(WINNER, game.getWinner()));
                break;
            }
        }
    }


    private static final String GET_COMMAND_LOG = """
            Please select on of below command:
            1. BOARD_SIZE\
            2. CREATE_SNAKE\
            3. CREATE_PLAYER\
            4. START_GAME\
            5. ROLL_DICE\
            6. END
            """;
    private static final String WINNER = "** Winner is {0} **";
    private static final String INVALID_COMMAND = "Invalid command";

}
