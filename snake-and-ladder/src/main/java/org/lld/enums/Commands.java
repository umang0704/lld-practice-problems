package org.lld.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Commands {
    BOARD_SIZE(1),
    CREATE_SNAKE(2),
    CREATE_PLAYER(3),
    START_GAME(4),
    ROLL_DICE(5),
    END(6);

    private Integer commandIndex;

    public static final HashMap<Integer, Commands> commandMap;

    static {
        commandMap = new HashMap<>(
                Stream.of(Commands.values())
                        .collect(
                                Collectors.toMap(
                                        command -> command.commandIndex,
                                        commands -> commands
                                )
                        )
        );
    }

    Commands(Integer commandIndex) {
        this.commandIndex = commandIndex;
    }
}
