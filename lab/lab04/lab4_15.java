package lab4;

import java.util.Scanner;

class AuditRecord {

    private final String user;
    private final String[] logMessages;

    private static int maxMessages = 3;

    // Simple constructor call main constructor with empty array
    public AuditRecord(String user) {
        this(user, new String[0]); // Constructor Chaining
    }

    // Main constructor Deep Copy + Trimming Old Logs
    public AuditRecord(String user, String[] logs) {
        this.user = user;

        // Validation: trim logs if exceeds policy
        if (logs.length > maxMessages) {
            this.logMessages = new String[maxMessages];
            int start = logs.length - maxMessages;
            // keep latest logs
            for (int i = 0; i < maxMessages; i++) {
                this.logMessages[i] = logs[start + i];
            }
        } else {
            this.logMessages = new String[logs.length];
            for (int i = 0; i < logs.length; i++) {
                this.logMessages[i] = logs[i];
            }
        }
    }

    // Static Setter
    public static void setMaxMessages(int max) {
        if (max > 0) {
            maxMessages = max;
            System.out.println("Policy set to " + max);
        } else {
            System.out.println("Invalid policy.");
        }
    }

    // Immutable Action
    public AuditRecord addMessage(String message) {
        if (logMessages.length < maxMessages) {

            String[] newArr = new String[logMessages.length + 1];

            for (int i = 0; i < logMessages.length; i++) {
                newArr[i] = logMessages[i];
            }

            newArr[newArr.length - 1] = message;

            return new AuditRecord(this.user, newArr);
        } else {
            System.out.println("Log is full.");
            return this;
        }
    }

    public void displayLog() {
        System.out.print("User: " + user + ", Logs: " + logMessages.length + " [");

        for (int i = 0; i < logMessages.length; i++) {
            System.out.print(logMessages[i]);
            if (i < logMessages.length - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }
}

public class AuditMessage {

    // Validation #1 type
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input type. Please enter an integer.");
                sc.next();
                continue;
            }
            return sc.nextInt();
        }
    }

    // Validation #2 — logic > 0
    private static int validatePositive(int n) {
        if (n <= 0) {
            System.out.println("Value must be positive. Set to 1.");
            return 1;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Set policy
        int max = validatePositive(readInt(sc, "Enter max log policy: "));
        AuditRecord.setMaxMessages(max);

        // Read username
        System.out.print("Enter username: ");
        String username = sc.next();

        // Create empty record
        AuditRecord record = new AuditRecord(username);

        // Number of log commands
        int N = validatePositive(readInt(sc, "Enter number of logs: "));

        sc.nextLine(); // clear buffer

        // Loop for logs
        for (int i = 1; i <= N; i++) {
            System.out.print("Log #" + i + ": ");
            String msg = sc.nextLine();
            record = record.addMessage(msg);
        }

        // Final Output
        record.displayLog();

        sc.close();
    }
}
