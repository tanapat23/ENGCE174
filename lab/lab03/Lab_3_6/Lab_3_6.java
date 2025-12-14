package Lab_3.Lab_3_6;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (Double.isNaN(initialBalance) || Double.isInfinite(initialBalance) || initialBalance < 0) {
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            double newBalance = this.balance + amount;
            if (Double.isInfinite(newBalance)) {
                System.out.println("Invalid deposit amount.");
            } else {
                this.balance = newBalance;
                System.out.println("Deposit successful.");
            }
        }
    }

    public void withdraw(double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount) || amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }
}


public class Lab_3_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Initial Balance :");
        double initialBalance = input.nextDouble();
        
        System.out.println("Enter Deposit Amount :");
        double depositAmount = input.nextDouble();
        
        System.out.println("Enter Withdraw Amount :");
        double withdrawAmount = input.nextDouble();

        BankAccount myAccount = new BankAccount(initialBalance);
        
        myAccount.deposit(depositAmount);
        
        myAccount.withdraw(withdrawAmount);

        System.out.println("Final Balance : " + myAccount.getBalance());
        
        input.close();
    }
}