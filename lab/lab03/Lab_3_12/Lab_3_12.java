package Lab_3.Lab_3_12;

import java.util.Scanner;

class Employee {
    private String name;
    private double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name == null ? "" : name.trim();
        this.monthlySalary = monthlySalary > 0 ? monthlySalary : 0.0;
    }

    public String getName() {
        return this.name;
    }

    public void giveRaise(double amount) {
        if (amount > 0) {
            this.monthlySalary += amount;
            System.out.println("Raise applied.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private double getAnnualSalary() {
        return this.monthlySalary * 12.0;
    }

    public double calculateTax(double taxRate) {
        double rate = taxRate;
        if (Double.isNaN(rate) || Double.isInfinite(rate)) rate = 0.0;
        if (rate < 0.0) rate = 0.0;
        if (rate > 1.0) rate = 1.0;
        return getAnnualSalary() * rate;
    }
}

public class Lab_3_12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name : ");
        String name = input.nextLine();

        double salary = 0.0;
        System.out.print("Enter Monthly Salary : ");
        if (input.hasNextDouble()) {
            salary = input.nextDouble();
        } else {
            input.next();
            salary = 0.0;
        }

        double taxRate = 0.0;
        System.out.print("Enter Tax Rate (e.g. 0.10) : ");
        if (input.hasNextDouble()) {
            taxRate = input.nextDouble();
        } else {
            input.next();
            taxRate = 0.0;
        }

        double raiseAmount = 0.0;
        System.out.print("Enter Raise Amount : ");
        if (input.hasNextDouble()) {
            raiseAmount = input.nextDouble();
        } else {
            input.next();
            raiseAmount = 0.0;
        }

        Employee emp = new Employee(name, salary);

        System.out.println("Tax (Before) : " + emp.calculateTax(taxRate));

        emp.giveRaise(raiseAmount);

        System.out.println("Tax (After) : " + emp.calculateTax(taxRate));

        input.close();
    }
}
