package application;

import java.util.ArrayList;

public class Ferrari extends Cars {
	public static ArrayList<Ferrari> FerrariCars = new ArrayList<>(4);
	public static int counterFerrari = 0;

	public Ferrari() {
	}

	public Ferrari(String brand, String color, int nbOfDoors) {
		super(brand, color, nbOfDoors);
	}

	public void addFerrari(Ferrari newFerrari) {
		if (counterFerrari == 4) {
			System.out.println("CANT ADD ANYMORE!");
		} else {
			FerrariCars.add(newFerrari);// add new ferrari car in arraylist
			counterFerrari++;
			totalCars++;
		}
	}

	public String toString() {
		return "Brand: Ferrari" + "\nColor: " + color + "\nNumber of doors: "
				+ nbOfDoors + "\nPrice: " + fmt1.format(price) + "\nDiscount: "
				+ discount + "%" + "\n==========\n";
	}
}