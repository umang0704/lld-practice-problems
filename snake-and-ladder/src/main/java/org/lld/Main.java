package org.lld;

import lombok.extern.slf4j.Slf4j;
import org.lld.client.SnakeAndLadderClient;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info(INIT_GAME_LOG);
        SnakeAndLadderClient gameClient = new SnakeAndLadderClient();
        gameClient.startGame();
        log.info(END_GAME_LOG);
    }


    //log constants
    private static final String INIT_GAME_LOG = "Starting Snake and Ladder Game...";
    private static final String END_GAME_LOG = "Starting Snake and Ladder Completed...";
}