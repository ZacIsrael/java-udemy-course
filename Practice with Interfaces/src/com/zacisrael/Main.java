package com.zacisrael;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dog babe = new Dog("Babe", Color.WHITE, "Havanese", 0);
        Dog tootsie = new Dog("Tootsie", Color.WHITE, "Havanese", 0);
        Dog keeko = new Dog("Keeko",Color.GRAY, "Havanes", 1);
        Dog max = new Dog("Max",Color.BLACK, "Havanes", 1);
        babe.canReproduceWith(keeko);
        babe.canReproduceWith(tootsie);
        max.canReproduceWith(tootsie);
        max.canReproduceWith(keeko);
        keeko.canReproduceWith(keeko);
        tootsie.canReproduceWith(tootsie);
        tootsie.communicate();
        babe.communicate();
        keeko.travel();
        System.out.println("\n");

        Human zac = new Human("Zac", Color.BLACK, "Carribean-American", 1);
        Human ziara = new Human("Ziara", Color.BLACK, "African-American", 0);
        Human brittany = new Human("Brittany", Color.BLACK, "Carribean-American", 0);
        Human keith = new Human("Keith", Color.BLACK, "Carribean-American", 1);

        zac.canReproduceWith(ziara);
        zac.canReproduceWith(brittany);
        ziara.canReproduceWith(brittany);
        brittany.canReproduceWith(keith);
        keith.canReproduceWith(keith);
        zac.travel();
        ziara.communicate();


    }
}
