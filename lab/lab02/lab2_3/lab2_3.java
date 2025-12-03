package lab2_3;

import java.util.Scanner;

public class lab2_3 {

    public static void main(String[] args) {
        
        int N = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            while (N <= 0) {
                System.out.print("Enter the number of students to register (N): ");
                if (sc.hasNextInt()) {
                    N = sc.nextInt();
                    if (N <= 0) {
                        System.out.println("Error: Must be a positive integer (> 0).");
                    }
                } else {
                    System.out.println("Error: Invalid input. Please enter an integer number.");
                    sc.next();
                }
            }
            
            for (int i = 0; i < N; i++) {
                
                System.out.println("\nStudent #" + (i + 1));
                
                System.out.print("  Enter Student ID: ");
                String studentId = sc.next();
                
                System.out.print("  Enter Name: ");
                String fullName = sc.next();
                
                new Student(studentId, fullName);
            }
            
            System.out.println("\nOutput:");
            System.out.println(Student.studentCount); 
            
        }
    }
}