package Lab_3.Lab_3_14;

import java.util.Locale;
import java.util.Scanner;

class BankAccount {
    private double balance;
    private static int totalTransactionCount = 0;

    public BankAccount(double initialDeposit) {
        this.balance = initialDeposit >= 0 ? initialDeposit : 0;
        System.out.println("Account created.");
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        totalTransactionCount++;
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        totalTransactionCount++;
        System.out.println("Withdrawal successful.");
    }

    public static int getTotalTransactionCount() {
        return totalTransactionCount;
    }
}

public class Lab_3_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        BankAccount myAccount = null;
        System.out.print("Enter N : ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid N.");
            scanner.close();
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("1.CREATE 2.DEPOSIT 3.WITHDRAW 4.STATUS 5.GLOBAL_STATUS");
            System.out.print("Enter Command : ");
            if (!scanner.hasNext()) {
                System.out.println("Invalid command.");
                break;
            }
            String cmd = scanner.next().trim().toUpperCase(Locale.ROOT);
            switch (cmd) {
                case "CREATE":
                    System.out.print("Enter Initial Deposit : ");
                    Double initDep = readDoubleSafe(scanner);
                    if (initDep == null) {
                        System.out.println("Invalid amount.");
                        break;
                    }
                    myAccount = new BankAccount(initDep);
                    break;
                case "DEPOSIT":
                    System.out.print("Enter Amount : ");
                    Double depAmt = readDoubleSafe(scanner);
                    if (depAmt == null) {
                        System.out.println("Invalid amount.");
                        break;
                    }
                    if (myAccount == null) {
                        System.out.println("No account exists.");
                    } else {
                        myAccount.deposit(depAmt);
                    }
                    break;
                case "WITHDRAW":
                    System.out.print("Enter Amount : ");
                    Double wdAmt = readDoubleSafe(scanner);
                    if (wdAmt == null) {
                        System.out.println("Invalid amount.");
                        break;
                    }
                    if (myAccount == null) {
                        System.out.println("No account exists.");
                    } else {
                        myAccount.withdraw(wdAmt);
                    }
                    break;
                case "STATUS":
                    if (myAccount == null) {
                        System.out.println("No account exists.");
                    } else {
                        System.out.println("Balance : " + myAccount.getBalance());
                    }
                    break;
                case "GLOBAL_STATUS":
                    System.out.println("Total Transactions : " + BankAccount.getTotalTransactionCount());
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
        scanner.close();
    }

    private static Double readDoubleSafe(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        String token = scanner.next();
        try {
            return Double.parseDouble(token);
        } catch (Exception e) {
            return null;
        }
    }
}
