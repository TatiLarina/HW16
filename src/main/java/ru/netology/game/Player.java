package ru.netology.game;

public class Player {
    private static int id;
    private String name;
    private int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public Player() {
    }


    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

}
