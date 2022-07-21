package com.zacisrael;

public class Main {

    public static void main(String[] args) {
        boolean game0ver = true;
        int score = 4000;
        int levelCompleted = 5;
        int bonus = 100;


//        if(score < 5000 && score > 1000){ // I can remove the brackets after the "if" test if I am only testing 1 statement
//            System.out.println("Your score was less than 5000 but greater than 1000 "); // If the "if" test is true, then "else if" & "else" test will be ignored
//        } else if(score < 1000){
//            System.out.println("Your score was less than 1000");

//        }else{
//            System.out.println("Got here"); }
// go to the else statement if the "if" statement is not true
//
        if (game0ver == true) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
        // You cannot access a variable that was created inside the code block outside of the code block
        // for example , we cannot us "finalScore" again because it was created inside the "if" method "game0ver"




        // Challenge :
        // Print out a second score on the screen with the following
        // 1. a score set to 10000
        // levelCompleted set to 8
        // bonus set to 200
        // But make sure the first printout above still displays as well

        boolean myGame0ver = true;
        int myscore = 10000;
        int mylevelCompleted = 8;
        int mybonus = 200;

       if (myGame0ver){
           int finalScore = myscore + (mylevelCompleted + mybonus);
           System.out.println("Your final score was " + finalScore);
        }
    }
}
