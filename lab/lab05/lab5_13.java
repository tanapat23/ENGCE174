package lab5;

class User {

    protected String name;

    public User(String name) {
        this.name = name; // Store user name
    }

    public int getClearanceLevel() {
        return 1; // Base clearance level
    }
}

class Developer extends User {

    protected int projects;

    public Developer(String name, int projects) {
        super(name); // Call parent constructor
        this.projects = projects; // Store project count
    }

    @Override
    public int getClearanceLevel() {
        return 2; // Developer clearance level
    }
}

class Admin extends Developer {

    protected String adminKey;

    public Admin(String name, int projects, String adminKey) {
        super(name, projects); // Call Developer constructor
        this.adminKey = adminKey; // Store admin key
    }

    @Override
    public int getClearanceLevel() {
        return 3; // Admin clearance level
    }

    public String getAdminKey() {
        return adminKey; // Return admin key
    }
}

public class SecuritySystem {

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // ---------- INPUT FOR DEVELOPER ----------
        System.out.print("Enter Developer name: ");
        String dName = sc.nextLine();

        System.out.print("Enter Developer project count: ");
        int dProjects = readPositiveInt(sc);

        sc.nextLine(); // clear buffer

        // ---------- INPUT FOR ADMIN ----------
        System.out.print("Enter Admin name: ");
        String aName = sc.nextLine();

        System.out.print("Enter Admin project count: ");
        int aProjects = readPositiveInt(sc);

        sc.nextLine(); // clear buffer

        System.out.print("Enter Admin key: ");
        String aKey = sc.nextLine();

        // ---------- CREATE OBJECTS ----------
        User u1 = new User("Guest"); // Guest user
        Developer d1 = new Developer(dName, dProjects); // Developer input
        Admin a1 = new Admin(aName, aProjects, aKey); // Admin input

        User[] users = { u1, d1, a1 };

        // ---------- SUM CLEARANCE LEVELS ----------
        int totalClearance = 0;

        for (User u : users) {
            totalClearance += u.getClearanceLevel(); // Add clearance
        }

        // ---------- DISPLAY ADMIN KEY (DOWNCASTING) ----------
        for (User u : users) {
            if (u instanceof Admin) {
                Admin adminObj = (Admin) u; // Downcast to Admin
                System.out.println("Admin Key: " + adminObj.getAdminKey());
            }
        }

        // ---------- DISPLAY TOTAL CLEARANCE ----------
        System.out.println("Total Clearance: " + totalClearance);

        sc.close();
    }

    // ========== VALIDATION: POSITIVE INT ==========
    private static int readPositiveInt(java.util.Scanner sc) {
        int v;

        if (!sc.hasNextInt()) {
            System.out.println("Invalid integer. Setting to 0");
            sc.next();
            return 0;
        }

        v = sc.nextInt();

        if (v < 0) {
            System.out.println("Negative not allowed. Setting to 0");
            return 0;
        }

        return v;
    }
}
