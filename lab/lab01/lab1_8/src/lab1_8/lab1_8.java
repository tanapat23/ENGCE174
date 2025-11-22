package lab1_8;

import java.util.Scanner;
import java.util.Arrays;

public class lab1_8 { 

    public static void main(String[] args) {
        
        int countN = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            while (countN <= 0) {
                System.out.print("Please enter the count (N): ");
                if (sc.hasNextInt()) {
                    countN = sc.nextInt();
                    if (countN <= 0) {
                        System.out.println("N must 0");
                    }
                } else {
                    System.out.println("Please enter an integer number.");
                    sc.next();
                }
            }
            
            int[] numbers = new int[countN];
            for (int i = 0; i < countN; i++) {
                int currentNumber;
                while (true) { 
                    System.out.print("Enter number " + (i + 1) + " of " + countN + ": ");
                    
                    if (sc.hasNextInt()) {
                        currentNumber = sc.nextInt();
                        numbers[i] = currentNumber;
                        break; 
                    } else {
                        System.out.println("Please enter an integer number.");
                        sc.next();
                    }
                }
            }
            
            int maxValue = Arrays.stream(numbers).max().orElseThrow();
            System.out.println("maximum is: " + maxValue);
            
        } 
    }
}