package Lab_3.Lab_3_8;

import java.util.Scanner;

class InventoryItem {
    private final String productName;
    private int stock;

    public InventoryItem(String productName, int initialStock) {
        this.productName = productName == null ? "" : productName.trim();
        this.stock = Math.max(0, initialStock);
    }

    public String getProductName() {
        return this.productName;
    }

    public int getStock() {
        return this.stock;
    }

    public boolean addStock(int amount) {
        if (amount <= 0) return false;
        long newStock = (long) this.stock + amount;
        if (newStock > Integer.MAX_VALUE) return false;
        this.stock += amount;
        return true;
    }

    public int sellStock(int amount) {
        if (amount <= 0) return -1;
        if (amount > this.stock) return 0;
        this.stock -= amount;
        return 1;
    }
}

public class Lab_3_8 {
    private static int readIntSafe(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            if (line == null) continue;
            line = line.trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    private static String readNonEmptyLine(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            if (line == null) continue;
            line = line.trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input required.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = readNonEmptyLine(input, "Enter Product Name: ");
        int initialStock = readIntSafe(input, "Enter Initial Stock: ");
        InventoryItem item = new InventoryItem(name, initialStock);
        int number = readIntSafe(input, "Enter Number Item: ");

        for (int i = 0; i < number; i++) {
            System.out.print("Enter Command and Amount (ADD/SELL <number>): ");
            String line = input.nextLine();
            if (line == null) {
                System.out.println("Invalid input.");
                continue;
            }
            line = line.trim();
            if (line.isEmpty()) {
                System.out.println("Invalid input.");
                continue;
            }
            String[] parts = line.split("\\s+");
            if (parts.length < 2) {
                System.out.println("Invalid input.");
                continue;
            }
            String command = parts[0].trim();
            int amount;
            try {
                amount = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
                continue;
            }

            if ("ADD".equalsIgnoreCase(command)) {
                boolean ok = item.addStock(amount);
                System.out.println(ok ? "Stock added." : "Invalid amount.");
            } else if ("SELL".equalsIgnoreCase(command)) {
                int res = item.sellStock(amount);
                if (res > 0) System.out.println("Sale successful.");
                else if (res == 0) System.out.println("Not enough stock.");
                else System.out.println("Invalid amount.");
            } else {
                System.out.println("Unknown command.");
            }
        }

        System.out.println("Final Stock: " + item.getStock());
        input.close();
    }
}