package lab1_14;

import java.util.Scanner;

public class lab1_14 {
    public static void main(String[] args) {
        
        int R = 0;
        int C = 0;
        
        try (Scanner sc = new Scanner(System.in)) {
            R = getPositiveInteger(sc, "Enter number of rows (R): ");
            C = getPositiveInteger(sc, "Enter number of columns (C): ");
            char[][] map = new char[R][C];
            System.out.println("\nEnter map data ('. ' or '*'):");
            for (int i = 0; i < R; i++) {
                System.out.print("Enter row " + i + " (C characters): ");
                String rowInput = sc.next();
                if (rowInput.length() != C) {
                    System.out.println("Error: Row must contain exactly " + C + " characters. Restarting...");
                    i--;
                    continue;
                }
                map[i] = rowInput.toCharArray();
            }
            
            System.out.println("\n--- Target Input (0-indexed) ---");
            int targetR = getCoordinate(sc, "Enter target row (0 to " + (R - 1) + "): ", R - 1);
            int targetC = getCoordinate(sc, "Enter target column (0 to " + (C - 1) + "): ", C - 1);
            
            System.out.println("--- Result ---");
            
            if (map[targetR][targetC] == '*') {
                System.out.println("Mine");
            } else {
                int bombCount = countAdjacentMines(map, targetR, targetC, R, C);
                System.out.println(bombCount);
            }
            
        } 
    }

   
    public static int countAdjacentMines(char[][] map, int r, int c, int maxR, int maxC) {
        int count = 0;
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            int neighborR = r + dr[i];
            int neighborC = c + dc[i];
            if (neighborR >= 0 && neighborR < maxR && 
                neighborC >= 0 && neighborC < maxC) {
                if (map[neighborR][neighborC] == '*') {
                    count++;
                }
            }
        }
        return count;
    }
    public static int getPositiveInteger(Scanner scanner, String prompt) {
        int number = 0;
        while (number <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number <= 0) {
                    System.out.println("Error: Must be a positive integer (> 0).");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer number.");
                scanner.next();
            }
        }
        return number;
    }
    public static int getCoordinate(Scanner scanner, String prompt, int maxIndex) {
        int coord = -1;
        while (coord < 0 || coord > maxIndex) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                coord = scanner.nextInt();
                if (coord < 0 || coord > maxIndex) {
                    System.out.println("Error: Coordinate must be between 0 and " + maxIndex + ".");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter an integer coordinate.");
                scanner.next();
            }
        }
        return coord;
    }
}