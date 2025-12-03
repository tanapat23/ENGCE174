package lab2_10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        int N = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            N = getValidPositiveInteger(sc, "Enter the number of products (N): ");
            
            ShoppingCart cart = new ShoppingCart();
            
            for (int i = 0; i < N; i++) {
                System.out.println("\n--- Product #" + (i + 1) + " ---");
                
                String name = getValidString(sc, "  Enter Product Name: ");
                
                double price = getValidPositiveDouble(sc, "  Enter Price (double): ");
                
                Product newProduct = new Product(name, price);
                
                cart.addProduct(newProduct);
            }
            
            double finalPrice = cart.calculateTotalPrice();
            
            System.out.println("\n--- Output ---");
            System.out.printf("%.1f%n", finalPrice);
            
        } 
    }
    
    public static int getValidPositiveInteger(Scanner scanner, String prompt) {
        int number = 0;
        while (number <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number <= 0) {
                    System.out.println("Error: Must be a positive integer (> 0).");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer number.");
                scanner.next();
            }
        }
        return number;
    }
    
    public static double getValidPositiveDouble(Scanner scanner, String prompt) {
        double number = -1.0;
        
        while (number < 0) {
            System.out.print(prompt);
            
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                if (number < 0) {
                    System.out.println("Error: Value cannot be negative.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a numerical value.");
                scanner.next();
            }
        }
        return number;
    }

    public static String getValidString(Scanner scanner, String prompt) {
        scanner.nextLine();
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
