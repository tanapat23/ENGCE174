package lab1_5;

import java.util.Scanner;

public class lab1_5 {

	public static void main(String[] args) {
		int number = 0;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Please enter Menu Number (1-4): ");
			if (sc.hasNextInt()) {
				number = sc.nextInt();
			} else {
				System.out.println("Please Enter Number 1 - 4 naja is not number na");
			}
		}
		String selectedMenu;
		switch (number) {
		case 1:
			selectedMenu = "Americano";
			break;
		case 2:
			selectedMenu = "Latte";
			break;
		case 3:
			selectedMenu = "Espresso";
			break;
		case 4:
			selectedMenu = "Mocha";
			break;
		default:
			selectedMenu = "Invalid Menu";
			break;
		}

		System.out.println("Your selection is: " + selectedMenu);
	}
}