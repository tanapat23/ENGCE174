package lab4;

import java.util.Scanner;

class TimePeriod {

    private int startHour;
    private int endHour;

    // Default constructor
    public TimePeriod() {
        this(9, 17);
    }

    // Main constructor with validations
    public TimePeriod(int startHour, int endHour) {

        // --- Validation 1: Keep hours within 0–23 ---
        if (startHour < 0)
            startHour = 0;
        if (startHour > 23)
            startHour = 23;
        if (endHour < 0)
            endHour = 0;
        if (endHour > 23)
            endHour = 23;

        // --- Validation 2: Ensure logical order (start < end) ---
        if (startHour > endHour) {
            int temp = startHour;
            startHour = endHour;
            endHour = temp;
        }

        this.startHour = startHour;
        this.endHour = endHour;
    }

    public void displayPeriod() {
        System.out.println(startHour + ":00 - " + endHour + ":00");
    }
}

public class TimePeriodModel {

    // Method to safely read an integer with input protection
    public static int safeIntInput(Scanner sc, String prompt) {
        System.out.print(prompt);

        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next(); // clear invalid token
            System.out.print(prompt);
        }

        return sc.nextInt();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int mode = safeIntInput(sc, "Enter mode (1=Default, 2=Custom): ");

        TimePeriod tp;

        if (mode == 1) {
            tp = new TimePeriod();
        } else {
            int start = safeIntInput(sc, "Enter start hour: ");
            int end = safeIntInput(sc, "Enter end hour: ");
            tp = new TimePeriod(start, end);
        }

        tp.displayPeriod();

        sc.close();
    }
}
