package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	    /*Car porsche = new Car(); // Initializing
	    Car holden = new Car();
	    porsche.setModel("911"); // Calling the setModel method and updating it with "Carerra" as the parameter (test case)
		System.out.println("Model is " + porsche.getModel());

		SimpleCalculator calculator = new SimpleCalculator();
		calculator.setFirstNumber(5.0);
		calculator.setSecondNumber(4);
		System.out.println("add= " + calculator.getAdditionResult());
		System.out.println("subtract= " + calculator.getSubtractionResult());
		calculator.setFirstNumber(5.25);
		calculator.setSecondNumber(0);
		System.out.println("multiply= " + calculator.getMultiplicationResult());
		System.out.println("divide= " + calculator.getDivisionResult()); */

		Person person = new Person();
		person.setFirstName("");   // firstName is set to empty string
		person.setLastName("");    // lastName is set to empty string
		person.setAge(10);
		System.out.println("fullName= " + person.getFullName());
		System.out.println("teen= " + person.isTeen());
		person.setFirstName("John");    // firstName is set to John
		person.setAge(18);
		System.out.println("fullName= " + person.getFullName());
		System.out.println("teen= " + person.isTeen());
		person.setLastName("Smith");    // lastName is set to Smith
		System.out.println("fullName= " + person.getFullName());





    }
}
