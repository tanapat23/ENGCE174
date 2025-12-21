package lab4;

import java.util.Scanner;

class Player {

    private String username;
    private int level;

    // Default constructor
    // This sets default values for a guest player
    public Player() {
        this.username = "Guest";
        this.level = 1;
    }

    // Overloaded constructor (main)
    // This sets username and level from user input
    public Player(String username, int level) {

        // Simple validation: username must not be empty
        if (username == null || username.trim().isEmpty()) {
            this.username = "Unknown";
        } else {
            this.username = username;
        }

        this.level = level;
    }

    // Method to display player profile
    public void displayProfile() {
        System.out.println("User: " + username + ", Level: " + level);
    }
}

public class PlayerInfo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user for mode
        System.out.print("Enter mode (1 or 2): ");
        int mode = sc.nextInt();
        sc.nextLine(); // clear buffer

        Player p;

        if (mode == 1) {
            // Create player using default constructor
            p = new Player();

        } else {
            // Mode 2: ask for username and level
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter level: ");
            int level = sc.nextInt();

            p = new Player(username, level);
        }

        // Display player information
        p.displayProfile();
    }
}