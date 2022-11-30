package application;

import java.util.ArrayList;

public class Audi extends Cars {
	public static ArrayList<Audi> AudiCars = new ArrayList<>(4);
	public static int counterAudi = 0;

	public Audi() {
	}

	public Audi(String brand, String color, int nbOfDoors) {
		super(brand, color, nbOfDoors);
	}

	public void addAudi(Audi newAudi) {
		if (counterAudi == 4) {
			System.out.println("CANT ADD ANYMORE!");
		} else {
			AudiCars.add(newAudi);// add new audi car in arraylist
			counterAudi++;
			totalCars++;
		}
	}

	public String toString() {
		return "Brand: Audi" + "\nColor: " + color + "\nNumber of doors: "
				+ nbOfDoors + "\nPrice: " + fmt1.format(price) + "\nDiscount: "
				+ discount + "%" + "\n==========\n";
	}
}