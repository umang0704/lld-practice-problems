package org.lld.client;


import org.lld.utils.logger.Logger;
import org.lld.utils.scanner.ScannerUtils;

public class SnakeAndLadderClient {
    private static final Logger log = Logger.getLogger();
    private static final ScannerUtils scanner = ScannerUtils.getScannerUtils();
    public void startGame(){
        Integer boardSize = scanner.getInt(BOARD_SIZE);
        Integer playerCount = scanner.getInt(PLAYER_COUNT);
        // get player details
        // initialize game
        // start game

    }

    //log constants
    public static final String PLAYER_COUNT = "Player count";
    public static final String BOARD_SIZE = "Board Size";
}
