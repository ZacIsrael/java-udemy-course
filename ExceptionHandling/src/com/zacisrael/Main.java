package com.zacisrael;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //int x = 3/ 0;
        // as soon as we gte an error, the program crashes and the rest of the code after it will not run
        /*System.out.println("I'm happily continuing execution");

        int x;
        try {
            System.out.println("Befor error");
            x = 3 / 0;
            System.out.println("After error");
        } catch(Exception e){
            // Type a code here that will run if the code in the try block causes an error
            System.out.println("An exception occured: " + e.getMessage());
        }

        System.out.println("Reseuming program execution");

        try{
            x = 3/0;
        } catch (ArithmeticException e){ // will catch any type of Arithmetic error
            System.out.println("Arithmetic exception: " + e.getMessage());
        }

        try{
            //x = 3 / 0;
            int[] y = new int[4];
            //y[6] = 10;
            Scanner input = new Scanner(new File("blah.txt"));
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exceptio: " + e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of bonds exception: " + e.getMessage());
        }
        catch (FileNotFoundException e){
            System.out.println("File not found exception: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Any other exception: " + e.getMessage());
        } */
        try{
            System.out.println(divide2(4,2));
            System.out.println(divide2(6,0));
            System.out.println("Will this line be executed");
            angryMethod();
        }
        catch (ArithmeticException e){
            System.out.println();
        }

        try{
            int n1 = convertStringToInt("3");
            int n2 = convertStringToInt("three");
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }



    }
    public static int divide(int x, int y){
        int z = x/y;
        return z;
    }
    public static int divide2(int x, int y){
        if ( y == 0) throw new ArithmeticException("Divide by zero!");
        int z = x/y;
        return z;
    }
    public static void angryMethod(){
        throw new RuntimeException("Throwing a tantrum!");
    }
    public static int convertStringToInt(String str){
        int result;
        try{
            result = Integer.valueOf(str);
        } catch(NumberFormatException e){
            throw new NumberFormatException("We can throw a customized message back...");
        }
        return result;
    }
    public static void fileMatchAndWrite(String fileInputName, String fileOutputName){
        File file = null;
        Scanner scanner = null;
        FileWriter fileWriter = null;
        BufferedWriter out = null;

        String text = "";

        try{
            file = new File(fileInputName);
            scanner = new Scanner(file);
            while(scanner.hasNext()){

            }
        }
    }
}
