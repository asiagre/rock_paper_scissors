package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        UserInterface.getNumbersOfPlayers();
        int numbersOfPlayers = InputData.getAmountOfPlayers();
        UserInterface.getAmountOfWinsGames();
        int amountOfRequiredWins = InputData.getAmountOfRequiredWins();

        if(numbersOfPlayers == 0) {
            Player computer1 = new Computer("Computer1");
            Player computer2 = new Computer("Computer2");
            gameProcessor(computer1, computer2, amountOfRequiredWins);
        } else if(numbersOfPlayers == 1) {
            UserInterface.getPlayerName();
            String name = InputData.getName();
            Player user = new User(name);
            Player computer = new Computer("Computer");
            gameProcessor(user, computer, amountOfRequiredWins);
        } else {
            UserInterface.getPlayerName();
            String name = InputData.getName();
            UserInterface.getSecondName();
            String name2 = InputData.getName();
            Player user1 = new User(name);
            Player user2 = new User(name2);
            gameProcessor(user1, user2, amountOfRequiredWins);
        }

    }

    public static void gameProcessor(Player player1, Player player2, int amountOfRequiredWins) {
        GameProcess gameProcess = new GameProcess(player1, player2, amountOfRequiredWins);
        gameProcess.game();
    }
}
