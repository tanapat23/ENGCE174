package Lab_3.Lab_3_11;

import java.util.Locale;
import java.util.Scanner;

class SystemConfig {
    private static volatile SystemConfig instance;
    private String serverUrl;
    private int maxConnections;

    private SystemConfig() {
        this.serverUrl = "default.server.com";
        this.maxConnections = 10;
    }

    public static SystemConfig getInstance() {
        if (instance == null) {
            synchronized (SystemConfig.class) {
                if (instance == null) {
                    instance = new SystemConfig();
                }
            }
        }
        return instance;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public void setServerUrl(String url) {
        if (url == null) return;
        String trimmed = url.trim();
        if (!trimmed.isEmpty()) {
            this.serverUrl = trimmed;
            System.out.println("URL updated.");
        } else {
            System.out.println("Invalid URL.");
        }
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int count) {
        if (count > 0) {
            this.maxConnections = count;
            System.out.println("Max connections updated.");
        } else {
            System.out.println("Invalid count.");
        }
    }
}

public class Lab_3_11 {
    private static int readIntSafe(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                String junk = scanner.next();
                System.out.print("Invalid number, try again : ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        System.out.print("Enter number of commands (N) : ");
        if (!input.hasNextInt()) {
            System.out.println("No valid number provided. Exiting.");
            input.close();
            return;
        }
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Command (SET_URL, SET_MAX, SHOW, EXIT) : ");
            String command = input.nextLine().trim().toUpperCase(Locale.ROOT);
            SystemConfig config = SystemConfig.getInstance();

            if (command.equals("SET_URL")) {
                System.out.print("Enter New URL : ");
                String newUrl = input.nextLine();
                config.setServerUrl(newUrl);
            } else if (command.equals("SET_MAX")) {
                System.out.print("Enter New Max Count : ");
                int newMax = readIntSafe(input);
                input.nextLine();
                config.setMaxConnections(newMax);
            } else if (command.equals("SHOW")) {
                System.out.println("URL: " + config.getServerUrl());
                System.out.println("MAX: " + config.getMaxConnections());
            } else if (command.equals("EXIT")) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }

        input.close();
    }
}
