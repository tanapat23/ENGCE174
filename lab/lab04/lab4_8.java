package lab4;

// This program demonstrates constructor chaining with validation rules
// Student-style comments included for clarity

import java.util.Scanner;

class Movie {

    private String title;
    private String director;
    private double rating;

    // Constructor 1: receives only title
    public Movie(String title) {
        // Calling constructor 2 with default director "Unknown"
        this(title, "Unknown");
    }

    // Constructor 2: receives title and director
    public Movie(String title, String director) {
        // Calling constructor 3 with default rating 0.0
        this(title, director, 0.0);
    }

    // Constructor 3: main constructor with validation
    public Movie(String title, String director, double rating) {

        // Validation #1: title should not be empty
        if (title.trim().isEmpty()) {
            System.out.println("Warning: Empty title replaced with 'Untitled'.");
            title = "Untitled";
        }

        // Validation #2: rating must be between 0 and 10
        if (rating > 10.0) {
            System.out.println("Warning: Rating too high. Set to 10.0.");
            rating = 10.0;
        } else if (rating < 0.0) {
            System.out.println("Warning: Rating too low. Set to 0.0.");
            rating = 0.0;
        }

        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    // Method to display movie details
    public void displayDetails() {
        System.out.printf("Title: %s, Director: %s, Rating: %.1f%n",
                title, director, rating);
    }
}

public class MovieInfo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter mode (1, 2, or 3): ");
        int mode = sc.nextInt();
        sc.nextLine();
        // clear buffer

        Movie mv;

        if (mode == 1) {
            System.out.print("Enter movie title: ");
            String t = sc.nextLine();
            mv = new Movie(t);

        } else if (mode == 2) {
            System.out.print("Enter movie title: ");
            String t = sc.nextLine();
            System.out.print("Enter director name: ");
            String d = sc.nextLine();
            mv = new Movie(t, d);

        } else if (mode == 3) {
            System.out.print("Enter movie title: ");
            String t = sc.nextLine();
            System.out.print("Enter director name: ");
            String d = sc.nextLine();
            System.out.print("Enter rating (0.0 - 10.0): ");
            double r = sc.nextDouble();
            mv = new Movie(t, d, r);

        } else {
            System.out.println("Invalid mode! Using default values.");
            mv = new Movie("Untitled");
        }

        mv.displayDetails();

        sc.close();
        // close scanner properly
    }
}