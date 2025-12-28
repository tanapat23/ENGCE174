package lab5;

class Animal {

    protected String name;
    protected int age;

    // Default sound of generic animal
    public void makeSound() {
        System.out.println("I am an animal.");
    }

    // Display animal information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Cat extends Animal {

    // Override animal sound
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class AnimalSoundsOverride {
    public static void main(String[] args) {

        // Create Scanner
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Prompt user for name
        System.out.print("Enter cat name: ");
        String name = sc.nextLine();

        // Prompt user for age
        System.out.print("Enter cat age: ");
        int age;

        // Validation #1: Ensure integer
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

        // Create Cat object
        Cat cat = new Cat();

        // Assign inherited attributes
        cat.name = name;
        cat.age = age;

        // Display cat info (inherited method)
        cat.displayInfo();

        // Call overridden sound method
        cat.makeSound();

        // Close Scanner
        sc.close();
    }
}
