package lab5;

import java.util.Scanner;

class RentalVehicle {
    protected String model;
    protected double rentalRate;

    public RentalVehicle(String model, double rentalRate) {
        this.model = model;
        this.rentalRate = rentalRate;
    }

    // Base rental fee
    public double calculateFee() {
        return rentalRate;
    }
}

class Car extends RentalVehicle {
    public Car(String model, double rentalRate) {
        super(model, rentalRate); // Call parent constructor
    }

    @Override
    public double calculateFee() {
        // Base rental rate + insurance fee
        return rentalRate + 100.0;
    }
}

class Motorcycle extends RentalVehicle {
    public Motorcycle(String model, double rentalRate) {
        super(model, rentalRate); // Call parent constructor
    }

    @Override
    public double calculateFee() {
        // Fee + 10% operation charge
        return rentalRate * 1.10;
    }
}

public class RentCarPolymorphism {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------------- Car Input ----------------
        System.out.print("Enter Car Model: ");
        String modelCar = sc.nextLine();

        // Validation #1: Model cannot be empty
        if (modelCar.trim().isEmpty()) {
            System.out.println("Error: Model cannot be empty.");
            return;
        }

        System.out.print("Enter Car Rental Rate: ");
        double rateCar = sc.nextDouble();

        // Validation #2: Rate must be >= 0
        if (rateCar < 0) {
            System.out.println("Error: Rental rate cannot be negative.");
            return;
        }

        sc.nextLine(); // Clear input buffer

        // ---------------- Motorcycle Input ----------------
        System.out.print("Enter Motorcycle Model: ");
        String modelMoto = sc.nextLine();

        // Validation #3: Model cannot be empty
        if (modelMoto.trim().isEmpty()) {
            System.out.println("Error: Model cannot be empty.");
            return;
        }

        System.out.print("Enter Motorcycle Rental Rate: ");
        double rateMoto = sc.nextDouble();

        // Validation #4: Rate must be >= 0
        if (rateMoto < 0) {
            System.out.println("Error: Rental rate cannot be negative.");
            return;
        }

        // Create objects
        RentalVehicle car = new Car(modelCar, rateCar);
        RentalVehicle moto = new Motorcycle(modelMoto, rateMoto);

        // Store in parent class array
        RentalVehicle[] list = { car, moto };

        // Calculate total fee
        double total = 0.0;
        for (RentalVehicle rv : list) {
            total += rv.calculateFee();
        }

        // Output
        System.out.println("\nTotal Rental Fee: " + total);

        sc.close();
    }
}
