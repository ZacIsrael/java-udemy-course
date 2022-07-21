package com.zacisrael;

import java.io.File;
import java.io.FileNotFoundException;
import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here

        /*String text = "To be, or not to be. That is the question.";
        // Replace with: "To beee, or not to beee. That is theee question."
        System.out.println(text.replaceAll("e","eee"));

        System.out.println(text.replaceAll("e\\W","eee"));

        System.out.println(text.replaceAll("(e)(\\W)","$1$1$1$2"));

        text = fixString(text);
        System.out.println(text); */

        String fileName = "example1.txt";
        File file = new File(fileName);

        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        System.out.println("File path: " + file.getPath());
        System.out.println("File absolute path: " + file.getAbsolutePath());
        System.out.println("File exists: " + file.exists());

        String fileName2 = "example2_newline.txt";
        calcAverageFromFile(fileName2);

        double[] grades = readGradesFromFile(fileName2);
        for(int i = 0; i < grades.length; i++){
            System.out.println(grades[i]);
        }

    }
    public static void fileMatchAndPrint(String fileName) throws FileNotFoundException{
        Scanner s = new Scanner(new File(fileName));
        while(s.hasNextLine()){
            String line = s.nextLine();
            String fixedLine = line.replaceAll("[Tt][OoWw]?o", "2");
            System.out.println(fixedLine);
        }
        s.close();
    }
    public static double[] readGradesFromFile(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        int count = 0;
        while(s.hasNextDouble()){ // counts the number of elements
            s.nextDouble(); // we are reading the next double but not storing it
            count++;
        }
        s.close();
        // create a result array with the correct size
        double [] result = new double[count];
        // read the file again
        s = new Scanner(f);// creates a new Scanner to read the same file again
        int i = 0; // index of the array
        while(s.hasNextDouble()){
           result[i] = s.nextDouble();
           i++;
        }
        s.close();
        return result;
    }

    public static double calcAverageFromFile(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        int count = 0;
        double sum = 0.0;
        while(s.hasNextDouble()){
            sum += s.nextDouble();
            count++;
        }
        s.close();
        return sum / count;
    }


    public static String fixString(String str){
        return str.replaceAll("(\\w)(\\s+)([\\.,])","$1$3");

    }
}
