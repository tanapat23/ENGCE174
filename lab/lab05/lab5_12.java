package lab5;

class Service {
    protected String name;
    protected double basePrice;

    public Service(String name, double basePrice) {
        this.name = name; // Store service name
        this.basePrice = basePrice; // Store base price
    }

    public double calculateFinalPrice() {
        return basePrice; // Default final price
    }
}

class BasicService extends Service {

    public BasicService(String name, double basePrice) {
        super(name, basePrice); // Call parent constructor
    }

    @Override
    public double calculateFinalPrice() {
        // Final price = base price + 5% tax
        return basePrice * 1.05;
    }
}

class PremiumService extends Service {
    protected double premiumRate;

    public PremiumService(String name, double basePrice, double premiumRate) {
        super(name, basePrice); // Call parent constructor
        this.premiumRate = premiumRate; // Additional premium rate
    }

    @Override
    public double calculateFinalPrice() {
        // Final price = base price * (1 + premiumRate)
        return basePrice * (1 + premiumRate);
    }
}

public class FinalPrice {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // -------- INPUT FOR BASIC SERVICE --------
        System.out.print("Enter Basic Service name: ");
        String bName = sc.nextLine();

        System.out.print("Enter Basic Service base price: ");
        double bPrice = readPositiveDouble(sc);

        sc.nextLine(); // clear buffer

        // -------- INPUT FOR PREMIUM SERVICE --------
        System.out.print("Enter Premium Service name: ");
        String pName = sc.nextLine();

        System.out.print("Enter Premium Service base price: ");
        double pPrice = readPositiveDouble(sc);

        System.out.print("Enter Premium Service premium rate (e.g. 0.15): ");
        double pRate = readPositiveDouble(sc);

        // -------- OBJECT CREATION --------
        Service basic = new BasicService(bName, bPrice);
        Service premium = new PremiumService(pName, pPrice, pRate);

        Service[] services = { basic, premium };

        // -------- DISPLAY FINAL PRICES --------
        for (Service s : services) {
            System.out.println(s.name + " Final Price: " + s.calculateFinalPrice());
        }

        sc.close();
    }

    // ========== HELPER: VALIDATE POSITIVE DOUBLE ==========
    private static double readPositiveDouble(java.util.Scanner sc) {
        double v;

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid number. Setting to 0.0");
            sc.next();
            return 0.0;
        }

        v = sc.nextDouble();

        if (v < 0) {
            System.out.println("Negative not allowed. Setting to 0.0");
            return 0.0;
        }

        return v;
    }
}
