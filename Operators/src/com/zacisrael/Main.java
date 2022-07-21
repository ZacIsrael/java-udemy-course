package com.zacisrael;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);

        int previousResult = result;

        result = result - 1;
        System.out.println(previousResult + " - 1 = " + result);

        previousResult = result;

        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);

        previousResult = result;

        result = result / 5;
        System.out.println(previousResult + " /5 = " + result);

        previousResult = result;
        result = result % 3; // will print out the remainder of the result after dividing it by 3
        System.out.println(previousResult + " % 3 = " + result);

        previousResult = result;
        result = result + 1;
        System.out.println("Result is now " + result);
        result++; // ++ means increment (add)  the count result by 1
        System.out.println("Result is now " + result);
        result--; // -- means take 1 away from the count each time
        System.out.println("Result is now " + result);

        result += 2; // is equivalent to result plus 2
        System.out.println("Result is now " + result);
        result *= 10; // multiplies the result by 10
        System.out.println("Result is now " + result);
        result -= 10; // subtract 10 from the result
        System.out.println("Result is now " + result);
        result /= 10; // result divided by 10
        System.out.println("Result is now " + result);

        boolean isAlien = false; // = is saying set the boolean value to false
        if (isAlien == true) // == is testing to see whether or not the value is false
            System.out.println("It is not an alien!"); // then print out this line
                // only print the line if the "if" statement is correct

        int topScore = 80;
        if (topScore < 100) // "!=" means NOT equal to , " >= " means greater to or equal to
            System.out.println("You got the high score!");

        int secondTopScore =  95;
        if((topScore > secondTopScore) && (topScore < 100))
            System.out.println("Greater than second top score and less then 100");

        if((topScore > 90) || (secondTopScore <= 90)) // "||" means "or"
            System.out.println("One of these tests is true");

        int newValue = 50;
        if(newValue == 50) // One "=" is used for assigning a value. "==" is used for the test
            System.out.println("This is an error");

        boolean isCar = false;
        if(isCar = true) // You onle need one "=" here because we are assigning the value "true" to the "isCar" boolean
            System.out.println("This is not supposed to happen");


         isCar = true;
         boolean wasCar = isCar ? true : false; // If isCar is evaluated to be true then return "true", ":" = otherwise, otherwise return "false"
         if(wasCar)
        System.out.println("wasCar is true");

         // 1. Create a double variable with the value of 20
         // 2. Create a second variable of type double with the value 80
         // 3. Add both numbers up and multiply by 25
         // 4. Use the remainder operator to figure out the remainder from the sum of #3 divided by 40
         // 5. Write an "if" statement that displays a message "Total was over the limit"
        //     if the remaining total (#4) is equal to 20 or less

        double variable1 = 20;

        double variable2 = 80;

        double multiplied = ((variable1 + variable2) * 25);

        System.out.println(multiplied);

        double remainder = (multiplied % 40);
        System.out.println("Remainder is " + remainder);

        if(remainder <= 20)
        System.out.println("Total was over the limit");
    }
}
