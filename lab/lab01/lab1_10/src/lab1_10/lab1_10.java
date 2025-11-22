package lab1_10;

import java.util.Scanner;

public class lab1_10 {

    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the Width: ");
        double width = sc.nextDouble();
        
        System.out.print("Please enter the Height: ");
        double height = sc.nextDouble();
        double resultArea = calculateArea(width, height);
        System.out.println("The calculated area is: " + resultArea); 
        sc.close();
    }
}