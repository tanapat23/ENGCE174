package lab4;

// This program builds immutable Configuration objects.
// It includes constructor validation, merge constructor logic,
// and strong input protection to avoid invalid user input.
import java.util.Scanner;

class Configuration {

    private final String theme;
    private final int fontSize;
    private final boolean darkMode;

    // --- Main Constructor with Validation ---
    public Configuration(String theme, int fontSize, boolean darkMode) {

        // Validation 1: fontSize must be between 10 and 20
        if (fontSize < 10) {
            fontSize = 10;
        }
        if (fontSize > 20) {
            fontSize = 20;
        }

        this.theme = theme;
        this.fontSize = fontSize;
        this.darkMode = darkMode;
    }

    // --- Merge Constructor (combine base + user configs) ---
    public Configuration(Configuration base, Configuration user) {
        // Logic from problem
        this.theme = user.theme;
        // user theme overrides base
        this.darkMode = user.darkMode;
        // user dark mode overrides base
        this.fontSize = base.fontSize;
        // font size comes from base only
    }

    public void displaySettings() {
        System.out.println("Theme: " + theme
                + ", Size: " + fontSize
                + ", Dark: " + darkMode);
    }
}

public class ThemeSetting {

    // Safe integer input method
    public static int safeInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextInt();
    }

    // Safe boolean input method
    public static boolean safeBoolean(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter true/false.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextBoolean();
    }

    // Safe string input (nextLine())
    public static String safeString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // --- Get Base Configuration ---
        String baseTheme = safeString(sc, "Enter Base Theme: ");
        int baseSize = safeInt(sc, "Enter Base Font Size: ");
        boolean baseDark = safeBoolean(sc, "Enter Base Dark Mode (true/false): ");

        sc.nextLine(); // clear leftover newline

        // --- Get User Configuration ---
        String userTheme = safeString(sc, "Enter User Theme: ");
        int userSize = safeInt(sc, "Enter User Font Size: ");
        boolean userDark = safeBoolean(sc, "Enter User Dark Mode (true/false): ");

        // Build objects
        Configuration baseConfig = new Configuration(baseTheme, baseSize, baseDark);
        Configuration userConfig = new Configuration(userTheme, userSize, userDark);
        Configuration finalConfig = new Configuration(baseConfig, userConfig);

        // Output merged result
        finalConfig.displaySettings();

        sc.close();
    }
}
