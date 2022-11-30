package application;

import java.util.Scanner;

public class InputChecker { // not from google ;)

	public static int nbIntChecker() {
		Scanner cin = new Scanner(System.in);
		int nb = 0;

		if (cin.hasNextInt()) {
			nb = cin.nextInt();
			cin.nextLine();
		} else {
			boolean inputIsInt = false;

			while (!inputIsInt) {
				cin.nextLine(); // Clears any previous numbers in buffer even
								// ones before while case
				System.out.println("Error please enter a number");

				inputIsInt = cin.hasNextInt(); // Puts number in buffer and
												// returns true or false
				// (if true it enters in "if case" and if false it just re-does
				// "while")

				if (inputIsInt) {
					nb = cin.nextInt(); // This copies the number in the buffer
				}
			}
			cin.nextLine();
		}
		return nb;
	}

	public static boolean stringChecker(String stringToCheck) {

		boolean containsSpecial = true;

		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

		if (stringToCheck.isEmpty() || stringToCheck
				.substring(stringToCheck.length() - 1).equalsIgnoreCase(" ")
				|| stringToCheck.length() < 2) {
			return containsSpecial;
		}

		for (int i = 0; i < stringToCheck.length(); i++) {

			char ch = stringToCheck.charAt(i);
			if (specialCharactersString.contains(Character.toString(ch)) // doesn't
																			// allow
																			// special
																			// characters
					|| stringToCheck.substring(0, 1).equalsIgnoreCase(" ") // doesn't
																			// allow
																			// space
																			// in
																			// start
					|| Character.isDigit(ch)) { // doesn't allow digits

				return containsSpecial;

			} else if (i == stringToCheck.length() - 1) {
				return !containsSpecial;
			}
		}
		return !containsSpecial;
	}

	public static boolean addressStringChecker(String stringToCheck) {

		boolean containsSpecial = true;

		String specialCharactersString = "!@#$%&*+-;<=>?[]^{|}";

		if (stringToCheck.isEmpty() || stringToCheck
				.substring(stringToCheck.length() - 1).equalsIgnoreCase(" ")
				|| stringToCheck.length() < 5) {
			return containsSpecial;
		}

		for (int i = 0; i < stringToCheck.length(); i++) {

			char ch = stringToCheck.charAt(i);
			if (specialCharactersString.contains(Character.toString(ch))
					|| stringToCheck.substring(0, 1).equalsIgnoreCase(" ")) {
				return containsSpecial;
			} else if (i == stringToCheck.length() - 1) {
				return !containsSpecial;
			}
		}
		return !containsSpecial;
	}
}
