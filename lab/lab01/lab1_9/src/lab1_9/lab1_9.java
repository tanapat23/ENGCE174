package lab1_9;

import java.util.Scanner;

public class lab1_9 {

	public static void main(String[] args) {
		int countN = 0;
		int sum = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (countN <= 0) {
				System.out.print("Please enter the count: ");
				if (sc.hasNextInt()) {
					countN = sc.nextInt();
					if (countN <= 0) {
						System.out.println("N must 0");
					}
				} else {
					System.out.println("Please enter an integer number.");
					sc.next();
				}
			}
			for (int i = 1; i <= countN; i++) {
				int currentNumber = 0;
				boolean validNumber = false;
				while (!validNumber) {
					System.out.print("Enter number " + i + " of " + countN + ": ");

					if (sc.hasNextInt()) {
						currentNumber = sc.nextInt();
						validNumber = true;
					} else {
						System.out.println("Error: Invalid input. Please enter an integer number.");
						sc.next();
					}
				}

				sum += currentNumber;
			}
			double avg = (double) sum / countN;
			System.out.println(countN + " numbers is: " + avg);

		}
	}
}