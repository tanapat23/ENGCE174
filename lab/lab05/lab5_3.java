package lab5;

class Employee {

    protected double salary;

    // Calculate base bonus (10% of salary)
    public double calculateBonus() {
        return salary * 0.10;
    }
}

class Manager extends Employee {

    // Override bonus calculation for manager
    @Override
    public double calculateBonus() {
        // Get base bonus from superclass
        double baseBonus = super.calculateBonus();
        // Add extra 5% of salary
        double extra = salary * 0.05;
        return baseBonus + extra;
    }
}

public class EmployeeBonus {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Prompt for salary
        System.out.print("Enter salary: ");
        double salary;

        // Validation #1: Check numeric input
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid salary. Setting salary to 0.");
            salary = 0;
            sc.nextLine();
        } else {
            salary = sc.nextDouble();
        }

        // Validation #2: Salary cannot be negative
        if (salary < 0) {
            System.out.println("Negative salary is not allowed. Setting salary to 0.");
            salary = 0;
        }

        // Create Manager object
        Manager mgr = new Manager();

        // Set inherited attribute
        mgr.salary = salary;

        // Calculate and display bonus
        double bonus = mgr.calculateBonus();
        System.out.println("Bonus: " + bonus);

        sc.close();
    }
}
