package org.lld.enums;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.lld.enums.Commands.*;

public enum GameState {
    INIT,
    IN_PROGRESS,
    COMPLETED;

    public Set<Commands> relatedCommands;

    static {
        INIT.relatedCommands = Set.of(BOARD_SIZE,
                CREATE_SNAKE,
                CREATE_PLAYER,
                START_GAME,END);
        IN_PROGRESS.relatedCommands = Set.of(ROLL_DICE,END);
        COMPLETED.relatedCommands = Collections.emptySet();
    }
}
