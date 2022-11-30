package application;

import java.text.NumberFormat;
import java.util.Scanner;

public class Cars {
	protected String brand;
	protected String color;
	protected int nbOfDoors;
	public double price;
	public int discount;
	public static int totalCars = 0;
	public static boolean carNotFound;
	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
	NumberFormat fmt2 = NumberFormat.getPercentInstance();

	static Scanner cin = new Scanner(System.in);

	public Cars() {
	}

	public Cars(String brand, String color, int nbOfDoors) { // Constructor
		switch (brand.toLowerCase()) {
			case "bmw" -> {
				if (BMW.counterBMW != 4) {
					this.brand = brand;
					this.color = color;
					this.nbOfDoors = nbOfDoors;
					this.price = Transaction.autoSetPrices(brand, nbOfDoors);
				}
			}
			case "ferrari" -> {
				if (Ferrari.counterFerrari != 4) {
					this.brand = brand;
					this.color = color;
					this.nbOfDoors = nbOfDoors;
					this.price = Transaction.autoSetPrices(brand, nbOfDoors);
				}
			}
			case "nissan" -> {
				if (Nissan.counterNissan != 4) {
					this.brand = brand;
					this.color = color;
					this.nbOfDoors = nbOfDoors;
					this.price = Transaction.autoSetPrices(brand, nbOfDoors);
				}
			}
			case "audi" -> {
				if (Audi.counterAudi != 4) {
					this.brand = brand;
					this.color = color;
					this.nbOfDoors = nbOfDoors;
					this.price = Transaction.autoSetPrices(brand, nbOfDoors);
				}
			}
			case "toyota" -> {
				if (Toyota.counterToyota != 4) {
					this.brand = brand;
					this.color = color;
					this.nbOfDoors = nbOfDoors;
					this.price = Transaction.autoSetPrices(brand, nbOfDoors);
				}
			}
		}

	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public int getNbOfDoors() {
		return nbOfDoors;
	}

	public String createColor() {
		String color;
		int counter = 0;

		do {
			if (counter > 0) {
				System.out.println("Color Unavailable!");
			}

			System.out.print("Enter color (White/Black/Silver/Red): ");
			color = cin.nextLine();

			counter++;

		} while (!color.equalsIgnoreCase("White") // Only allowed colors are
													// these 4
				&& !color.equalsIgnoreCase("Black")
				&& !color.equalsIgnoreCase("Silver")
				&& !color.equalsIgnoreCase("Red"));

		return color; // returns color to main to put it in a string and then
						// use it in the
						// constructor
	}

	public int createNbOfDoors() {
		int nbDoors, counter = 0;

		do {
			if (counter > 0) {
				System.out.println("You can only have 4 or 2 doors!");
			}

			System.out.print("Enter number of doors (2/4): ");
			nbDoors = InputChecker.nbIntChecker();

			counter++;

		} while (nbDoors != 2 && nbDoors != 4);
		return nbDoors;// returns number of doors to main to put it in an int
						// and then use it in the
						// constructor
	}

	public static String verifyBrand(boolean allowExit) { // l nb iz for the ifs
															// inside because
															// one can "exit"
															// and the
															// other can't.
		String brand;
		carNotFound = false;

		Cars.displayCars();

		do {
			if (carNotFound) {
				System.out.println("\nCar unavailable or out of stock.");
			}

			if (allowExit) { // for options that you are allowed to exit from
				System.out.print("Enter brand (type \"exit\" to go back): ");
				brand = cin.nextLine();
				Cars.displayByBrand(brand);
			} else { // for options that you can't exit from
				do {
					System.out.print("Enter brand: ");
					brand = cin.nextLine();
					Cars.displayByBrand(brand); // if brand not found
												// Cars.carNotFound becomes true
				} while (carNotFound);
			}

		} while (carNotFound && !brand.equalsIgnoreCase("exit"));
		return brand;
	}

	public double getPrice() {
		return this.price;
	}

	public int getDiscount() {
		return this.discount;
	}

	public static void deleteCar(String keyWord, int delID) {
		int realDelID = delID - 1; // id(in array) of car to be deleted
		// Deleting the specific car
		switch (keyWord.toLowerCase()) {
			case "bmw" -> {
				BMW.BMWCars.remove(realDelID);
				BMW.counterBMW--;
				totalCars--;
			}
			case "toyota" -> {
				Toyota.ToyotaCars.remove(realDelID);
				Toyota.counterToyota--;
				totalCars--;
			}
			case "ferrari" -> {
				Ferrari.FerrariCars.remove(realDelID);
				Ferrari.counterFerrari--;
				totalCars--;
			}
			case "nissan" -> {
				Nissan.NissanCars.remove(realDelID);
				Nissan.counterNissan--;
				totalCars--;
			}
			case "audi" -> {
				Audi.AudiCars.remove(realDelID);
				Audi.counterAudi--;
				totalCars--;
			}
		}
	}

	public static void displayCars() { // Displays all available cars
		if (totalCars == 0) {
			System.out.println("No cars to display!");
		} else {
			if (BMW.counterBMW != 0) {
				// Displaying number of BMW cars
				System.out.println("\n===============\nBMW Cars ("
						+ BMW.counterBMW + "):\n===============");

				displayByBrand("bmw");
			}
			if (Toyota.counterToyota != 0) {
				System.out.println("\n===============\nToyota list ("
						+ Toyota.counterToyota + "):\n===============");

				displayByBrand("toyota");
			}
			if (Ferrari.counterFerrari != 0) {
				System.out.println("\n===============\nFerrari list ("
						+ Ferrari.counterFerrari + "):\n===============");

				displayByBrand("ferrari");
			}
			if (Nissan.counterNissan != 0) {
				System.out.println("\n===============\nNissan list ("
						+ Nissan.counterNissan + "):\n===============");

				displayByBrand("nissan");
			}
			if (Audi.counterAudi != 0) {
				System.out.println("\n===============\nAudi list ("
						+ Audi.counterAudi + "):\n===============");

				displayByBrand("audi");
			}
		}
	}

	public static void displayByBrand(String brand) {
		carNotFound = false;
		switch (brand.toLowerCase()) {
			case "bmw" -> {
				if (BMW.counterBMW > 0) {
					System.out.printf("%-5s %7s %19s %7s %17s\n", "CarID",
							"Color", "Number of doors", "Price", "Discount");
					for (int i = 0; i < BMW.counterBMW; i++) {
						BMW.BMWCars.get(i).tableDisplayCars(i);
						// Displays all cars of same brand in a table
					}
				} else
					carNotFound = true;
			}
			case "ferrari" -> {
				if (Ferrari.counterFerrari > 0) {
					System.out.printf("%-5s %7s %19s %7s %17s\n", "CarID",
							"Color", "Number of doors", "Price", "Discount");

					for (int i = 0; i < Ferrari.counterFerrari; i++) {
						Ferrari.FerrariCars.get(i).tableDisplayCars(i);
						// ~
					}
				} else
					carNotFound = true;
			}
			case "audi" -> {
				if (Audi.counterAudi > 0) {
					System.out.printf("%-5s %7s %19s %7s %17s\n", "CarID",
							"Color", "Number of doors", "Price", "Discount");

					for (int i = 0; i < Audi.counterAudi; i++) {
						Audi.AudiCars.get(i).tableDisplayCars(i);
						// ~
					}
				} else
					carNotFound = true;

			}
			case "nissan" -> {
				if (Nissan.counterNissan > 0) {
					System.out.printf("%-5s %7s %19s %7s %17s\n", "CarID",
							"Color", "Number of doors", "Price", "Discount");

					for (int i = 0; i < Nissan.counterNissan; i++) {
						Nissan.NissanCars.get(i).tableDisplayCars(i);
						// ~
					}
				} else
					carNotFound = true;
			}
			case "toyota" -> {
				if (Toyota.counterToyota > 0) {
					System.out.printf("%-5s %7s %19s %7s %17s\n", "CarID",
							"Color", "Number of doors", "Price", "Discount");

					for (int i = 0; i < Toyota.counterToyota; i++) {
						Toyota.ToyotaCars.get(i).tableDisplayCars(i);
						// ~
					}
				} else
					carNotFound = true;
			}
			default -> {
				carNotFound = true;
			}
		}
	}

	public void tableDisplayCars(int i) {
		System.out.printf("%-7d %-16s %-10d %-17s %d%%\n", (i + 1), color,
				nbOfDoors, fmt1.format(price), discount);
	}

	public static int enterCarID(String brand) {
		int carID;

		do {
			System.out.print("Enter Car ID: ");
			carID = InputChecker.nbIntChecker();

		} while (Cars.carIDChecker(brand, carID));
		return carID;
	}

	public static boolean carIDChecker(String brand, int ID) {
		boolean carIDNotFound = false;

		switch (brand) {
			case "bmw" -> {
				if (ID > BMW.counterBMW || ID <= 0) {
					carIDNotFound = true;// return true because its used in
											// while(...&...)
				}
			}
			case "ferrari" -> {
				if (ID > Ferrari.counterFerrari || ID <= 0) {
					carIDNotFound = true;
				}
			}
			case "audi" -> {
				if (ID > Audi.counterAudi || ID <= 0) {
					carIDNotFound = true;
				}
			}
			case "nissan" -> {
				if (ID > Nissan.counterNissan || ID <= 0) {
					carIDNotFound = true;
				}
			}
			case "toyota" -> {
				if (ID > Toyota.counterToyota || ID <= 0) {
					carIDNotFound = true;
				}
			}
		}
		return carIDNotFound;
	}

	public String toString(int i) {
		return "Car ID: " + (i + 1) + "\nColor: " + color
				+ "\nNumber of doors: " + nbOfDoors + "\nPrice: "
				+ fmt1.format(price) + "\nDiscount: " + discount
				+ "\n==========\n";
	}
}