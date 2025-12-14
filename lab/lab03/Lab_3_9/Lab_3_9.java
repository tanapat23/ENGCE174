
package Lab_3.Lab_3_9;

import java.util.Scanner;

final class User {
    private final String username;
    private String password;
    private static int minPasswordLength = 8;

    public static boolean setMinLength(int length) {
        if (length < 4) {
            System.out.println("Invalid length.");
            return false;
        }
        minPasswordLength = length;
        System.out.println("New min length set to " + length);
        return true;
    }

    public static int getMinLength() {
        return minPasswordLength;
    }

    public User(String username, String password) {
        this.username = sanitize(username);
        if (this.username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        String p = sanitize(password);
        if (p.length() >= minPasswordLength) {
            this.password = p;
            System.out.println("Creation successful.");
        } else {
            this.password = "invalid";
            System.out.println("Creation failed.");
        }
    }

    public boolean setPassword(String newPassword) {
        String p = sanitize(newPassword);
        if (p.length() >= minPasswordLength) {
            this.password = p;
            System.out.println("Update successful.");
            return true;
        } else {
            System.out.println("Update failed.");
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    private static String sanitize(String s) {
        if (s == null) return "";
        String t = s.trim();
        return t;
    }
}

public class Lab_3_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter Min Length1 : ");
            int minLength1 = readInt(input);
            input.nextLine();
            User.setMinLength(minLength1);

            System.out.print("Enter User Name1 : ");
            String user1_name = safeReadLine(input);
            System.out.print("Enter User Pass1 : ");
            String user1_pass = safeReadLine(input);
            User user1 = new User(user1_name, user1_pass);

            System.out.print("Enter User Name2 : ");
            String user2_name = safeReadLine(input);
            System.out.print("Enter User Pass2 : ");
            String user2_pass = safeReadLine(input);
            User user2 = new User(user2_name, user2_pass);

            System.out.print("Enter Min Length2 : ");
            int minLength2 = readInt(input);
            input.nextLine();
            User.setMinLength(minLength2);

            System.out.print("Enter New User Pass2 : ");
            String user2_newPass = safeReadLine(input);
            user2.setPassword(user2_newPass);

            System.out.println(user1.getPassword());
            System.out.println(user2.getPassword());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }

    private static int readInt(Scanner input) {
        while (true) {
            if (input.hasNextInt()) {
                return input.nextInt();
            }
            input.next();
            System.out.print("Invalid number. Try again: ");
        }
    }

    private static String safeReadLine(Scanner input) {
        String s = input.nextLine();
        if (s == null) return "";
        return s.trim();
    }
}
