package lab2_8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String mode;
        double temperature = 0.0;
        double result = 0.0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            mode = getValidString(sc, "Enter Mode (C_TO_F or F_TO_C): ");
            
            temperature = getValidDoubleInput(sc, "Enter Temperature: ");
            
            if (mode.equalsIgnoreCase("C_TO_F")) {
                result = TempConverter.celsiusToFahrenheit(temperature); 
            } else if (mode.equalsIgnoreCase("F_TO_C")) {
                result = TempConverter.fahrenheitToCelsius(temperature);
            } else {
                System.out.println("Error: Invalid mode specified.");
                return;
            }
            
            System.out.printf("\nOutput: %.1f%n", result);
            
        } 
    }
    
    public static double getValidDoubleInput(Scanner scanner, String prompt) {
        double number = 0.0;
        
        while (true) {
            System.out.print(prompt);
            
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break;
            } else {
                System.out.println("Error: Invalid input. Please enter a numerical value.");
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