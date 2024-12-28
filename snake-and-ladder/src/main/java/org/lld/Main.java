package org.lld;

import org.lld.client.SnakeAndLadderClient;
import org.lld.utils.logger.Logger;

public class Main {
    private static Logger logger = Logger.getLogger();

    public static void main(String[] args) {
        logger.info(INIT_GAME_LOG);
        SnakeAndLadderClient gameClient = new SnakeAndLadderClient();
        gameClient.startGame();
        logger.info(END_GAME_LOG);
    }


    //log constants
    private static final String INIT_GAME_LOG = "Starting Snake and Ladder Game...";
    private static final String END_GAME_LOG = "Starting Snake and Ladder Completed...";
}