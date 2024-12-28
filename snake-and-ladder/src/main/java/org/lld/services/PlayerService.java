package org.lld.services;

import lombok.extern.slf4j.Slf4j;
import org.lld.entities.Cell;
import org.lld.entities.Game;
import org.lld.entities.Player;
import org.lld.enums.Color;
import org.lld.utils.scanner.ScannerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.text.MessageFormat.format;

@Slf4j
public class PlayerService {
    private static final ScannerUtils scanner = ScannerUtils.getScannerUtils();

    public Game getPlayerDetails(Game game) {
        Integer playerCount = scanner.getInt(PLAYER_COUNT);
        ArrayList<Player> players = getPlayerDetailsFn.apply(playerCount);
        game.setPlayers(players);
        return game;
    }

    private Player createPlayer() {
        Cell cell = new Cell(0);

        String name = scanner.getString(PLAYER_NAME);
        String color = scanner.getString(format(COLOR_FOR_PLAYER, name, Arrays.toString(Color.values())));

        Player player = new Player();
        player.setName(name);
        player.setColor(Color.valueOf(color));
        player.setCurrentCell(cell);

        return player;
    }

    private Function<Integer, ArrayList<Player>> getPlayerDetailsFn =
            playerCount -> IntStream.range(0, playerCount)
                    .mapToObj(player -> createPlayer())
                    .collect(
                            Collectors.toCollection(ArrayList::new));

    private static final String PLAYER_COUNT = "Player count";
    private static final String PLAYER_NAME = "Player name";
    private static final String COLOR_FOR_PLAYER = "color for {0} from {1}";
}
