package lab4;

// Class representing a geographic location
class Location {

    private double latitude; // store latitude
    private double longitude; // store longitude

    // Main constructor
    public Location(double latitude, double longitude) {
        // basic validation: latitude must be between -90 to 90
        if (latitude < -90 || latitude > 90) {
            this.latitude = 0.0;
        } else {
            this.latitude = latitude;
        }
        this.longitude = longitude;
    }

    // Copy constructor
    public Location(Location other) {
        this.latitude = other.latitude;
        this.longitude = other.longitude;
    }

    // Setter to modify latitude
    public void setLatitude(double newLat) {
        this.latitude = newLat;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Lat: " + latitude + ", Lon: " + longitude);
    }
}

public class CopyLocation {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Prompt before input
        System.out.print("Enter initial latitude: ");
        double lat = sc.nextDouble();

        System.out.print("Enter initial longitude: ");
        double lon = sc.nextDouble();

        System.out.print("Enter new latitude: ");
        double newLat = sc.nextDouble();

        // Create original object
        Location loc1 = new Location(lat, lon);

        // Create copied object
        Location loc2 = new Location(loc1);

        // Modify original object
        loc1.setLatitude(newLat);

        // Display both
        loc1.displayInfo(); // modified
        loc2.displayInfo(); // unchanged copy
    }
}