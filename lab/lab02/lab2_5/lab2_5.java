package lab2_5;

import java.util.Scanner;

public class lab2_5 {

    public static void main(String[] args) {
        
        double width = 0.0;
        double height = 0.0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            width = getValidDoubleInput(sc, "Enter Width: ");
            
            height = getValidDoubleInput(sc, "Enter Height: ");
            
            Rectangle myRect = new Rectangle(width, height);
            
            System.out.println("\n--- Output ---");
            System.out.println(myRect.getArea());
            System.out.println(myRect.getPerimeter());
            
        } 
    }
    
    public static double getValidDoubleInput(Scanner scanner, String prompt) {
        double number = 0.0;
        
        while (true) {
            System.out.print(prompt);
            
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                if (number >= 0) {
                    break; 
                } else {
                    System.out.println("Error: Value must be positive.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a numerical value.");
                scanner.next();
            }
        }
        return number;
    }
}