package com.zacisrael;

public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return super.earnings() * weeklySalary;
    }

}
