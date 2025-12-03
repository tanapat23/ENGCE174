package lab2_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String ownerName;
        double initialBalance = 0.0;
        double depositAmount = 0.0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.print("Enter Owner Name: ");
            ownerName = sc.nextLine();
            
            initialBalance = getValidPositiveDouble(sc, "Enter Initial Balance (double): ");
            
            BankAccount myAccount = new BankAccount(ownerName, initialBalance);
            
            depositAmount = getValidPositiveDouble(sc, "Enter Deposit Amount (double): ");
            
            myAccount.deposit(depositAmount);
            
            System.out.println("\n--- Output Summary ---");
            myAccount.displaySummary();
            
        } 
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
}