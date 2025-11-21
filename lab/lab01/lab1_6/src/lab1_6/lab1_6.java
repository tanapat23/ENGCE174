package lab1_6;

import java.util.Scanner;

public class lab1_6 {

	public static void main(String[] args) {
		int tableNumber;
		boolean validInput = false;
		try (Scanner scanner = new Scanner(System.in)) {
			while (!validInput) {
				System.out.print("Please Enter Number: ");

				if (scanner.hasNextInt()) {
					tableNumber = scanner.nextInt();
					validInput = true;
					for (int multiplier = 1; multiplier <= 12; multiplier++) {
						int result = tableNumber * multiplier;
						System.out.println(tableNumber + " x " + multiplier + " = " + result);
					}
				} else {
					System.out.println("Please Enter Intreger Number For Times Table");
					scanner.next();
				}
			}

		}
	}
}