package com.kodilla.rps;

public class User extends Player {
    private int move;

    public User(String name) {
        super(name);
    }

    public void theMove() {
        move = InputData.getMove();
    }

    public int getMove() {
        return move;
    }
}
