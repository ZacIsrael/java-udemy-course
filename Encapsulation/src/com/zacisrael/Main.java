package com.zacisrael;

public class Main {

    public static void main(String[] args) {
//	// write your code here
//        Player player = new Player();
//        player.name = "Zac";
//        player.health = 20;
//        player.weapon = "sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());
//
//        damage = 11;
//        player.health = 100;
//        player.loseHealth(damage);
//        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Zac", 200, "sword");
        System.out.println("Initial health is " + player.getHealth());
        
    }
}
