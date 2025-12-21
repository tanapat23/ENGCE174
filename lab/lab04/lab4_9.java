package lab4;

// This program demonstrates an immutable bank account with validation rules.
// Includes student-style English comments for clarity.

import java.util.Scanner;

class ImmutableAccount {

    private String accountId;
    private double balance;

    // Main constructor with validation
    public ImmutableAccount(String accountId, double balance) {

        // Validation #1: accountId must not be empty
        if (accountId.trim().isEmpty()) {
            System.out.println("Warning: Empty account ID replaced with 'UNKNOWN'.");
            accountId = "UNKNOWN";
        }

        // Validation #2: balance cannot be negative
        if (balance < 0) {
            System.out.println("Warning: Negative balance set to 0.0.");
            balance = 0.0;
        }

        this.accountId = accountId;
        this.balance = balance;
    }

    // Copy constructor (for duplicating an account)
    public ImmutableAccount(ImmutableAccount other) {
        this.accountId = other.accountId;
        this.balance = other.balance;
    }

    // Getter methods
    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    // Display method
    public void displayInfo() {
        System.out.printf("ID: %s, Balance: %.2f%n", accountId, balance);
    }

    // Deposit method: must return a new object
    public ImmutableAccount deposit(double amount) {

        if (amount > 0) {
            // Return a new updated account
            return new ImmutableAccount(this.accountId, this.balance + amount);
        } else {
            System.out.println("Invalid deposit amount.");
            return this; // Return the same object (immutable behavior)
        }
    }

    // Withdraw method: must return a new object
    public ImmutableAccount withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return this;
        }

        if (amount > this.balance) {
            System.out.println("Insufficient funds.");
            return this;
        }

        // Withdrawal succeeds → create a new account object
        return new ImmutableAccount(this.accountId, this.balance - amount);
    }
}

public class BankAccount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt before receiving all inputs
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        System.out.print("Enter starting balance: ");
        double startBalance = sc.nextDouble();

        System.out.print("Enter deposit amount: ");
        double dep = sc.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        double wd = sc.nextDouble();

        // Step 1: Create initial account
        ImmutableAccount acc1 = new ImmutableAccount(id, startBalance);

        // Step 2: Deposit → returns new object
        ImmutableAccount acc2 = acc1.deposit(dep);

        // Step 3: Withdraw → returns new object
        ImmutableAccount acc3 = acc2.withdraw(wd);

        // Step 4: Display results
        acc1.displayInfo();
        acc3.displayInfo();

        sc.close(); // Always close the scanner
    }
}