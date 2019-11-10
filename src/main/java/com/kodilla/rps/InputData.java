package com.kodilla.rps;

import java.util.Scanner;

public class InputData {

    private static Scanner scan = new Scanner(System.in);
    private static int result = 0;

    public static int getAmountOfPlayers() {
        boolean isCorrect = false;
        int result = 1;
        do {
            String numberOfPlayers = scan.nextLine();
            if(numberOfPlayers != null && !numberOfPlayers.isEmpty() && (numberOfPlayers.equals("0") || numberOfPlayers.equals("1") || numberOfPlayers.equals("2"))) {
                isCorrect = true;
                result = Integer.parseInt(numberOfPlayers);
            }
        } while(!isCorrect);
        return result;
    }

    public static String getName() {
        boolean isCorrect = false;
        String name;
        do {
            name = scan.nextLine();
            if(name != null && !name.isEmpty()) {
                isCorrect = true;
            }
        } while(!isCorrect);

        return name;
    }

    public static int getAmountOfRequiredWins() {
        int amountOfRequiredWins = scan.nextInt();
        return amountOfRequiredWins;
    }

    public static int getMove() {
        boolean isCorrect = false;
        do {
            String move = scan.nextLine();
            if(move != null && !move.isEmpty() && (move.equals("1") || move.equals("2") || move.equals("3") ||
                    move.equalsIgnoreCase("n") || move.equalsIgnoreCase("x"))) {
                isCorrect = true;
                if(move.equalsIgnoreCase("n")) {
                    result = 4;
                } else if(move.equalsIgnoreCase("x")) {
                    result = 5;
                } else {
                    result = Integer.parseInt(move) - 1;
                }
            }
        } while(!isCorrect);

        return result;
    }

    public static boolean getConfirmation() {
        boolean isCorrect = false;
        boolean answer = false;
        do {
            String confirmation = scan.nextLine();
            if(confirmation.equalsIgnoreCase("y")) {
                answer = true;
                isCorrect = true;
            } else if(confirmation.equalsIgnoreCase("n")) {
                isCorrect = true;
            }
        } while(!isCorrect);

        return answer;
    }

    public static int endingGame() {
        boolean isCorrect = false;
        do {
            String move = scan.nextLine();
            if(move != null && !move.isEmpty() && (move.equalsIgnoreCase("n") || move.equalsIgnoreCase("x"))) {
                isCorrect = true;
                if(move.equalsIgnoreCase("n")) {
                    result = 4;
                } else if(move.equalsIgnoreCase("x")) {
                    result = 5;
                }
            }
        } while(!isCorrect);

        return result;
    }
}

