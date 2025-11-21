package lab1_4;

import java.util.Scanner;

public class lab1_4 {

	public static void main(String[] args) {

		int score = -1;
		String grade = "";

		try (Scanner sc = new Scanner(System.in)) {

			while (score < 0 || score > 100) {
				System.out.print("Please Enter Score (0-100): ");

				if (sc.hasNextInt()) {
					int input = sc.nextInt();

					if (input >= 0 && input <= 100) {
						score = input;
					} else {

						System.out
								.println("Score must be between 0 and 100. You enter " + input + "is not rage jub jub");
					}
				} else {
					System.out.println("Please enter an integer number naja.");
					sc.next();
				}
			}

			if (score >= 80) {
				grade = "A";
			} else if (score >= 70) {
				grade = "B";
			} else if (score >= 60) {
				grade = "C";
			} else if (score >= 50) {
				grade = "D";
			} else { // 0-49
				grade = "F";
			}

			System.out.println("Grade is: " + grade);

		}
	}
}