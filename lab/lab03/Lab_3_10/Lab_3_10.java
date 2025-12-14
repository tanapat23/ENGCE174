package Lab_3.Lab_3_10;

import java.util.Scanner;

class SystemLogger {
    private static int currentLogLevel = 1;

    private static String getLevelName(int level) {
        switch (level) {
            case 1: return "INFO";
            case 2: return "DEBUG";
            case 3: return "ERROR";
            default: return "UNKNOWN";
        }
    }

    public static void setLogLevel(int newLevel) {
        if (newLevel >= 1 && newLevel <= 3) {
            currentLogLevel = newLevel;
            System.out.println("Log level set to " + getLevelName(newLevel));
        } else {
            System.out.println("Invalid log level.");
        }
    }

    public static void log(int messageLevel, String message) {
        if (messageLevel >= currentLogLevel) {
            System.out.println("[" + getLevelName(messageLevel) + "] : " + message);
        }
    }
}

public class Lab_3_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Number");

        if (input.hasNextInt()) {
            int n = input.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter Command (SET or LOG) : ");
                String command = input.next();

                if (command.equals("SET")) {
                    System.out.print("Enter New Level (1-3) : ");
                    int level = input.nextInt();

                    SystemLogger.setLogLevel(level);

                } else if (command.equals("LOG")) {
                    System.out.print("Enter Log Level (1-3) : ");
                    int level = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Log Message : ");
                    String message = input.nextLine();

                    SystemLogger.log(level, message);
                }
            }
        }

        input.close();
    }
}