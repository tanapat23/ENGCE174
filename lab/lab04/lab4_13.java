package lab4;

import java.util.Scanner;

class Subscription {

    private final String planName;
    private final int durationDays;

    private static int maxDuration = 365;

    public Subscription(String planName, int durationDays) {

        if (durationDays > maxDuration) {
            durationDays = maxDuration;
        } else if (durationDays < 0) {
            durationDays = 0;
        }

        System.out.println("duration set to " + durationDays);

        this.planName = planName;
        this.durationDays = durationDays;
    }

    public Subscription(Subscription other) {
        this.planName = other.planName;
        this.durationDays = other.durationDays;
    }

    public static void setMaxDuration(int max) {

        if (max > 0) {
            maxDuration = max;
            System.out.println("Max duration set to " + max);
        } else {
            System.out.println("Invalid max policy.");
        }
    }

    public Subscription extend(int days) {

        if (days <= 0) {
            System.out.println("Invalid extension days.");
            return this;
        }

        int newDays = this.durationDays + days;

        if (newDays > maxDuration) {
            System.out.println("Extension failed: Exceeds max policy.");
            return this;
        }

        System.out.println("Extension successful.");
        return new Subscription(this.planName, newDays);
    }

    public void displayInfo() {
        System.out.println("Plan: " + this.planName + ", Days: " + this.durationDays);
    }
}

public class PolicySetting {

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input type. Enter an integer.");
                sc.next();
                continue;
            }

            return sc.nextInt();
        }
    }

    private static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt + Validation 1 (type check)
        int max = readInt(sc, "Enter maxDuration: ");
        Subscription.setMaxDuration(max);

        String plan = readString(sc, "Enter plan name: ");
        int days = readInt(sc, "Enter initial duration: ");

        int ext1 = readInt(sc, "Enter first extension days: ");
        int ext2 = readInt(sc, "Enter second extension days: ");

        Subscription s1 = new Subscription(plan, days);
        Subscription s2 = s1.extend(ext1);
        Subscription s3 = s2.extend(ext2);

        s3.displayInfo();

        sc.close();
    }
}
