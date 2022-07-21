package com.zacisrael._static;

public class Main {

    //A static method is part of a class definition, but is not part of the objects it creates.
    // Important: A program can execute a static method without first creating an object!
    // All other methods (those that are not static) exist only when they are part of an object.
    // So an object must be created before they can be executed.

    public static int multiplier = 2;

    public static void main(String[] args) {
	// write your code here

//        StaticTest firstInstance = new StaticTest("First Instance");
//        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest secondInstance = new StaticTest("Second Instance");
//        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest thirdInstance = new StaticTest("Third Instance");
//        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());


        int answer = multiply(6);

        System.out.println(answer);

    }

    public static int multiply(int number){
        return number * multiplier;
    }
}
