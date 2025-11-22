package lab1_11;

import java.util.Scanner;
import java.util.Arrays;

public class lab1_11 {
	public static int sumArray(int[] numbers) {
		int totalSum = 0;
		for (int number : numbers) {
			totalSum += number;
		}

		return totalSum;
	}

	public static void main(String[] args) {

		int countN = 0;
		int[] numbers;

		try (Scanner sc = new Scanner(System.in)) {
			while (countN <= 0) {
				System.out.print("Please enter the count (N): ");
				if (sc.hasNextInt()) {
					countN = sc.nextInt();
					if (countN <= 0) {
						System.out.println("Error: N must be a positive integer.");
					}
				} else {
					System.out.println("Error: Please enter an integer number.");
					sc.next();
				}
			}
			numbers = new int[countN];
			for (int i = 0; i < countN; i++) {
				while (true) {
					System.out.print("Enter number " + (i + 1) + " of " + countN + ": ");

					if (sc.hasNextInt()) {
						numbers[i] = sc.nextInt();
						break;
					} else {
						System.out.println("Error: Invalid input. Please enter an integer number.");
						sc.next();
					}
				}
			}

			int finalSum = sumArray(numbers);
			System.out.println("The total sum of all numbers is: " + finalSum);

		}
	}
}