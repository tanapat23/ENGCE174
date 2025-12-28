package lab5;

class Vehicle {

    protected String color;

    // Constructor of superclass
    public Vehicle(String color) {
        // Assign the inherited attribute
        this.color = color;
    }
}

class Car extends Vehicle {

    protected int wheels;

    // Constructor of subclass
    public Car(String color, int wheels) {
        super(color); // Call parent constructor
        this.wheels = wheels; // Set own attribute
    }

    // Display both inherited and own attributes
    public void displayDetails() {
        System.out.println("Color: " + color + ", Wheels: " + wheels);
    }
}

public class VehicleInfomation {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Prompt user input
        System.out.print("Enter color: ");
        String color = sc.nextLine();

        System.out.print("Enter number of wheels: ");
        int wheels;

        // Validation #1: Numeric check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid wheels. Setting to 0.");
            wheels = 0;
            sc.nextLine();
        } else {
            wheels = sc.nextInt();
        }

        // Validation #2: Must be non-negative
        if (wheels < 0) {
            System.out.println("Negative wheels not allowed. Setting to 0.");
            wheels = 0;
        }

        // Create Car object
        Car myCar = new Car(color, wheels);

        // Display details
        myCar.displayDetails();

        sc.close();
    }
}
