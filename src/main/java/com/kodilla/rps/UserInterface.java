package com.kodilla.rps;

public class UserInterface {

    public static void getNumbersOfPlayers() {
        System.out.println("How many players? (0-2)");
    }

    public static void getPlayerName() {
        System.out.println("What is the player name?");
    }

    public static void getSecondName() {
        System.out.println("What is the second player name?");
    }

    public static void getAmountOfWinsGames() {
        System.out.println("How many wins are required to end game?");
    }
    public static void mainMenu() {
        System.out.println("Press: ");
        System.out.println("1 for rock");
        System.out.println("2 for paper");
        System.out.println("3 for scissors");
        System.out.println("\"x\" if you want to end game");
        System.out.println("\"n\" if you want to restart the game");
        System.out.println();
        System.out.println("Choose your move: ");
    }

    public static void chosenElementByUser(Player player1, Player player2) {
        chosenItem(player1);
        chosenItem(player2);
    }

    private static void chosenItem(Player player) {
        int playerMove = player.getMove();
        System.out.print(player.getName() + " has chosen ");
        if(playerMove == 0) {
            System.out.println("rock.");
        } else if(playerMove == 1) {
            System.out.println("paper.");
        } else if(playerMove == 2) {
            System.out.println("scissors.");
        }
    }

    public static void winningPlayer(Player player1, Player player2) {
        chosenElementByUser(player1, player2);
        System.out.println("\n" + player1.getName() + " wins.\n");
        System.out.println("Current result: " + player1.getName() + " : " + player2.getName() + " : " + player1.getScore() + " : " + player2.getScore() + ".\n");
    }

    public static void draw(Player player1, Player player2) {
        chosenElementByUser(player1, player2);
        System.out.println("It is a draw.");
        System.out.println("Current result: " + player1.getName() + " : " + player2.getName() + " : " + player1.getScore() + " : " + player2.getScore() + ".\n");
    }

    public static void endOfGame(Player player1, Player player2) {
        System.out.println("\nAt the end the score is " + player1.getName() + ": " + player1.getScore() + ", " + player2.getName() + ":  " + player2.getScore() + ".");
        System.out.println("\"x\" if you want to end game.");
        System.out.println("\"n\" if you want to restart the game.");
    }

    public static void confirmExitOfGame() {
        System.out.println("Do you want to end this game? Press y/n");
    }

    public static void confirmNewGame() {
        System.out.println("Do you want to end this game and start a new one? Press y/n");
    }

    public static void wins(Player player) {
        System.out.println("\n" + player.getName() + " wins the game!\n");
    }

}
