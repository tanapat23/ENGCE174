package Lab_3.Lab_3_13;

import java.util.Locale;
import java.util.Scanner;

class LicenseManager {
    private static int maxLicenses = 10;
    private static int usedLicenses = 0;

    public static void setMax(int max) {
        if (max < 0) {
            System.out.println("Invalid max value.");
            return;
        }
        if (max < usedLicenses) {
            System.out.println("Cannot set max lower than current usage.");
            return;
        }
        maxLicenses = max;
        System.out.println("Max licenses set to " + max);
    }

    public static boolean checkOut() {
        if (usedLicenses < maxLicenses) {
            usedLicenses++;
            System.out.println("Checkout successful.");
            return true;
        }
        System.out.println("Checkout failed: No licenses available.");
        return false;
    }

    public static void checkIn() {
        if (usedLicenses > 0) {
            usedLicenses--;
            System.out.println("Check-in successful.");
            return;
        }
        System.out.println("Nothing to check-in.");
    }

    public static void displayStatus() {
        System.out.println("Used: " + usedLicenses);
        System.out.println("Available: " + (maxLicenses - usedLicenses));
    }
}

public class Lab_3_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter N :");
        if (!input.hasNextInt()) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }
        int n = input.nextInt();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Command (SET, CHECKOUT, CHECKIN, STATUS) : ");
            if (!input.hasNextLine()) {
                System.out.println("No command provided.");
                break;
            }
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Empty command.");
                continue;
            }
            String[] parts = line.split("\\s+");
            String command = parts[0].toUpperCase(Locale.ROOT);
            if ("SET".equals(command)) {
                if (parts.length < 2) {
                    System.out.println("SET requires an integer value.");
                    continue;
                }
                try {
                    int newMax = Integer.parseInt(parts[1]);
                    LicenseManager.setMax(newMax);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer for SET.");
                }
            } else if ("CHECKOUT".equals(command)) {
                LicenseManager.checkOut();
            } else if ("CHECKIN".equals(command)) {
                LicenseManager.checkIn();
            } else if ("STATUS".equals(command)) {
                LicenseManager.displayStatus();
            } else {
                System.out.println("Unknown command.");
            }
        }
        input.close();
    }
}
