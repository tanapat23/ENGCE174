package lab5;

class Animal {

    protected String name;
    protected int age;

    // Display animal information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Dog extends Animal {

    // Dog sound method
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

public class AnimalSounds {
    public static void main(String[] args) {

        // Create Scanner
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Prompt for inputs
        System.out.print("Enter dog name: ");
        String name = sc.nextLine();

        System.out.print("Enter dog age: ");
        int age;

        // Validation #1: Ensure age is an integer
        if (!sc.hasNextInt()) {
            System.out.println("Invalid age. Setting age to 0.");
            age = 0;
            sc.nextLine();
        } else {
            age = sc.nextInt();
        }

        // Validation #2: Age cannot be negative
        if (age < 0) {
            System.out.println("Negative age is not allowed. Setting age to 0.");
            age = 0;
        }

        // Create Dog object
        Dog dog = new Dog();

        // Assign inherited attributes
        dog.name = name; // Access through protected field
        dog.age = age;

        // Dog makes sound
        dog.makeSound();

        // Display inherited info
        dog.displayInfo();

        // Close Scanner
        sc.close();
    }
}
