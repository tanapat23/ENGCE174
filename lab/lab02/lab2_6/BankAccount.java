package lab2_6;

public class BankAccount {
    
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void displaySummary() {
        System.out.println("Owner: " + this.ownerName);
        System.out.printf("Balance: %.2f%n", this.balance);
    }
}
