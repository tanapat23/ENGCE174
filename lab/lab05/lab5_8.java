package lab5;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name; // Store name
    }

    public String getStatus() {
        return "Person: " + name; // Default status
    }
}

class Student extends Person {
    protected int studentId;

    public Student(String name, int studentId) {
        super(name); // Call parent constructor
        this.studentId = studentId; // Store student ID
    }

    @Override
    public String getStatus() {
        // Return student information
        return "Student: " + name + ", ID: " + studentId;
    }
}

class Employee extends Person {
    protected double salary;

    public Employee(String name, double salary) {
        super(name); // Call parent constructor
        this.salary = salary;
    }

    public void applyBonus(double bonus) {
        // Add bonus to salary
        salary += bonus;
    }

    @Override
    public String getStatus() {
        // Return employee status
        return "Employee: " + name + ", Salary: " + salary;
    }
}

public class BonusDownCasting {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ---------------- INPUT: STUDENT ----------------
        System.out.print("Enter student name: ");
        String sName = sc.nextLine();

        System.out.print("Enter student ID: ");
        int sId;

        // Validation #1: integer check
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID. Setting to 0.");
            sId = 0;
            sc.nextLine();
        } else {
            sId = sc.nextInt();
        }

        // Validation #2: non-negative
        if (sId < 0) {
            System.out.println("Negative ID not allowed. Setting to 0.");
            sId = 0;
        }

        sc.nextLine(); // clear buffer

        // ---------------- INPUT: EMPLOYEE ----------------
        System.out.print("Enter employee name: ");
        String eName = sc.nextLine();

        System.out.print("Enter employee salary: ");
        double eSalary;

        // Validation #1: numeric check
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid salary. Setting to 0.");
            eSalary = 0.0;
            sc.nextLine();
        } else {
            eSalary = sc.nextDouble();
        }

        // Validation #2: non-negative
        if (eSalary < 0) {
            System.out.println("Negative salary not allowed. Setting to 0.");
            eSalary = 0.0;
        }

        // ---------------- OBJECT CREATION ----------------
        Student stu = new Student(sName, sId);
        Employee emp = new Employee(eName, eSalary);

        // Parent array
        Person[] list = { stu, emp };

        // ---------------- APPLY BONUS USING instanceof ----------------
        for (Person p : list) {
            // Check if object is employee
            if (p instanceof Employee) {
                // Downcast to Employee
                Employee em = (Employee) p;
                em.applyBonus(1000.0); // Add bonus
            }
        }

        // ---------------- DISPLAY STATUS ----------------
        for (Person p : list) {
            System.out.println(p.getStatus()); // Polymorphism
        }

        sc.close();
    }
}
