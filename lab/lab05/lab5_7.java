package lab5;

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name; // Set employee name
        this.baseSalary = baseSalary; // Set base salary
    }

    public double calculatePay() {
        // Default: return base salary
        return baseSalary;
    }
}

class SalesEmployee extends Employee {
    protected double commissionRate;

    public SalesEmployee(String name, double baseSalary, double commissionRate) {
        super(name, baseSalary); // Call parent constructor
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePay() {
        // Calculate pay with commission
        return baseSalary + (baseSalary * commissionRate);
    }
}

class Manager extends Employee {
    protected double fixedBonus;

    public Manager(String name, double baseSalary, double fixedBonus) {
        super(name, baseSalary); // Call parent constructor
        this.fixedBonus = fixedBonus;
    }

    @Override
    public double calculatePay() {
        // Calculate pay with fixed bonus
        return baseSalary + fixedBonus;
    }
}

class PayrollProcessor {
    public static void process(Employee e) {
        // Display employee total pay
        System.out.println(e.name + " total pay: " + e.calculatePay());
    }
}

public class SalaryCalculate {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ------------------- SALES EMPLOYEE INPUT -------------------
        System.out.print("Enter sales employee name: ");
        String sName = sc.nextLine();

        System.out.print("Enter base salary: ");
        double sSalary;

        // Validation #1: numeric check
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid salary. Setting to 0.");
            sSalary = 0.0;
            sc.nextLine();
        } else {
            sSalary = sc.nextDouble();
        }

        // Validation #2: non-negative
        if (sSalary < 0) {
            System.out.println("Negative salary not allowed. Setting to 0.");
            sSalary = 0.0;
        }

        System.out.print("Enter commission rate (e.g., 0.10): ");
        double sRate;

        // Validation #1: numeric
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid rate. Setting to 0.");
            sRate = 0.0;
            sc.nextLine();
        } else {
            sRate = sc.nextDouble();
        }

        // Validation #2: range check 0–1
        if (sRate < 0 || sRate > 1) {
            System.out.println("Rate out of range. Setting to 0.");
            sRate = 0.0;
        }

        sc.nextLine(); // Clear buffer

        // ------------------- MANAGER INPUT -------------------
        System.out.print("Enter manager name: ");
        String mName = sc.nextLine();

        System.out.print("Enter base salary: ");
        double mSalary;

        // Validation #1: numeric
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid salary. Setting to 0.");
            mSalary = 0.0;
            sc.nextLine();
        } else {
            mSalary = sc.nextDouble();
        }

        // Validation #2: non-negative
        if (mSalary < 0) {
            System.out.println("Negative salary not allowed. Setting to 0.");
            mSalary = 0.0;
        }

        System.out.print("Enter fixed bonus: ");
        double mBonus;

        // Validation #1: numeric
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid bonus. Setting to 0.");
            mBonus = 0.0;
            sc.nextLine();
        } else {
            mBonus = sc.nextDouble();
        }

        // Validation #2: non-negative
        if (mBonus < 0) {
            System.out.println("Negative bonus not allowed. Setting to 0.");
            mBonus = 0.0;
        }

        // ------------------- OBJECT CREATION -------------------
        SalesEmployee sales = new SalesEmployee(sName, sSalary, sRate);
        Manager manager = new Manager(mName, mSalary, mBonus);

        // ------------------- PROCESSING -------------------
        PayrollProcessor.process(sales);
        PayrollProcessor.process(manager);

        sc.close();
    }
}
