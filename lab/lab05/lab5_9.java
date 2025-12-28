package lab5;

class Item {
    protected String name;

    public Item(String name) {
        this.name = name; // Store item name
    }

    public double getValue() {
        return 0.0; // Default value for base class
    }
}

class PhysicalProduct extends Item {
    protected double unitPrice;
    protected int quantity;

    public PhysicalProduct(String name, double unitPrice, int quantity) {
        super(name); // Call parent constructor
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public double getValue() {
        // Calculate value for physical product
        return unitPrice * quantity;
    }
}

class DigitalSubscription extends Item {
    protected double monthlyCost;
    protected int months;

    public DigitalSubscription(String name, double monthlyCost, int months) {
        super(name); // Call parent constructor
        this.monthlyCost = monthlyCost;
        this.months = months;
    }

    @Override
    public double getValue() {
        // Calculate value for digital subscription
        return monthlyCost * months;
    }
}

public class StockCalculate {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ---------------- PHYSICAL PRODUCT INPUT ----------------
        System.out.print("Enter physical product name: ");
        String pName = sc.nextLine();

        System.out.print("Enter unit price: ");
        double uPrice;

        // Validation #1: numeric check
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid price. Setting to 0.");
            uPrice = 0.0;
            sc.nextLine();
        } else {
            uPrice = sc.nextDouble();
        }

        // Validation #2: non-negative check
        if (uPrice < 0) {
            System.out.println("Negative price not allowed. Setting to 0.");
            uPrice = 0.0;
        }

        System.out.print("Enter quantity: ");
        int qty;

        // Validation #1: integer check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid quantity. Setting to 0.");
            qty = 0;
            sc.nextLine();
        } else {
            qty = sc.nextInt();
        }

        // Validation #2: non-negative check
        if (qty < 0) {
            System.out.println("Negative quantity not allowed. Setting to 0.");
            qty = 0;
        }

        sc.nextLine(); // clear buffer

        // ---------------- DIGITAL SUBSCRIPTION INPUT ----------------
        System.out.print("Enter subscription name: ");
        String dName = sc.nextLine();

        System.out.print("Enter monthly cost: ");
        double mCost;

        // Validation #1: numeric check
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid cost. Setting to 0.");
            mCost = 0.0;
            sc.nextLine();
        } else {
            mCost = sc.nextDouble();
        }

        // Validation #2: non-negative check
        if (mCost < 0) {
            System.out.println("Negative cost not allowed. Setting to 0.");
            mCost = 0.0;
        }

        System.out.print("Enter number of months: ");
        int months;

        // Validation #1: integer check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid months. Setting to 0.");
            months = 0;
            sc.nextLine();
        } else {
            months = sc.nextInt();
        }

        // Validation #2: non-negative check
        if (months < 0) {
            System.out.println("Negative months not allowed. Setting to 0.");
            months = 0;
        }

        // ---------------- OBJECT CREATION ----------------
        PhysicalProduct physical = new PhysicalProduct(pName, uPrice, qty);
        DigitalSubscription digital = new DigitalSubscription(dName, mCost, months);

        // Array of parent class
        Item[] items = { physical, digital };

        // ---------------- TOTAL VALUE CALCULATION ----------------
        double totalValue = 0.0;

        for (Item i : items) {
            // Polymorphism: each getValue() runs its own class implementation
            totalValue += i.getValue();
        }

        // Display result with 1 decimal place
        System.out.printf("Total Value: %.1f\n", totalValue);

        sc.close();
    }
}