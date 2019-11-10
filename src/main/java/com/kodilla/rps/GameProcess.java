package com.kodilla.rps;

public class GameProcess {

    private static final int[][] RESULTTABLE = {
            {0, 1, -1},
            {-1, 0, 1},
            {1, -1, 0}
    };
    private final Player player1;
    private final Player player2;
    private int amountOfRequiredWins;
    private boolean end = false;
    private boolean endOfGame = false;


    public GameProcess(Player player1, Player player2, int amountOfRequiredWins) {
        this.player1 = player1;
        this.player2 = player2;
        this.amountOfRequiredWins = amountOfRequiredWins;
    }

    public void game() {
        while(!endOfGame) {
            while (!end) {
                gameTour();
                if (player1.getScore() >= amountOfRequiredWins || player2.getScore() >= amountOfRequiredWins) {
                    end = true;
                }
            }
            if (player1.getScore() > player2.getScore()) {
                UserInterface.wins(player1);
            } else {
                UserInterface.wins(player2);
            }
            endingGame();
        }
    }

    public void gameTour() {
        int player1Move, player2Move, result;
        UserInterface.mainMenu();
        player1.theMove();
        UserInterface.mainMenu();
        player2.theMove();

        player1Move = player1.getMove();
        if (player1Move == 4) {
            newGameWhilePlaying();
        } else if (player1Move == 5) {
            quitGameWhilePlaying();
        }

        player2Move = player2.getMove();
        if (player2Move == 4) {
            newGameWhilePlaying();
        } else if (player2Move == 5) {
            quitGameWhilePlaying();
        }

        if (player1Move < 4 && player2Move < 4) {
            result = getResult(player1Move, player2Move);
            addPlayersPoints(result);
        }
    }

    private void newGameWhilePlaying() {
        UserInterface.confirmNewGame();
        boolean confirmation = InputData.getConfirmation();
        if (confirmation) {
            player1.resetScore();
            player2.resetScore();
            game();
        } else {
            game();
        }
    }

    private void quitGameWhilePlaying() {
        UserInterface.confirmExitOfGame();
        boolean confirmation = InputData.getConfirmation();
        if (confirmation) {
            end = true;
            endOfGame = true;
            game();
        } else {
            game();
        }
    }

    private int getResult(int player1Move, int player2Move) {

        int result = RESULTTABLE[player2Move][player1Move];

        return result;
    }

    private void addPlayersPoints(int result) {
        if(result == -1) {
            player2.addPoint();
            UserInterface.winningPlayer(player2, player1);
        } else if(result == 0) {
            UserInterface.draw(player1, player2);
        } else if(result == 1) {
            player1.addPoint();
            UserInterface.winningPlayer(player1, player2);
        }
    }

    public void endingGame() {
        UserInterface.endOfGame(player1, player2);
        int move = player1.endGame();
        if (move == 4) {
            UserInterface.confirmNewGame();
            boolean confirmation = InputData.getConfirmation();
            if (confirmation) {
                player1.resetScore();
                player2.resetScore();
                end = false;
                game();
            } else {
                endOfGame = true;
            }
        }
        if (move == 5) {
            UserInterface.confirmExitOfGame();
            boolean confirmation = InputData.getConfirmation();
            if (confirmation) {
                endOfGame = true;
            } else {
                endingGame();
            }
        }
    }
}
