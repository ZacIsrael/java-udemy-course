package com.zacisrael;

public class SalariedEmployee extends Employee
{
    private double weeklySalary;
    public SalariedEmployee(String n){ super(n); }
    public SalariedEmployee(String n, double salary) {
        super(n);
        System.out.println("Inside SalariedEmployee constructor.");
        weeklySalary = salary;
    }

    public double earnings() {
        return weeklySalary;
    }

    public static void main(String[]args){
        SalariedEmployee se = new SalariedEmployee("Mark", 100);
    }

    //public String toString() {return this.getName()+ " bye!";}
}