package lab5;

class Shape {

    protected String name;

    public Shape(String name) {
        this.name = name; // Set shape name
    }

    // Default area
    public double calculateArea() {
        return 0.0;
    }
}

class Circle extends Shape {
    protected double radius;

    public Circle(String name, double radius) {
        super(name); // Call parent constructor
        this.radius = radius; // Set radius
    }

    @Override
    public double calculateArea() {
        // Area of circle = πr² (use 3.14159)
        return 3.14159 * radius * radius;
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String name, double width, double height) {
        super(name); // Call parent constructor
        this.width = width; // Set width
        this.height = height; // Set height
    }

    @Override
    public double calculateArea() {
        // Area of rectangle = width * height
        return width * height;
    }
}

public class AreaPolymorphism {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // --- Prompt user ---
        System.out.print("Enter radius for circle: ");

        double radius;
        // Validation #1: numeric check
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid radius. Setting to 0.");
            radius = 0.0;
            sc.nextLine();
        } else {
            radius = sc.nextDouble();
        }
        // Validation #2: non-negative
        if (radius < 0) {
            System.out.println("Negative radius not allowed. Setting to 0.");
            radius = 0.0;
        }

        System.out.print("Enter width for rectangle: ");
        double width;
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid width. Setting to 0.");
            width = 0.0;
            sc.nextLine();
        } else {
            width = sc.nextDouble();
        }
        if (width < 0) {
            System.out.println("Negative width not allowed. Setting to 0.");
            width = 0.0;
        }

        System.out.print("Enter height for rectangle: ");
        double height;
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid height. Setting to 0.");
            height = 0.0;
            sc.nextLine();
        } else {
            height = sc.nextDouble();
        }
        if (height < 0) {
            System.out.println("Negative height not allowed. Setting to 0.");
            height = 0.0;
        }

        // --- Create objects ---
        Circle circle = new Circle("Circle", radius);
        Rectangle rectangle = new Rectangle("Rectangle", width, height);

        // --- Polymorphism array ---
        Shape[] shapes = { circle, rectangle };

        // --- Loop through and print area ---
        for (Shape s : shapes) {
            double area = s.calculateArea();
            System.out.println(s.name + " Area = " + area);
        }

        sc.close();
    }
}