package lab5;

import java.util.Scanner;

class Shipping {
    protected String trackingId;
    protected double baseFee;

    public Shipping(String trackingId, double baseFee) {
        this.trackingId = trackingId;
        this.baseFee = baseFee;
    }

    // Returns base fee
    public double calculateTotalFee() {
        return baseFee;
    }
}

class StandardShipping extends Shipping {
    public StandardShipping(String id, double baseFee) {
        super(id, baseFee); // Call parent constructor
    }

    @Override
    public double calculateTotalFee() {
        // Return base fee + 5% processing fee
        return baseFee * 1.05;
    }
}

class PremiumShipping extends Shipping {
    protected double insuranceFee;

    public PremiumShipping(String id, double baseFee, double insuranceFee) {
        super(id, baseFee); // Call parent constructor
        this.insuranceFee = insuranceFee;
    }

    @Override
    public double calculateTotalFee() {
        // Must call super.calculateTotalFee() to get the base fee
        double base = super.calculateTotalFee();
        return base + insuranceFee;
    }
}

public class TransportationCosts {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------------- StandardShipping Input ----------------
        System.out.print("Enter Standard Shipping Tracking ID: ");
        String id1 = sc.nextLine();

        // Validation #1: ID cannot be empty
        if (id1.trim().isEmpty()) {
            System.out.println("Error: Tracking ID cannot be empty.");
            return;
        }

        // Validation #2: ID length must be at least 3 characters
        if (id1.length() < 3) {
            System.out.println("Error: Tracking ID must be at least 3 characters.");
            return;
        }

        System.out.print("Enter Standard Shipping Base Fee: ");
        double base1 = sc.nextDouble();

        // Validation #3: base fee must be >= 0
        if (base1 < 0) {
            System.out.println("Error: Base fee cannot be negative.");
            return;
        }

        sc.nextLine(); // Clear buffer

        // ---------------- PremiumShipping Input ----------------
        System.out.print("Enter Premium Shipping Tracking ID: ");
        String id2 = sc.nextLine();

        // Validation #4: ID cannot be empty
        if (id2.trim().isEmpty()) {
            System.out.println("Error: Tracking ID cannot be empty.");
            return;
        }

        // Validation #5: ID length must be at least 3 characters
        if (id2.length() < 3) {
            System.out.println("Error: Tracking ID must be at least 3 characters.");
            return;
        }

        System.out.print("Enter Premium Shipping Base Fee: ");
        double base2 = sc.nextDouble();

        // Validation #6: base fee must be >= 0
        if (base2 < 0) {
            System.out.println("Error: Base fee cannot be negative.");
            return;
        }

        System.out.print("Enter Premium Shipping Insurance Fee: ");
        double insurance = sc.nextDouble();

        // Validation #7: insurance fee must be >= 0
        if (insurance < 0) {
            System.out.println("Error: Insurance fee cannot be negative.");
            return;
        }

        // Create objects
        Shipping s1 = new StandardShipping(id1, base1);
        Shipping s2 = new PremiumShipping(id2, base2, insurance);

        // Store in array of parent class
        Shipping[] list = { s1, s2 };

        // Display results
        System.out.println("\n--- Shipping Fees ---");
        for (Shipping s : list) {
            System.out.println(s.calculateTotalFee());
        }

        sc.close();
    }
}
