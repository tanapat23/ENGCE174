package Lab_3.Lab_3_5;

import java.util.Scanner;

class DatabaseConnection {
    private final String connectionString;
    private volatile boolean connected;

    public DatabaseConnection(String connectionString) {
        String s = connectionString == null ? "" : connectionString.trim();
        this.connectionString = s.isEmpty() ? "Unknown" : s;
        this.connected = false;
    }

    public synchronized boolean isConnected() {
        return connected;
    }

    public synchronized void connect() {
        if (!connected) {
            connected = true;
            System.out.println("Connected to " + connectionString);
        } else {
            System.out.println("Already connected.");
        }
    }

    public synchronized void disconnect() {
        if (connected) {
            connected = false;
            System.out.println("Disconnected.");
        } else {
            System.out.println("Already disconnected.");
        }
    }
}

public class Lab_3_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Connection String : ");
        String connStr = input.hasNextLine() ? input.nextLine() : "";

        DatabaseConnection database = new DatabaseConnection(connStr);

        database.connect();
        database.disconnect();
        database.disconnect();

        System.out.println(database.isConnected());

        input.close();
    }
}