package com.zacisrael;

public class Main {

    public static void main(String[] args) { // main method
        boolean game0ver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(game0ver, score, levelCompleted, bonus); // You can assign a variable to a method result
        System.out.println("Your final score was " + highScore);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        highScore = calculateScore(game0ver, score, levelCompleted, bonus); // You can assign a variable to a method result
        System.out.println("Your final score was " + highScore);

        // Create a method called displayHighScorePosition
        // It should receive a player's name as a parameter, and  2nd parameter as a position in the High score table
        // You should display the players name along with a message like " managed to get into position"
        // and the position they got and a further message " on the high score table."

        int highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("James", highScorePosition);


        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Bob", highScorePosition);

        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Larry", highScorePosition);

        highScorePosition = calculateHighScorePosition(30);
        displayHighScorePosition("Marc", highScorePosition);


    }

    public static int calculateScore(boolean game0ver, int score, int levelCompleted, int bonus) {

        if (game0ver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000; // Add 2000 to the finalScore
            // If an expression is defined with in a method, it ends once the method is over.
            // You can give another expression the same name, but give it a different function as long as it is not in the same method.
            return finalScore;

        }

        return -1; // -1 means invalid value or value not found

    }

    public static void displayHighScorePosition(String name, int highScorePosition) {
        System.out.println(name + " managed to get into position  " + highScorePosition + " on the high score table");

    }

    public static int calculateHighScorePosition(int playerScore) {

//        if (playerScore >= 1000) {
//            return 1;
//        } else if (playerScore >= 500) {
//            return 2;
//        } else if (playerScore >= 100) {
//            return 3;
//        }
//
//        return 4;
//
//
        int position = 4; // assuming position 4 will be returned

        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }

        return position; // We have already calculated the positions for each value,
        //  we do not need all of those return statements like we had before
    }


}

// void means "don't return anything"
