package lab5;

class ProjectTask {
    protected String description;
    protected int baseHours;

    public ProjectTask(String description, int baseHours) {
        this.description = description; // Store task description
        this.baseHours = baseHours; // Store base hours
    }

    public double calculateCost() {
        return baseHours * 50.0; // Base rate calculation
    }
}

class ComplexTask extends ProjectTask {
    protected double setupFee;

    public ComplexTask(String description, int baseHours, double setupFee) {
        super(description, baseHours); // Call parent constructor
        this.setupFee = setupFee; // Store setup fee
    }

    @Override
    public double calculateCost() {
        // Base cost + 10% complexity + setup fee
        return (super.calculateCost() * 1.10) + setupFee;
    }
}

class SimpleTask extends ProjectTask {
    public SimpleTask(String description, int baseHours) {
        super(description, baseHours); // Call parent constructor
    }

    @Override
    public double calculateCost() {
        // Simple task has no extra cost
        return super.calculateCost();
    }
}

public class ProjectCost {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ----------------------- COMPLEX TASK INPUT -----------------------
        System.out.print("Enter complex task description: ");
        String cDesc = sc.nextLine();

        System.out.print("Enter complex task hours: ");
        int cHours;

        // Validation #1: integer check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid hours. Setting to 0.");
            cHours = 0;
            sc.nextLine();
        } else {
            cHours = sc.nextInt();
        }

        // Validation #2: non-negative check
        if (cHours < 0) {
            System.out.println("Negative hours not allowed. Setting to 0.");
            cHours = 0;
        }

        System.out.print("Enter setup fee: ");
        double fee;

        // Validation #1: numeric check
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid fee. Setting to 0.");
            fee = 0.0;
            sc.nextLine();
        } else {
            fee = sc.nextDouble();
        }

        // Validation #2: non-negative check
        if (fee < 0) {
            System.out.println("Negative fee not allowed. Setting to 0.");
            fee = 0.0;
        }

        sc.nextLine(); // clear buffer

        // ----------------------- SIMPLE TASK INPUT -----------------------
        System.out.print("Enter simple task description: ");
        String sDesc = sc.nextLine();

        System.out.print("Enter simple task hours: ");
        int sHours;

        // Validation #1: integer check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid hours. Setting to 0.");
            sHours = 0;
            sc.nextLine();
        } else {
            sHours = sc.nextInt();
        }

        // Validation #2: non-negative check
        if (sHours < 0) {
            System.out.println("Negative hours not allowed. Setting to 0.");
            sHours = 0;
        }

        // ----------------------- OBJECT CREATION -----------------------
        ComplexTask complex = new ComplexTask(cDesc, cHours, fee);
        SimpleTask simple = new SimpleTask(sDesc, sHours);

        // Store in parent class array
        ProjectTask[] tasks = { complex, simple };

        // ----------------------- COST DISPLAY -----------------------
        for (ProjectTask t : tasks) {
            // Display cost with 1 decimal place
            System.out.printf("%s cost: %.1f\n", t.description, t.calculateCost());
        }

        sc.close();
    }
}