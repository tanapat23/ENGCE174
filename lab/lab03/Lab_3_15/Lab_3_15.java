package Lab_3.Lab_3_15 ;

import java.util.Locale;
import java.util.Scanner;

class User {
    private final String username;
    private int failedAttempts;
    private boolean locked;
    private static int maxAttempts = 3;

    public User(String username) {
        this.username = username == null ? "" : username.trim();
        this.failedAttempts = 0;
        this.locked = false;
    }

    public String getUsername() { return this.username; }
    public boolean isLocked() { return this.locked; }
    public int getFailedAttempts() { return this.failedAttempts; }

    public static void setPolicy(int max) {
        if (max > 0) {
            maxAttempts = max;
            System.out.println("Policy updated.");
        } else {
            System.out.println("Invalid policy.");
        }
    }

    public void login(String password) {
        if (this.locked) {
            System.out.println("Account is locked.");
            return;
        }
        String pwd = password == null ? "" : password;
        if (pwd.equals("pass123")) {
            this.failedAttempts = 0;
            System.out.println("Login successful.");
        } else {
            this.failedAttempts++;
            if (this.failedAttempts >= maxAttempts) {
                this.locked = true;
                System.out.println("Login failed. Account locked.");
            } else {
                int left = Math.max(0, maxAttempts - this.failedAttempts);
                System.out.println("Login failed. " + left + " attempts left.");
            }
        }
    }
}

public class Lab_3_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter Username : ");
        String username = safeReadLine(input);
        if (username == null) username = "";

        User currentUser = new User(username);

        System.out.print("Enter number of commands (N) : ");
        Integer n = safeReadInt(input);
        if (n == null || n < 0) n = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Command (SET_POLICY [max], LOGIN [pass]) : ");
            String command = safeReadToken(input);
            if (command == null) {
                continue;
            }
            String cmd = command.trim().toUpperCase(Locale.ROOT);

            if ("SET_POLICY".equals(cmd)) {
                System.out.print("Enter newpolicy : ");
                Integer newMax = safeReadInt(input);
                if (newMax == null) {
                    System.out.println("Invalid policy.");
                } else {
                    User.setPolicy(newMax);
                }
            } else if ("LOGIN".equals(cmd)) {
                System.out.print("Enter password : ");
                String password = safeReadToken(input);
                if (password == null) password = "";
                currentUser.login(password);
            }
        }

        input.close();
    }

    private static String safeReadLine(Scanner sc) {
        try {
            String s = sc.nextLine();
            return s == null ? null : s.trim();
        } catch (Exception e) {
            return null;
        }
    }

    private static String safeReadToken(Scanner sc) {
        try {
            if (!sc.hasNext()) return null;
            String s = sc.next();
            return s == null ? null : s.trim();
        } catch (Exception e) {
            return null;
        }
    }

    private static Integer safeReadInt(Scanner sc) {
        try {
            if (!sc.hasNext()) return null;
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                sc.next();
                return null;
            }
        } catch (Exception e) {
                       return null;
        }
    }
}