package ru.netology.game;

import java.util.ArrayList;

import static java.util.regex.Pattern.matches;

public class Game {

    private ArrayList<Player> playerList;

    public Game(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String name1, String name2) {
        Player player1 = new Player();
        Player player2 = new Player();
        int result;
        boolean reg1 = false;
        boolean reg2 = false;

        for (Player player : playerList) {
            if (matches(player.getName(), name1)) {
                player1 = player;
                reg1 = true;
                break;
            }
        }

        for (Player player : playerList) {
            if (matches(player.getName(), name2)) {
                player2 = player;
                reg2 = true;
                break;
            }
        }

        if (reg1 == false) {
            throw new NotRegisteredException(
                    "Игрок " + name1 + " не зарегистрирован"
            );
        }

        if (reg2 == false) {
            throw new NotRegisteredException(
                    "Игрок " + name2 + " не зарегистрирован"
            );
        }

        if (player1.getStrength() > player2.getStrength()) {
            result = 1;
        } else if (player1.getStrength() == player2.getStrength()) {
            result = 0;
        } else {
            result = 2;
        }

        return result;
    }
}
