package com.zacisrael;

import java.util.ArrayList;

class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

//        ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        Integer integer = new Integer(54);
        //Integer is a class, int is a primitive type
        Double doubleValue = new Double(12.25);
        // Double is a class, double is a primitive type
        
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= 10 ; i++) {
            intArrayList.add(Integer.valueOf(i));
            
        }
        for (int i = 0; i <= 10 ; i++) {
            System.out.println(i + " --> " + intArrayList.get(i).intValue());
        }

        Integer myIntValue = 56; //   Same thing as typing Integer myIntValue = Integer.valueOf(56);
        int myInt = myIntValue; // Java is doing "myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();

        for (double i = 0.0; i <= 10.0; i += 0.5) {
            myDoubleValues.add((i)); // = myDoubleValues.add(Double.valueOf(i));
            // Autoboxing: converting the primitive type double to the object (Double)
        }
        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i); // = double value = myDoubleValues.get(i).doubleValue();
            System.out.println(i + " --> " + value);
            // Unboxing: converting it from the object value to the primitive type

        }
    }
}
