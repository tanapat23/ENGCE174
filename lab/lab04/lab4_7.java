package lab4;
// This program demonstrates how JVM garbage collection may call finalize().

// Includes 2 simple validations:
// 1) If ID is empty → replace with "UNKNOWN"
// 2) Warn if ID length > 20

import java.util.Scanner;

class Resource {

    private String id;

    public Resource(String id) {

        if (id.trim().isEmpty()) {
            System.out.println("Warning: Empty ID replaced with 'UNKNOWN'.");
            id = "UNKNOWN";
        }

        if (id.length() > 20) {
            System.out.println("Warning: ID is unusually long.");
        }

        this.id = id;
        System.out.println("Resource " + id + " created.");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Resource " + id + " finalized (destroyed).");
    }
}

public class MemoryOrganized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID #1: ");
        String id1 = sc.nextLine();

        System.out.print("Enter ID #2: ");
        String id2 = sc.nextLine();

        System.out.print("Enter ID #3: ");
        String id3 = sc.nextLine();

        Resource r1 = new Resource(id1);
        Resource r2 = new Resource(id2);
        Resource r3 = new Resource(id3);

        r1 = null;
        r2 = null;

        System.gc();

        r3 = null;

        System.gc();

        sc.close(); // Properly close Scanner here
    }
}
