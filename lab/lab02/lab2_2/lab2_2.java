package lab2_2;

import java.util.Scanner;

public class lab2_2 {

    public static void main(String[] args) {
        
        String studentId;
        String fullName;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.print("Enter Student ID: ");
            studentId = sc.nextLine();
            
            System.out.print("Enter Full Name: ");
            fullName = sc.nextLine();
            
            Student student1 = new Student(studentId, fullName);
            
            System.out.println("\nOutput:");
            student1.displayInfo();
            
        }
    }
}