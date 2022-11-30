package application;

import java.util.ArrayList;

public class Toyota extends Cars {
	public static ArrayList<Toyota> ToyotaCars = new ArrayList<>(4);
	public static int counterToyota = 0;

	public Toyota() {
	}

	public Toyota(String brand, String color, int nbOfDoors) {
		super(brand, color, nbOfDoors);
	}

	public void addToyota(Toyota newToyota) {
		if (counterToyota == 4) {
			System.out.println("CANT ADD ANYMORE!");
		} else {
			ToyotaCars.add(newToyota); // add new toyota car in arraylist
			counterToyota++;
			totalCars++;
		}
	}

	public String toString() {
		return "Brand: Toyota" + "\nColor: " + color + "\nNumber of doors: "
				+ nbOfDoors + "\nPrice: " + fmt1.format(price) + "\nDiscount: "
				+ discount + "%" + "\n==========\n";
	}
}