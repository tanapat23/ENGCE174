package lab2_4;

import java.util.Scanner;

public class lab2_4 {

    public static void main(String[] args) {
        
        String studentName;
        int midtermScore = 0;
        int finalScore = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            
            studentName = getValidString(sc, "Enter Full Name: ");
            
            midtermScore = getValidScore(sc, "Enter Midterm Score (0-100): ");
            
            finalScore = getValidScore(sc, "Enter Final Score (0-100): ");
            
            Student student1 = new Student(studentName, midtermScore, finalScore);
            
            System.out.println("\n--- Output Summary ---");
            student1.displaySummary();
            
        }
    }
    
    public static int getValidScore(Scanner scanner, String prompt) {
        int score = -1;
        while (score < 0 || score > 100) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
                if (score < 0 || score > 100) {
                    System.out.println("Error: Score must be between 0 and 100.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer number.");
                scanner.next();
            }
        }
        return score;
    }

    public static String getValidString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}