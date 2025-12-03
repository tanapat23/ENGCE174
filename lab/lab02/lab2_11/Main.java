package lab2_11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String model;
        int initialYear = 0;
        int newYear = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            model = getValidString(sc, "Enter Car Model: ");
            
            initialYear = getValidPositiveInteger(sc, "Enter Initial Year: ");
            
            newYear = getValidPositiveInteger(sc, "Enter New Year for update: ");
            
            Car myCar = new Car(model, initialYear);
            
            myCar.setYear(newYear);
            
            System.out.println("Model: " + myCar.getModel());
            System.out.println("Year: " + myCar.getYear());
            
        } 
    }
    
    public static int getValidPositiveInteger(Scanner scanner, String prompt) {
        int number = 0;
        
        while (number <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number <= 0) {
                    System.out.println("Error: Must be a positive integer.");
                }
            } else {
                System.out.println("Error: Invalid input.");
                scanner.next();
            }
        }
        return number;
    }
    
    public static String getValidString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}