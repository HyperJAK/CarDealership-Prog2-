package application;

import java.util.ArrayList;

public class Nissan extends Cars {
	public static ArrayList<Nissan> NissanCars = new ArrayList<>(4);
	public static int counterNissan = 0;

	public Nissan() {
	}

	public Nissan(String brand, String color, int nbOfDoors) {
		super(brand, color, nbOfDoors);
	}

	public void addNissan(Nissan newNissan) {
		if (counterNissan == 4) {
			System.out.println("CANT ADD ANYMORE!");
		} else {
			NissanCars.add(newNissan);// add new nissan car in arraylist
			counterNissan++;
			totalCars++;
		}
	}

	public String toString() {
		return "Brand: Nissan" + "\nColor: " + color + "\nNumber of doors: "
				+ nbOfDoors + "\nPrice: " + fmt1.format(price) + "\nDiscount: "
				+ discount + "%" + "\n==========\n";
	}
}