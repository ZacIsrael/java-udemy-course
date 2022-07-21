package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	    // Question 2: I wrote an if statement inside my code that will print out which car
        // I would buy given the test case and why I would buy that car.

        // Question 3: Returning something will return the value of something after the loop has finished running.
        // printing something out is literally printing whatever you want the code to print out at that
        // point in the method (Can be a string , an int, or a double).
        compareCars(5);
        compareCars(10);
        compareCars(15);
        compareCars(20);
    }
    public static int compareCars(int years){
        int year = 0;
        double carA = 20000;
        double carB = 30000;
        double maintenanceA = 1300;
        double maintenanceB = 1000;
        System.out.println("Year\tCar A\tCar B");
        System.out.println(year + "\t    "+ carA +"\t    " +carB);

        for(int i = 1; i < years + 1; i++){ // run this look "years + 1" because i = 1
            carA =  20000 + (maintenanceA * Math.pow(1.15, i)) + ((15000/25.0) * 2.50 * i) ;
            // I multiplied maintenance by 1.15 raised to the i power because maintenance increases 15 % every year
            // I added "(15000/25.0) * 2.50 * i" at the end because car A drives 25 miles every gallon of gas
            // which is $2.50 and car A drives 15,000 miles in a year
            carB =  30000 + (maintenanceB * Math.pow(1.10, i)) + ((15000/32.0) * 2.50 * i);
            // I multiplied maintenance by 1.10 raised to the i power because maintenance increases 10 % every year
            // I added "(15000/32.0) * 2.50 * i" at the end because car B drives 32 miles every gallon of gas
            // which is $2.50 and car A drives 15,000 miles in a year
            System.out.println(i + "\t    " + carA + "\t    " + carB);
        }
        if(carA > carB){ // Question 2
            System.out.println("I would buy car A because it would be cheaper to have for " + years + " years.");
        }
        else{
            System.out.println("I would buy car B because it would be cheaper to have for " + years + " years.");
        }
        return year;

    }

}
