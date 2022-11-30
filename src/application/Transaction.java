package application;

import java.text.NumberFormat;
import java.util.Random;

public class Transaction {
	static NumberFormat fmt1 = NumberFormat.getCurrencyInstance();

	public Transaction() {
	}

	public static void lotteryDiscount(String brand, int carID) { // Use when
																	// user is
																	// buying a
																	// car
		Random randomUser = new Random();
		Random randomGen = new Random();

		switch (brand.toLowerCase()) {
			case "bmw" -> {
				if (BMW.BMWCars.get(carID).discount == 0) {
					if (randomUser.nextInt(1000) == randomGen.nextInt(1000)) {
						System.out.println(
								"Client has won the lottery discount of 20% !");
						BMW.BMWCars.get(carID).discount = 20;
					}
				}
			}
			case "toyota" -> {
				if (Toyota.ToyotaCars.get(carID).discount == 0) {
					if (randomUser.nextInt(1000) == randomGen.nextInt(1000)) {
						System.out.println(
								"Client has won the lottery discount of 20% !");
						Toyota.ToyotaCars.get(carID).discount = 20;
					}
				}
			}
			case "audi" -> {
				if (Audi.AudiCars.get(carID).discount == 0) {
					if (randomUser.nextInt(1000) == randomGen.nextInt(1000)) {
						System.out.println(
								"Client has won the lottery discount of 20% !");
						Audi.AudiCars.get(carID).discount = 20;
					}
				}
			}
			case "nissan" -> {
				if (Nissan.NissanCars.get(carID).discount == 0) {
					if (randomUser.nextInt(1000) == randomGen.nextInt(1000)) {
						System.out.println(
								"Client has won the lottery discount of 20% !");
						Nissan.NissanCars.get(carID).discount = 20;
					}
				}
			}
			case "ferrari" -> {
				if (Ferrari.FerrariCars.get(carID).discount == 0) {
					if (randomUser.nextInt(1000) == randomGen.nextInt(1000)) {
						System.out.println(
								"Client has won the lottery discount of 20% !");
						Ferrari.FerrariCars.get(carID).discount = 20;
					}
				}
			}
		}
	}

	public static int autoSetPrices(String brand, int nbOfDoors) {
		int price = 0;

		switch (brand.toLowerCase()) {
			case "bmw" -> {
				price = 29900;
				if (nbOfDoors == 2)
					price += price * 0.1; // adds 10%
			}
			case "toyota" -> {
				price = 24500;
				if (nbOfDoors == 2)
					price += price * 0.1; // adds 10%
			}
			case "audi" -> {
				price = 41900;
				if (nbOfDoors == 2)
					price += price * 0.1; // adds 10%
			}
			case "nissan" -> {
				price = 24550;
				if (nbOfDoors == 2)
					price += price * 0.1; // adds 10%
			}
			case "ferrari" -> {
				price = 299000;
				if (nbOfDoors == 2)
					price += price * 0.1; // adds 10%
			}
		}
		return price;
	}

	public void SetPrice() {
		if (Cars.totalCars == 0) {
			System.out.println("No cars available.");
		} else {
			int carID = 0, price;
			String brand;

			do {
				brand = Cars.verifyBrand(true);// true value inside to specify
												// if we are allowed to exit
												// from setting
												// price

				if (!Cars.carNotFound) // If it found a brand match it enters in
										// if
					carID = Cars.enterCarID(brand);

			} while (Cars.carNotFound && !brand.equalsIgnoreCase("exit"));

			carID -= 1; // Specifies position of car in array of cars

			if (!brand.equalsIgnoreCase("exit")) {

				switch (brand.toLowerCase()) {
					case "bmw" -> {
						System.out.println(BMW.BMWCars.get(carID).toString());
						System.out.print("Enter new price: ");
						price = InputChecker.nbIntChecker();
						BMW.BMWCars.get(carID).price = price;
					}
					case "toyota" -> {
						System.out.println(
								Toyota.ToyotaCars.get(carID).toString());
						System.out.print("Enter new price: ");
						price = InputChecker.nbIntChecker();
						Toyota.ToyotaCars.get(carID).price = price;
					}
					case "audi" -> {
						System.out.println(Audi.AudiCars.get(carID).toString());
						System.out.print("Enter new price: ");
						price = InputChecker.nbIntChecker();
						Audi.AudiCars.get(carID).price = price;
					}
					case "nissan" -> {
						System.out.println(
								Nissan.NissanCars.get(carID).toString());
						System.out.print("Enter new price: ");
						price = InputChecker.nbIntChecker();
						Nissan.NissanCars.get(carID).price = price;
					}
					case "ferrari" -> {
						System.out.println(
								Ferrari.FerrariCars.get(carID).toString());
						System.out.print("Enter new price: ");
						price = InputChecker.nbIntChecker();
						Ferrari.FerrariCars.get(carID).price = price;
					}
				}
			} else {
				System.out.println("returning...");
			}
		}
	}

