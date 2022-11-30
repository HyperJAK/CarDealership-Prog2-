package application;

import java.util.ArrayList;
import java.util.Scanner;

public class People { // everything common between client and employee
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String address;
	public int tel;
	protected final String countryCode = "+961";
	public static ArrayList<String> telAvailable = new ArrayList<>(1);
	protected String id; // employee ID

	Scanner cin = new Scanner(System.in);

	public People() {
	}

	public People(String firstName, String lastName, int age, String address,
			int tel, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.id = id;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String createFirstName() { // edit on this
		String fName;

		System.out.print("Enter first name: ");
		fName = cin.nextLine();

		while (InputChecker.stringChecker(fName)) {
			System.out.println(
					"Input contains unsupported characters type again / short name:");
			fName = cin.nextLine();
		}

		return fName;
	}

	public String createLastName() { // edit on this

		String lName;

		System.out.print("Enter last name: ");
		lName = cin.nextLine();

		while (InputChecker.stringChecker(lName)) {
			System.out.println(
					"Input contains unsupported characters type again / short name:");
			lName = cin.nextLine();
		}

		return lName;
	}

	public String getId() {
		return this.id;
	}

	public void setID(String newID) {
		this.id = newID;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int createAge() {
		int doWhileCounter = 0, age;

		do {
			if (doWhileCounter > 0) {
				System.out.println("Client must be over 18!");
			}
			System.out.print("Enter age: ");
			age = InputChecker.nbIntChecker();
			doWhileCounter++;

		} while (age < 18 || age > 100);
		return age;
	}

	public void setTelForReading(int tel) {
		this.tel = tel;
	}

	public int createTel() {
		int doWhileCounter = 0, tel, counterForTel;
		String enter;

		do {
			if (doWhileCounter > 0) {
				System.out.println("Error");
			}

			System.out.print("Enter tel number: ");
			tel = InputChecker.nbIntChecker();
			enter = String.valueOf(tel);
			counterForTel = 0;

			for (int i = 0; i < telAvailable.size(); i++) {
				if (telAvailable.get(i).equals(enter)) {
					counterForTel++;
				}
			}
			doWhileCounter++;

		} while (tel < 100 || tel > 999999999 || counterForTel > 0);
		telAvailable.add(enter);
		return tel;
	}

	public int getTel() {
		return this.tel;
	}

	public static int getTelID(int tel) {
		String telString = String.valueOf(tel);
		int id = 0;

		for (int i = 0; i < telAvailable.size(); i++) {
			if (telString.equals(telAvailable.get(i)))
				id = i;
		}
		return id;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	public String getAddress() {
		return this.address;
	}

	public String createAddress() {

		String address;

		System.out.print("Enter address: ");
		address = cin.nextLine();

		while (InputChecker.addressStringChecker(address)) {
			System.out.println(
					"Input contains unsupported characters type again / short address:");
			address = cin.nextLine();
		}

		return address;
	}
}