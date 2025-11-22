package lab1_12;

import java.util.Scanner;

public class lab1_12 {

	public static void main(String[] args) {

		int N = 0;

		try (Scanner sc = new Scanner(System.in)) {
			N = getValidPositiveInteger(sc, "Enter the number of product types (N): ");
			int[] productIDs = new int[N];
			int[] stockQuantities = new int[N];
			for (int i = 0; i < N; i++) {
				System.out.println("--- Product #" + (i + 1) + " ---");
				productIDs[i] = getValidInteger(sc, "  Enter Product ID: ");
				stockQuantities[i] = getValidInteger(sc, "  Enter Stock Quantity: ");
			}
			int searchID = getValidInteger(sc, "Enter Product ID to search: ");
			findStock(productIDs, stockQuantities, searchID);

		}
	}

	public static void findStock(int[] ids, int[] quantities, int searchID) {
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == searchID) {
				System.out.println("\nResult: " + quantities[i]);
				return;
			}
		}
		System.out.println("\nResult: Product " + searchID + " not found");
	}

	public static int getValidPositiveInteger(Scanner scanner, String prompt) {
		int number = 0;
		while (number <= 0) {
			System.out.print(prompt);
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				if (number <= 0) {
					System.out.println("Error: Must be a positive integer.");
				}
			} else {
				System.out.println("Error: Invalid input. Please enter an integer number.");
				scanner.next();
			}
		}
		return number;
	}

	public static int getValidInteger(Scanner scanner, String prompt) {
		int number = 0;
		while (true) {
			System.out.print(prompt);
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				break;
			} else {
				System.out.println("Error: Invalid input. Please enter an integer number.");
				scanner.next();
			}
		}
		return number;
	}
}