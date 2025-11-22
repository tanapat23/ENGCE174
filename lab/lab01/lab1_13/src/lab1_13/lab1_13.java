package lab1_13;

import java.util.Scanner;

public class lab1_13 {

    public static void main(String[] args) {
        
        int R = 0;
        int C = 0;
        int onlineCount = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            while (R <= 0) {
                System.out.print("Enter number of rows (R): ");
                if (sc.hasNextInt()) {
                    R = sc.nextInt();
                    if (R <= 0) {
                        System.out.println("Error: R must be positive.");
                    }
                } else {
                    System.out.println("Error: Invalid input.");
                    sc.next();
                }
            }
            while (C <= 0) {
                System.out.print("Enter number of columns (C): ");
                if (sc.hasNextInt()) {
                    C = sc.nextInt();
                    if (C <= 0) {
                        System.out.println("Error: C must be positive.");
                    }
                } else {
                    System.out.println("Error: Invalid input.");
                    sc.next();
                }
            }
            
            int[][] grid = new int[R][C];
            
            System.out.println("Enter server status (0 or 1) for " + (R * C) + " servers:");
            
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    
                    int status = -1;
					while (status != 0 && status != 1) {
                        if (sc.hasNextInt()) {
                            status = sc.nextInt();
                            if (status != 0 && status != 1) {
                                System.out.println("Status must be 0 or 1.");
                            }
                        } else {
                            System.out.println("Invalid input.");
                            sc.next();
                        }
                    }
                    
                    grid[i][j] = status;
                    if (status == 1) {
                        onlineCount++;
                    }
                }
            }
            System.out.println("Total Online Servers (1s): " + onlineCount);
            
        }
    }
}