	public void setDiscount() {
		if (Cars.totalCars == 0) {
			System.out.println("No cars available.");
		} else {
			int carID = 0, discount;
			String brand;

			do {
				brand = Cars.verifyBrand(true);//// true value inside to specify
												//// if we are allowed to exit
												//// from setting
												//// discount

				if (!Cars.carNotFound) {// If it found a brand match it enters
										// in if
					carID = Cars.enterCarID(brand);
				}

			} while (Cars.carNotFound && !brand.equalsIgnoreCase("exit"));

			carID -= 1; // for actual car in arrayList

			if (!brand.equalsIgnoreCase("exit")) {

				switch (brand.toLowerCase()) {
					case "bmw" -> {
						System.out.println(BMW.BMWCars.get(carID).toString());

						do {
							System.out.print("Enter discount percentage(%): ");
							discount = InputChecker.nbIntChecker();

						} while (discount < 0 || discount > 100);
						BMW.BMWCars.get(carID).discount = discount;
					}
					case "toyota" -> {
						System.out.println(
								Toyota.ToyotaCars.get(carID).toString());

						do {
							System.out.print("Enter discount percentage(%): ");
							discount = InputChecker.nbIntChecker();

						} while (discount < 0 || discount > 100);
						Toyota.ToyotaCars.get(carID).discount = discount;
					}
					case "audi" -> {
						System.out.println(Audi.AudiCars.get(carID).toString());

						do {
							System.out.print("Enter discount percentage(%): ");
							discount = InputChecker.nbIntChecker();

						} while (discount < 0 || discount > 100);
						Audi.AudiCars.get(carID).discount = discount;
					}
					case "nissan" -> {
						System.out.println(
								Nissan.NissanCars.get(carID).toString());

						do {
							System.out.print("Enter discount percentage(%): ");
							discount = InputChecker.nbIntChecker();

						} while (discount < 0 || discount > 100);
						Nissan.NissanCars.get(carID).discount = discount;
					}
					case "ferrari" -> {
						System.out.println(
								Ferrari.FerrariCars.get(carID).toString());

						do {
							System.out.print("Enter discount percentage(%): ");
							discount = InputChecker.nbIntChecker();

						} while (discount < 0 || discount > 100);
						Ferrari.FerrariCars.get(carID).discount = discount;
					}
				}
			} else {
				System.out.println("returning...");
			}
		}
	}

	public static String receipt(String brand, int ID) {
		int discount = 0;
		double price = 0, priceAfterTax, priceAfterDiscount, tax = 11.0 / 100;

		switch (brand.toLowerCase()) {
			case "bmw" -> {
				discount = BMW.BMWCars.get(ID).discount;
				price = BMW.BMWCars.get(ID).price;
			}
			case "toyota" -> {
				discount = Toyota.ToyotaCars.get(ID).discount;
				price = Toyota.ToyotaCars.get(ID).price;
			}
			case "audi" -> {
				discount = Audi.AudiCars.get(ID).discount;
				price = Audi.AudiCars.get(ID).price;
			}
			case "nissan" -> {
				discount = Nissan.NissanCars.get(ID).discount;
				price = Nissan.NissanCars.get(ID).price;
			}
			case "ferrari" -> {
				discount = Ferrari.FerrariCars.get(ID).discount;
				price = Ferrari.FerrariCars.get(ID).price;
			}
			default -> {

			}
		}
		priceAfterTax = price + price * tax;
		priceAfterDiscount = priceAfterTax
				- priceAfterTax * ((double) discount / 100);

		return "\nOriginal Price: " + fmt1.format(price) + "\nPrice after Tax: "
				+ fmt1.format(priceAfterTax) + "\nDiscount: " + discount + "%"
				+ "\nFinal price to pay: " + fmt1.format(priceAfterDiscount);
	}
}
