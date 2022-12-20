package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    ArrayList<Player> playerList = new ArrayList<>();
    Game game = new Game(playerList);

    Player player1 = new Player(1, "Egor", 15);
    Player player2 = new Player(2, "Igor", 10);
    Player player3 = new Player(3, "Oleg", 15);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void roundFirstPlayerWin() {
        int expected = 1;
        int actual = game.round("Egor", "Igor");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundSecondPlayerWin() {
        int expected = 2;
        int actual = game.round("Igor", "Egor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundDraw() {
        int expected = 0;
        int actual = game.round("Egor", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void round1stPlayerNoReg() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Alex", "Igor");
        });
    }

    @Test
    public void round2stPlayerNoReg() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Egor", "Alex");
        });
    }


}
