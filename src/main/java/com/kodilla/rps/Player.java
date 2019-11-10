package com.kodilla.rps;

public abstract class Player {

    private final String name;
    private int score = 0;
    private int move;

    public Player(String name) {

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {

        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public int addPoint() {
        return this.score++;
    }

    public int endGame() {
        return InputData.endingGame();
    }

    public abstract int getMove();

    public abstract void theMove();
}
