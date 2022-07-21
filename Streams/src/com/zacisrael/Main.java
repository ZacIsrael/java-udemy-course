package com.zacisrael;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // Stream: a set of object references, does not change the actual list
    // We cannot reuse streams

    public static void main(String[] args) {
        // write your code here
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071");

        List<String> gNumbers = new ArrayList<>();
// Using a stream
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
               // .map(s -> s.toUpperCase()) // this works as well, either lambda or ": :" like the line above
                .filter(s-> s.startsWith("G"))
                .sorted()
                .forEach(System.out:: println);

        Stream<String> ioNumberStram = Stream.of("I26", "I17", "I29", "071");// gives a stream of string object
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I29", "071");
        Stream<String> concatStream = Stream.concat(ioNumberStram, inNumberStream); // concat the two streams

        System.out.println(concatStream
                .distinct()
                .peek(System.out::println) // prints the distinct items
                .count());

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow WHite", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("=========================");
//        List<String> sortedGNumbers = someBingoNumbers
////                .stream()
////                .map(String::toUpperCase) // created a references of the strings in someBingoNumbers but in uppercase
////                .filter(s -> s.startsWith("G")) // gets the references that start with "G
////                .sorted() // sorts them
////                .collect(Collectors.toList()); // turns them into a list

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase) // created a references of the strings in someBingoNumbers but in uppercase
                .filter(s -> s.startsWith("G")) // gets the references that start with "G
                .sorted() // sorts them
                .collect(ArrayList::new, ArrayList::add, ArrayList:: addAll);
               // .collect() creates a new arrayList to store the references

        sortedGNumbers.forEach(s -> System.out.println(s));

        System.out.println("============");
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));


        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1: e2)
                .ifPresent(System.out::println);

        System.out.println("=============");
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();



        //System.out.println(concatStream.distinct().count());
        // prints the number of unique Strings in the concatenated stream


        // The long way
//
//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//               // System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((s1,  s2)-> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

    }
}
