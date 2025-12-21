package lab4;
// This program demonstrates creating an immutable Point object in 2D space.

// Includes 2 validations:
// 1) dx and dy cannot be extremely large (simple range check)
// 2) Display warning if initial x or y is too large (but still allowed)

import java.util.Scanner;

class Point {

    // Immutable attributes
    private final int x;
    private final int y;

    // Constructor
    public Point(int x, int y) {
        // Validation #1: warn if coordinates too large (simple check)
        if (x > 1_000_000 || y > 1_000_000) {
            System.out.println("Warning: Very large coordinate values.");
        }

        this.x = x;
        this.y = y;
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Create a new point after moving
    public Point move(int dx, int dy) {
        // Validation #2: movement too large
        if (Math.abs(dx) > 1_000_000 || Math.abs(dy) > 1_000_000) {
            System.out.println("Warning: Movement value is too large.");
        }

        int newX = this.x + dx;
        int newY = this.y + dy;

        return new Point(newX, newY); // return new immutable object
    }

    // Display method
    public void displayInfo() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

public class Model2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input prompts
        System.out.print("Enter initial x: ");
        int x = sc.nextInt();

        System.out.print("Enter initial y: ");
        int y = sc.nextInt();

        System.out.print("Enter dx movement: ");
        int dx = sc.nextInt();

        System.out.print("Enter dy movement: ");
        int dy = sc.nextInt();

        // Create initial point
        Point p1 = new Point(x, y);

        // Move to create p2
        Point p2 = p1.move(dx, dy);

        // Move again to create p3
        Point p3 = p2.move(dx, dy);

        // Display all points
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
    }
}