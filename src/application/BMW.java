package application;

import java.util.ArrayList;

public class BMW extends Cars {
	public static ArrayList<BMW> BMWCars = new ArrayList<>(4);
	public static int counterBMW = 0;

	public BMW() {
	}

	public BMW(String brand, String color, int nbOfDoors) {
		super(brand, color, nbOfDoors);
	}

	public void addBMW(BMW newBMW) {
		if (counterBMW == 4) {
			System.out.println("CANT ADD ANYMORE!");
		} else {
			BMWCars.add(newBMW);// add new bmw car in arraylist
			counterBMW++;
			totalCars++;
		}
	}

	public String toString() {
		return "Brand: BMW" + "\nColor: " + color + "\nNumber of doors: "
				+ nbOfDoors + "\nPrice: " + fmt1.format(price) + "\nDiscount: "
				+ discount + "%" + "\n==========\n";
	}
}