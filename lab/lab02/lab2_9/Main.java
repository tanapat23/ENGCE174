package lab2_9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String name;
        String street;
        String city;
        String zipCode;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            name = getValidString(sc, "Enter Full Name: ");
            
            street = getValidString(sc, "Enter Street: ");
            city = getValidString(sc, "Enter City: ");
            zipCode = getValidString(sc, "Enter Zip Code: ");
            
            Address studentAddress = new Address(street, city, zipCode);
            
            Student student1 = new Student(name, studentAddress);
            
            System.out.println("\n--- Output ---");
            student1.displayProfile();
            
        } 
    }
    
    public static String getValidString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}