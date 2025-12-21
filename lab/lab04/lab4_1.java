package lab4;

import java.util.Scanner;

class Book {

    private String title;
    private String author;

    // Constructor #1
    public Book(String title) {
        this.title = validateTitle(title);
        this.author = "Unknown";
    }

    // Constructor #2
    public Book(String title, String author) {
        this.title = validateTitle(title);
        this.author = author;
    }

    private String validateTitle(String t) {
        if (t == null || t.trim().isEmpty()) {
            return "Untitled";
        }
        return t;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class BookInfo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter mode (1 or 2): ");
        int mode = Integer.parseInt(sc.nextLine());

        Book myBook = null;

        if (mode == 1) {
            System.out.print("Enter title: ");
            String title = sc.nextLine();

            myBook = new Book(title);

        } else if (mode == 2) {
            System.out.print("Enter title: ");
            String title = sc.nextLine();

            System.out.print("Enter author: ");
            String author = sc.nextLine();

            myBook = new Book(title, author);
        }

        if (myBook != null) {
            myBook.displayInfo();
        }
    }
}
