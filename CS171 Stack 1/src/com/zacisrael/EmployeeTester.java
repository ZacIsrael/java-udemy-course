package com.zacisrael;

import java.util.ArrayList;
import java.util.Iterator;

// This class will be used to test "Employee" stuff.
// Class "Employee" is defined inside Employee.java, therefore the file
// Employee.java must be located in the same folder as EmployeeTester.java
public class EmployeeTester {

    public static void main(String[] args) {
        SalariedEmployee zac = new SalariedEmployee("Zac", 100.0);
        Employee keith = zac;

        /*** Object-Oriented Programming ***/
        Employee e1 = new Employee();

        Employee e2 = new Employee("Kate");
        Employee e3 = new Employee("Kevin");
        Employee e4 = new Employee("Randall");

        /*** ArrayList ***/
        // Now let's create a dynamic (flexible) list of employees
        // using Java.util.ArrayList
        // Doc: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
        ArrayList<Employee> empList = new ArrayList<Employee>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
//      empList.add(e4);
        empList.add(1, e4);  // Q: What does this do?

        // Now let's iterate over all employees in empList to print their info
        Iterator<Employee> itr = empList.iterator(); // first get the iterator from the arraylist
        // Hint: Object "itr" gives you two important methods: hasNext() and next()
        // TODO: Use "itr" to traverse all employees and print their information!
        System.out.println();
        while( itr.hasNext() ){
            System.out.println( itr.next() );
        }

        // Q: What is the expected output?
        System.out.println("List size before get(2) = " + empList.size()); // 4
        System.out.println(empList.get(2));
        System.out.println("List size after get(2) = " + empList.size()); // 4
        empList.remove(2);
        System.out.println("List size after remove(2) = " + empList.size()); // 3


        /*** Inheritance ***/
        // Prerequisite: SalariedEmployee.java and HourlyEmployee.java must be in the same directory
        SalariedEmployee se = new SalariedEmployee("Ronaldo", 100.0);
//         Q: What will these statements print?
        System.out.println(se.getName()); // Ronaldo
        System.out.println(se); //toString() is called


        System.out.println("Test casting between subclass and superclass.");
        Employee empObj = new Employee();
        //     SalariedEmployee sEmpObj = (SalariedEmployee) empObj;
        System.out.println("\n");
//
        SalariedEmployee sempObj = new SalariedEmployee("Ronaldo", 100.0);
        System.out.println("\n");
        Employee eMpObj = (Employee) sempObj;
        HourlyEmployee hempObj = new HourlyEmployee("navid", 20, 7);
        System.out.println(hempObj.getName());
        System.out.println("\n");
        System.out.println(hempObj.earnings()); // 140
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");

       //Employee eMmpObj = sempObj; // allowed
        // Employee empObj = (Employee) sEmpObj; // allowed, but not necessary
//       System.out.println(empObj.earnings());

       System.out.println(empObj instanceof SalariedEmployee);
       System.out.println(sempObj instanceof SalariedEmployee);
       System.out.println(sempObj instanceof Employee);
       System.out.println(empObj instanceof Employee);
       System.out.println(empObj instanceof SalariedEmployee);
    }

}
