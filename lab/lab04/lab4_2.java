package lab4;

import java.util.Scanner;

class Product {

    private String name;
    private double price;

    // Constructor 1 (Chaining)
    // This constructor only receives the product name
    // and calls the main constructor with default price (0.0)
    public Product(String name) {
        this(name, 0.0);
    }

    // Constructor 2 (Main constructor)
    // This sets both name and price
    public Product(String name, double price) {

        // Simple validation: name should not be empty
        // If it's empty, we use "Unknown" instead
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        this.price = price;
    }

    // Method to show product information
    public void displayInfo() {
        System.out.println("Product: " + name + ", Price: " + price);
    }
}

public class ProductInfo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for mode
        System.out.print("Enter mode (1 or 2): ");
        int mode = sc.nextInt();
        sc.nextLine(); // clear buffer

        Product p;

        if (mode == 1) {
            // Prompt for product name
            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            p = new Product(name);

        } else {
            // Prompt for name + price
            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter product price: ");
            double price = sc.nextDouble();

            p = new Product(name, price);
        }

        // Display product info
        p.displayInfo();
    }
}
