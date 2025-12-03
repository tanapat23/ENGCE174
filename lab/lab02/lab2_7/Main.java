package lab2_7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String ownerName;
        double initialBalance = 0.0;
        double withdrawal1 = 0.0;
        double withdrawal2 = 0.0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            ownerName = getValidString(sc, "");
            
            initialBalance = getValidPositiveDouble(sc, "");
            
            withdrawal1 = getValidPositiveDouble(sc, "");
            
            withdrawal2 = getValidPositiveDouble(sc, "");
            
            BankAccount myAccount = new BankAccount(ownerName, initialBalance);
            
            myAccount.withdraw(withdrawal1);
            myAccount.withdraw(withdrawal2);
            
            myAccount.displayBalance();
            
        } 
    }
    
    public static double getValidPositiveDouble(Scanner scanner, String prompt) {
        double number = -1.0;
        
        while (number < 0) {
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
        return scanner.nextLine();
    }
}