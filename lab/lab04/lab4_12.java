package lab4;

// This program demonstrates deep copying with a mutable component (Schedule).
// Includes: constructor logic, copy constructor, validation, and input prompts.

import java.util.Scanner;

// Mutable Component 
class Schedule {

    private int hour;

    // Setter with validation (hour must be 0–23)
    public void setHour(int newHour) {
        if (newHour < 0)
            newHour = 0;
        if (newHour > 23)
            newHour = 23;
        this.hour = newHour;
    }

    // Getter
    public int getHour() {
        return hour;
    }

    // Constructor for convenience
    public Schedule(int hour) {
        setHour(hour); // uses validation
    }
}

// Container Class
class EmployeeSchedule {

    private String name;
    private Schedule schedule;

    // Main Constructor
    public EmployeeSchedule(String name, Schedule schedule) {

        // Validation: employee name cannot be empty
        if (name == null || name.trim().isEmpty()) {
            name = "Unknown"; // fallback value
        }

        this.name = name;
        this.schedule = schedule;
    }

    // Copy Constructor (Deep copy for Schedule)
    public EmployeeSchedule(EmployeeSchedule other) {
        this.name = other.name; // shallow copy for String
        this.schedule = new Schedule(other.schedule.getHour()); // deep copy
    }

    public void displaySchedule() {
        System.out.println(name + ": " + schedule.getHour() + ":00");
    }
}

// ---------------------- Main Class ----------------------
public class CopyEmployeeSchedule {

    // safe integer input
    public static int safeInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid number. Please enter an integer.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextInt();
    }

    // safe string (not empty)
    public static String safeString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine().trim();
        while (s.isEmpty()) {
            System.out.println("Input cannot be empty.");
            System.out.print(prompt);
            s = sc.nextLine().trim();
        }
        return s;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input Section
        String name = safeString(sc, "Enter employee name: ");
        int startHour = safeInt(sc, "Enter start hour (0-23): ");
        int newHour = safeInt(sc, "Enter new hour (0-23): ");

        // Object Creation
        Schedule sch1 = new Schedule(startHour); // original schedule
        EmployeeSchedule emp1 = new EmployeeSchedule(name, sch1); // original employee
        EmployeeSchedule emp2 = new EmployeeSchedule(emp1); // deep copy

        // Modify original schedule (should not affect emp2)
        sch1.setHour(newHour);

        // Output
        emp1.displaySchedule();
        emp2.displaySchedule();

        sc.close();
    }
}