package lab2_12;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String courseId;
        String courseName;
        String studentName;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            courseId = getValidString(sc, "Enter Course ID: ");
            
            courseName = getValidString(sc, "Enter Course Name: ");
            
            studentName = getValidString(sc, "Enter Student Name: ");
            
            Course oopCourse = new Course(courseId, courseName);
            
            Student student1 = new Student(studentName, oopCourse);
            
            student1.displayEnrollment();
            
        } 
    }
    
    public static String getValidString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}