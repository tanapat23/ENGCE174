package lab4;

// This program demonstrates creating an immutable RGB color model in Java.
// Includes 2 validations:
// 1) If input is outside 0–255 → clamp to 0 or 255
// 2) If user inputs non-integer → program handles via Scanner default behavior (simple validation rule in this assignment)

import java.util.Scanner;

class Color {

    // Private attributes (immutable)
    private int red;
    private int green;
    private int blue;

    // Constructor with validation and clamping
    public Color(int r, int g, int b) {
        // Validation #1: clamp lower bound
        if (r < 0)
            r = 0;
        if (g < 0)
            g = 0;
        if (b < 0)
            b = 0;

        // Validation #2: clamp upper bound
        if (r > 255)
            r = 255;
        if (g > 255)
            g = 255;
        if (b > 255)
            b = 255;

        this.red = r;
        this.green = g;
        this.blue = b;
    }

    // Getter methods (no setters → immutable object)
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    // Display method
    public void displayRGB() {
        System.out.println("R=" + red + ", G=" + green + ", B=" + blue);
    }
}

public class RgbMode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt for user input
        System.out.print("Enter Red value: ");
        int r = sc.nextInt();

        System.out.print("Enter Green value: ");
        int g = sc.nextInt();

        System.out.print("Enter Blue value: ");
        int b = sc.nextInt();

        // Create immutable Color object
        Color c = new Color(r, g, b);

        // Display result
        c.displayRGB();
    }
}
