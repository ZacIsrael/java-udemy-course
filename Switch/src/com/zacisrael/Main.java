package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
      /*  int value = 1;
        if(value == 1){
            System.out.println("Value was 1");
        } else if(value == 2){
            System.out.println("Value was 2");
        } else{
            System.out.println("Was not 1 or 2");
        } */

        int switchValue = 3;

        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break; // adding " break " is essential, otherwise, data will be inaccuarate

            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5: // groups multiple test cases
                System.out.println("was a 3, or 4, or 5");
                System.out.println("Actually, it was a " + switchValue);
                break;

            default: // any other case that is not being covered above
                System.out.println("Was not 1, 2, 3, 4, or 5");
               break; // Last line of switch statement does not need to have break



        }

        char charValue = 'F';
        switch(charValue){
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            case 'C': case 'D': case 'E':
                System.out.println(charValue + " was found");
                break;
            default:
                System.out.println("Could not find A, B, C, D, E");
                break;
        }

        String month = "January";
        switch(month){
            case "January":
                System.out.println("Jan");
                break;
            case "June":
                System.out.println("Jun");
                break;
            default:
                System.out.println("The month was a month other than June or January");
        }



    }


}
