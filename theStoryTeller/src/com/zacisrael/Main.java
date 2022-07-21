package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        System.out.println(storyteller("Jayme","Danielle", "cars" , 2, "Keith", "Jeff", "Jessy"));
        // ^ is saying print out the method "storyteller" with the parameters above


    }
    public static String storyteller(String girl1, String girl2, String jealous, int envy, String father, String dog, String grandmother ){


        String magic1 = "";
        magic1 = (girl1.charAt(girl1.length()-1) + "").toUpperCase() + "aa" + (girl1.charAt(0) + "").toLowerCase();
        // "(girl1.charAt(girl1.length()-1)" is the last letter in "girl1"'s name. I had to subtract 1 from the length
        // because when we count letters in a String, we start at 0. The same applies for the rest of the magical words
        String magic2 = "";
        magic2 = girl2.charAt(girl2.length()-1) + "ee" + (girl2.charAt(0) + "").toLowerCase();
        //"toLowerCase()" takes a letter and makes it lower case, toUpperCase() takes a letter and makes it upper case
        String magic3 = "";
        magic3 = jealous.charAt(jealous.length()-1) + "ii" + jealous.charAt(0);

        String magic11 = "";
        magic11 = (girl1.charAt(girl1.length()-1) + "").toUpperCase() + "AA" + girl1.charAt(0);
        String magic22 = "";
        magic22 = (girl2.charAt(girl2.length()-1) + "").toUpperCase() + "EE" + (girl2.charAt(0) + "").toUpperCase();
        String magic33 = "";
        magic33 = (jealous.charAt(jealous.length()-1)+ "").toUpperCase() + "II" + (jealous.charAt(0) + "").toUpperCase();


        // We must return something ina string method
      return girl1 + " was a nice girl from Maryland. " + girl2 + " was a disrespectful girl from Virginia. " +
              girl1 + " had " + envy + " " + jealous + ", whereas " + girl2 + " only had " + envy/2 + ". Because of" +
              //I put "envy/2" because girl 2 has half the items that girl1 has
              "jealousy, " + girl2 + " cast a spell on " + girl1 + " saying these strange words.: " + magic1 + "  " +
              magic2 + " " + magic3 + "! " + magic11 + " " + magic22 + " " + magic33 + "! All of a sudden, " + girl1
              + "'s " + envy + " " + jealous + " turned to dust. " + girl2 + "'s father " + father + " saw what " + girl2
              + " had done and made her reverse the spell. " + girl1 + "'s pet dog " + dog + " saw what " + girl2 + " had done"
              + " so he bit her. " + girl1 + "'s grandmother " + grandmother + " heard all the commotion so she ran out the house" +
              " and told them to shut up and be friends again. " + girl2 + " apologized to " + girl1 + " and they became friends again";
}




}
