package lab2;

import java.util.Scanner;

public class lab2_1 {

    public static void main(String[] args) {
        
        String studentId;
        String fullName;
        try (Scanner sc = new Scanner(System.in)) {
            
            System.out.println("Student Data Entry");
            System.out.print("Enter Student ID: ");
            studentId = sc.nextLine();
            System.out.print("Enter Full Name: ");
            fullName = sc.nextLine();
            Student student1 = new Student(studentId, fullName);
            System.out.println("Output");
            student1.displayStudentInfo();
            
        } 
    }
}