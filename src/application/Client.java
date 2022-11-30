package application;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends People {

	private String carsOwned = "==========\n";

	private String carsOwnedCSV = "==========-";

	private int nbCarsOwned = 0;

	public static ArrayList<Client> People_Clients = new ArrayList<>(1);

	public static int clientCounter = 0; // total client number

	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();

	public Client() {
	}

	public Client(String fName, String lName, int age, int tel, String address,
			String ID) { // constructor uses People
							// class
		super(fName, lName, age, address, tel, ID);
	}

	public Client(String fname, String lname, int age, String address, int tel,
			String id, int nbCarsOwned, String carsOwned,
			String carsOwnedForNextCSVSave) {
		firstName = fname;
		lastName = lname;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.id = id;
		this.nbCarsOwned = nbCarsOwned;
		this.carsOwned = carsOwned;
		this.carsOwnedCSV = carsOwnedForNextCSVSave;
		clientCounter++;
		telAvailable.add(String.valueOf(tel));
	}

	public void addClient(Client newClient) {
		People_Clients.add(newClient);
		clientCounter++;
	}

	public String getCarsOwned() {
		return this.carsOwned;
	}

	public String getCarsOwnedCSV() {
		return this.carsOwnedCSV;
	}

	public int getNbCarsOwned() {
		return this.nbCarsOwned;
	}

	public void deleteAllClients() {
		String answer;

		do {

			if (clientCounter != 0) {
				System.out.println(
						"Are you sure you want to clear all clients ? (yes/no)");
				answer = cin.nextLine();

				if (answer.equalsIgnoreCase("yes")) {
					for (int i = 0; i < clientCounter; i++) {
						telAvailable.remove(
								getTelID(People_Clients.get(0).getTel()));
						People_Clients.remove(0); // everytime you delete an
													// object in arraylist, the
													// objects inside are
													// rearranged (element nb 1
													// is now nb 0)
					}
					clientCounter = 0;
				}
				if (answer.equalsIgnoreCase("no")) {
					break;
				}
			} else {
				System.out.println("You don't have any clients to delete");
				break;
			}

		} while (!answer.equalsIgnoreCase("yes")
				&& !answer.equalsIgnoreCase("no"));
	}

	public void displayClients() {
		if (clientCounter != 0) {
			System.out.printf("%1s %13s %19s %13s %21s %15s %29s\n",
					"Client number", "Full name", "Age", "Address", "Tel", "ID",
					"Cars owned");

			for (int i = 0; i < People_Clients.size(); i++) {
				People_Clients.get(i).tableDisplayClients(i);
			}
		} else {
			System.out.println("No clients found");
		}
	}

	public void tableDisplayClients(int i) {
		System.out.printf("%-17d %-25s %-9d %-25s %-16s %-21s %d\n", (i + 1),
				People_Clients.get(i).getFullName(),
				People_Clients.get(i).getAge(),
				People_Clients.get(i).getAddress(),
				countryCode + " " + People_Clients.get(i).getTel(),
				People_Clients.get(i).getId(),
				People_Clients.get(i).nbCarsOwned);
	}

	public String createClientID(String fName, String lName, int tel) {
		String stringTel = String.valueOf(tel); // converts int into String
		String ID = fName.substring(0, 2)
				+ lName.substring((lName.length()) - 2) + "@client" + stringTel;
		return ID;
	}

	public int searchClient() {

		if (clientCounter != 0) {
			Scanner cin = new Scanner(System.in);
			String fullName;
			int[] matchingClients = new int[clientCounter];
			int matchingClientsCounter = 0;
			int iCopy = 0; // Takes position of client in clients array

			do {
				System.out.print("Enter client full name ( Exit to return ): ");
				fullName = cin.nextLine();

				while (InputChecker.stringChecker(fullName)) {
					System.out.print(
							"Input contains unsupported characters type again:");
					fullName = cin.nextLine();
				}

				for (int i = 0; i < clientCounter; i++) {
					if (fullName.equalsIgnoreCase(
							People_Clients.get(i).getFullName())) {
						matchingClients[matchingClientsCounter] = i;
						matchingClientsCounter++;
						iCopy = i;
					}
				}

			} while (matchingClientsCounter == 0
					&& !fullName.equalsIgnoreCase("exit"));

			if (matchingClientsCounter > 1) { // If found more than one client
				for (int i = 0; i < matchingClientsCounter; i++) {
					System.out.println(People_Clients.get(matchingClients[i])
							.toString(matchingClients[i]));
				}
				// If more than 1 client was found, search by id
				System.out.print(
						"Please enter client Id to search for the specific client you want: ");
				String searchID = cin.nextLine();

				for (int i = 0; i < clientCounter; i++) { // If if matches a
															// client copy i
															// value
					if (searchID.toLowerCase()
							.equalsIgnoreCase(People_Clients.get(i).getId())) {
						matchingClientsCounter = 1; // resets for next if case
						iCopy = i;
						break;
					}
				}
			}
			if (matchingClientsCounter == 1) {
				System.out.println("Client Found!");
				return iCopy;
			}

			if (matchingClientsCounter == 0
					&& !fullName.equalsIgnoreCase("exit")) {
				return -1; // if specific client wasn't found
			}
			if (fullName.equalsIgnoreCase("exit")) {
				return -3; // to go back where exit is entered
			}
		}
		return -2; // if no clients were found at all
	}

	public void addCarsToClient(String brand, int carID, int clientNB) { // remember
																			// to
																			// do
																			// -1
																			// in
																			// main
		Cars.carNotFound = false;
		String date = Date.getDate();
		switch (brand.toLowerCase()) {
			case "bmw" -> {
				if (BMW.counterBMW != 0) {
					Transaction.lotteryDiscount(brand, carID - 1);

					double priceAfterTax = BMW.BMWCars.get(carID - 1).getPrice()
							+ BMW.BMWCars.get(carID - 1).getPrice() * 0.11; // saving
																			// the
																			// price
																			// after
																			// tax
					double priceAfterDiscount = priceAfterTax - priceAfterTax
							* ((double) BMW.BMWCars.get(carID - 1).getDiscount()
									/ 100); // saving final
											// price

					People_Clients.get(clientNB).carsOwned += BMW.BMWCars
							.get(carID - 1).toString()
							+ Transaction.receipt(brand, carID - 1) + "\n"
							+ date + "\n\n";
					People_Clients.get(clientNB).carsOwnedCSV += "brand: "
							+ BMW.BMWCars.get(carID - 1).getBrand() + "-"
							+ "Color: " + BMW.BMWCars.get(carID - 1).getColor()
							+ "-" + "Number of doors: "
							+ String.valueOf(
									BMW.BMWCars.get(carID - 1).getNbOfDoors())
							+ "-" + "Price: "
							+ String.valueOf(fmt1.format(
									BMW.BMWCars.get(carID - 1).getPrice()))
							+ "-" + "Discount: "
							+ String.valueOf(
									BMW.BMWCars.get(carID - 1).getDiscount())
							+ "-" + "==========" + "-" + "Original Price: "
							+ fmt1.format(BMW.BMWCars.get(carID - 1).getPrice())
							+ "-" + "Price after Tax: "
							+ fmt1.format(priceAfterTax) + "-" + "Discount: "
							+ BMW.BMWCars.get(carID - 1).getDiscount() + "%"
							+ "-" + "Final price to pay: "
							+ fmt1.format(priceAfterDiscount) + "-" + date
							+ "-";

					nbCarsOwned++;
					Cars.deleteCar(brand, carID);
				} else {
					System.out.println("BMW's are out of stock.");
					Cars.carNotFound = true;
				}
			}
			case "toyota" -> {
				if (Toyota.counterToyota != 0) {
					Transaction.lotteryDiscount(brand, carID - 1);

					double priceAfterTax = Toyota.ToyotaCars.get(carID - 1)
							.getPrice()
							+ Toyota.ToyotaCars.get(carID - 1).getPrice()
									* 0.11; // saving the price after tax
					double priceAfterDiscount = priceAfterTax
							- priceAfterTax * ((double) Toyota.ToyotaCars
									.get(carID - 1).getDiscount() / 100);

					People_Clients.get(clientNB).carsOwned += Toyota.ToyotaCars
							.get(carID - 1).toString()
							+ Transaction.receipt(brand, carID - 1) + "\n"
							+ date + "\n\n";
					People_Clients.get(clientNB).carsOwnedCSV += "brand: "
							+ Toyota.ToyotaCars.get(carID - 1).getBrand() + "-"
							+ "Color: "
							+ Toyota.ToyotaCars.get(carID - 1).getColor() + "-"
							+ "Number of doors: "
							+ String.valueOf(Toyota.ToyotaCars
									.get(carID - 1).getNbOfDoors())
							+ "-" + "Price: "
							+ String.valueOf(fmt1.format(Toyota.ToyotaCars
									.get(carID - 1).getPrice()))
							+ "-" + "Discount: "
							+ String.valueOf(Toyota.ToyotaCars.get(carID - 1)
									.getDiscount())
							+ "-" + "==========" + "-" + "Original Price: "
							+ fmt1.format(
									Toyota.ToyotaCars.get(carID - 1).getPrice())
							+ "-" + "Price after Tax: "
							+ fmt1.format(priceAfterTax) + "-" + "Discount: "
							+ Toyota.ToyotaCars.get(carID - 1).getDiscount()
							+ "%" + "-" + "Final price to pay: "
							+ fmt1.format(priceAfterDiscount) + "-" + date
							+ "-";

					nbCarsOwned++;
					Cars.deleteCar(brand, carID);
				} else {
					System.out.println("Toyota's are out of stock.");
					Cars.carNotFound = true;
				}
			}
			case "ferrari" -> {
				if (Ferrari.counterFerrari != 0) {
					Transaction.lotteryDiscount(brand, carID - 1);

					double priceAfterTax = Ferrari.FerrariCars.get(carID - 1)
							.getPrice()
							+ Ferrari.FerrariCars.get(carID - 1).getPrice()
									* 0.11; // saving the price after tax
					double priceAfterDiscount = priceAfterTax
							- priceAfterTax * ((double) Ferrari.FerrariCars
									.get(carID - 1).getDiscount() / 100);

					People_Clients
							.get(clientNB).carsOwned += Ferrari.FerrariCars
									.get(carID - 1).toString()
									+ Transaction.receipt(brand, carID - 1)
									+ "\n" + date + "\n\n";
					People_Clients.get(clientNB).carsOwnedCSV += "brand: "
							+ Ferrari.FerrariCars.get(carID - 1).getBrand()
							+ "-" + "Color: "
							+ Ferrari.FerrariCars.get(carID - 1).getColor()
							+ "-" + "Number of doors: "
							+ String.valueOf(Ferrari.FerrariCars
									.get(carID - 1).getNbOfDoors())
							+ "-" + "Price: "
							+ String.valueOf(fmt1.format(Ferrari.FerrariCars
									.get(carID - 1).getPrice()))
							+ "-" + "Discount: "
							+ String.valueOf(Ferrari.FerrariCars.get(carID - 1)
									.getDiscount())
							+ "-" + "==========" + "-" + "Original Price: "
							+ fmt1.format(Ferrari.FerrariCars.get(carID - 1)
									.getPrice())
							+ "-" + "Price after Tax: "
							+ fmt1.format(priceAfterTax) + "-" + "Discount: "
							+ Ferrari.FerrariCars.get(carID - 1).getDiscount()
							+ "%" + "-" + "Final price to pay: "
							+ fmt1.format(priceAfterDiscount) + "-" + date
							+ "-";

					nbCarsOwned++;
					Cars.deleteCar(brand, carID);
				} else {
					System.out.println("Ferrari's are out of stock.");
					Cars.carNotFound = true;
				}
			}
			case "nissan" -> {
				if (Nissan.counterNissan != 0) {
					Transaction.lotteryDiscount(brand, carID - 1);

					double priceAfterTax = Nissan.NissanCars.get(carID - 1)
							.getPrice()
							+ Nissan.NissanCars.get(carID - 1).getPrice()
									* 0.11; // saving the price after tax
					double priceAfterDiscount = priceAfterTax
							- priceAfterTax * ((double) Nissan.NissanCars
									.get(carID - 1).getDiscount() / 100);

					People_Clients.get(clientNB).carsOwned += Nissan.NissanCars
							.get(carID - 1).toString()
							+ Transaction.receipt(brand, carID - 1) + "\n"
							+ date + "\n\n";
					People_Clients.get(clientNB).carsOwnedCSV += "brand: "
							+ Nissan.NissanCars.get(carID - 1).getBrand() + "-"
							+ "Color: "
							+ Nissan.NissanCars.get(carID - 1).getColor() + "-"
							+ "Number of doors: "
							+ String.valueOf(Nissan.NissanCars
									.get(carID - 1).getNbOfDoors())
							+ "-" + "Price: "
							+ String.valueOf(fmt1.format(Nissan.NissanCars
									.get(carID - 1).getPrice()))
							+ "-" + "Discount: "
							+ String.valueOf(Nissan.NissanCars.get(carID - 1)
									.getDiscount())
							+ "-" + "==========" + "-" + "Original Price: "
							+ fmt1.format(
									Nissan.NissanCars.get(carID - 1).getPrice())
							+ "-" + "Price after Tax: "
							+ fmt1.format(priceAfterTax) + "-" + "Discount: "
							+ Nissan.NissanCars.get(carID - 1).getDiscount()
							+ "%" + "-" + "Final price to pay: "
							+ fmt1.format(priceAfterDiscount) + "-" + date
							+ "-";

					nbCarsOwned++;
					Cars.deleteCar(brand, carID);
				} else {
					System.out.println("Nissan's are out of stock.");
					Cars.carNotFound = true;
				}
			}
			case "audi" -> {
				if (Audi.counterAudi != 0) {
					Transaction.lotteryDiscount(brand, carID - 1);

					double priceAfterTax = Audi.AudiCars.get(carID - 1)
							.getPrice()
							+ Audi.AudiCars.get(carID - 1).getPrice() * 0.11; // saving
																				// the
																				// price
																				// after
																				// tax
					double priceAfterDiscount = priceAfterTax
							- priceAfterTax * ((double) Audi.AudiCars
									.get(carID - 1).getDiscount() / 100);

					People_Clients.get(clientNB).carsOwned += Audi.AudiCars
							.get(carID - 1).toString()
							+ Transaction.receipt(brand, carID - 1) + "\n"
							+ date + "\n\n";
					People_Clients.get(clientNB).carsOwnedCSV += "brand: "
							+ Audi.AudiCars.get(carID - 1).getBrand() + "-"
							+ "Color: "
							+ Audi.AudiCars.get(carID - 1).getColor() + "-"
							+ "Number of doors: "
							+ String.valueOf(
									Audi.AudiCars.get(carID - 1).getNbOfDoors())
							+ "-" + "Price: "
							+ String.valueOf(fmt1.format(
									Audi.AudiCars.get(carID - 1).getPrice()))
							+ "-" + "Discount: "
							+ String.valueOf(
									Audi.AudiCars.get(carID - 1).getDiscount())
							+ "-" + "==========" + "-" + "Original Price: "
							+ fmt1.format(
									Audi.AudiCars.get(carID - 1).getPrice())
							+ "-" + "Price after Tax: "
							+ fmt1.format(priceAfterTax) + "-" + "Discount: "
							+ Audi.AudiCars.get(carID - 1).getDiscount() + "%"
							+ "-" + "Final price to pay: "
							+ fmt1.format(priceAfterDiscount) + "-" + date
							+ "-";

					nbCarsOwned++;
					Cars.deleteCar(brand, carID);
				} else {
					System.out.println("Audi's are out of stock.");
					Cars.carNotFound = true;
				}
			}
			default -> {
				Cars.carNotFound = true;
				System.out.println("We don't sell this car here.");
			}
		}
	}

	public String toString(int i) {
		return "==========\nClient number " + (i + 1) // d
				+ "\nFull name: " + People_Clients.get(i).getFullName() // s
				+ "\nAge: " + People_Clients.get(i).getAge() // d
				+ "\nAddress: " + People_Clients.get(i).getAddress() // s
				+ "\nTel: " + countryCode + " " + People_Clients.get(i).getTel() // d
				+ "\nID: " + People_Clients.get(i).getId() // s
				+ "\nCars owned:\n" + People_Clients.get(i).carsOwned // s
				+ "\n";
	}
}