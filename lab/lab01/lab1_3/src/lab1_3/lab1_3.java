package lab1_3;

import java.util.Scanner;

public class lab1_3 { 

	public static void main(String[] args) {
        int number = 0; 
        boolean isInteger = false;       
		try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please Enter Number : ");
            
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                isInteger = true;
            } else {
                System.out.println("Error: Please Enter an Integer Number.");
            } 
		}
        if (isInteger) {
            if (number % 2 == 0) {
                System.out.println("Even");	
            } else {
                System.out.println("Odd");
            }
        }
	}
}