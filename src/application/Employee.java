package application;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends People {
	private String position;
	private int salary;
	public static int employeeCounter = 0; // Number of total employees
	public static ArrayList<Employee> People_Employees = new ArrayList<>(1);

	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();

	static Scanner cin = new Scanner(System.in);

	public Employee() {
	}

	public Employee(String fname, String lname, int age, String position,
			int salary, String address, int tel, String id) { // this one for
																// when reading
																// the client
																// from the CSV
																// file...
		firstName = fname;
		lastName = lname;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.address = address;
		this.tel = tel;
		this.id = id;
		employeeCounter++;
		telAvailable.add(String.valueOf(tel));
	}

	public Employee(String fName, String lName, int age, int tel,
			String address, String ID) { // constructor uses
											// People class
		super(fName, lName, age, address, tel, ID);
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(int EmployeeID) { // Assigns position with its
												// default value for salary
		String position;
		int salary = 0;
		int DoWhileCounter;

		do {
			DoWhileCounter = 0;
			System.out.print(
					"Enter position (Sales Person/Sales Manager/Finance Manager/Car Detailer/Lot Manager): ");
			position = cin.nextLine();

			switch (position.toLowerCase()) {
				case "sales person" -> {
					position = "Sales Person";
					salary = 1000;
				}
				case "sales manager" -> {
					position = "Sales Manager";
					salary = 2000;
				}
				case "finance manager" -> {
					position = "Finance Manager";
					salary = 1500;
				}
				case "car detailer" -> {
					position = "Car Detailer";
					salary = 750;
				}
				case "lot manager" -> {
					position = "Lot Manager";
					salary = 600;
				}
				default -> {
					System.out.println("Position unavailable!");
					DoWhileCounter = 1; // so do while repeats
				}
			}
		} while (DoWhileCounter == 1);
		People_Employees.get(EmployeeID).position = position;
		People_Employees.get(EmployeeID).salary = salary;
	}

	public void setSalary(int EmployeeID) {
		int newSalary;

		do {
			System.out.print("Enter new monthly salary for your employee: ");
			newSalary = InputChecker.nbIntChecker();

		} while (newSalary < 600 || newSalary > 20000);

		People_Employees.get(EmployeeID).salary = newSalary;
	}

	public int getSalary() {
		return this.salary;
	}

	public String createEmployeeID(String fName, String lName, int tel) {
		String stringTel = String.valueOf(tel); // converts int to String
		String ID = fName.substring(0, 2)
				+ lName.substring((lName.length()) - 2) + "@employee"
				+ stringTel;
		return ID;
	}

	public void addEmployee(Employee newEmployee) {
		People_Employees.add(newEmployee); // adds info about employee without
											// position and salary
		setPosition(employeeCounter);// adds position and default salary
		employeeCounter++;
	}

	public void deleteEmployee() {
		if (employeeCounter != 0) {
			int employeeToDel;
			displayEmployees();

			do {
				System.out.print(
						"Enter number of employee to delete(Enter -1 to go back): ");
				employeeToDel = InputChecker.nbIntChecker();

			} while (employeeToDel < -1 || employeeToDel > employeeCounter
					|| employeeToDel == 0);

			if (employeeToDel > 0) {
				telAvailable.remove(getTelID(
						People_Employees.get(employeeToDel - 1).getTel()));
				People_Employees.remove(employeeToDel - 1); // -1 for precise
															// arrayList
															// position
				employeeCounter--;
			}
		} else {
			System.out.println("You don't have any employees to delete");
		}
	}

	public void displayEmployees() {
		if (employeeCounter != 0) {
			System.out.printf("%1s %13s %19s %14s %14s %13s %21s %15s\n",
					"Employee number", "Full name", "Age", "Position", "Salary",
					"Address", "Tel", "ID");

			for (int i = 0; i < People_Employees.size(); i++) {
				People_Employees.get(i).tableDisplayEmployees(i);
			}
		} else {
			System.out.println("No employees found");
		}
	}

	public void tableDisplayEmployees(int i) {
		System.out.printf("%-19d %-25s %-9d %-16s %-12s %-25s %-16s %s\n",
				(i + 1), People_Employees.get(i).getFullName(),
				People_Employees.get(i).getAge(),
				People_Employees.get(i).position,
				fmt1.format(People_Employees.get(i).salary),
				People_Employees.get(i).getAddress(),
				countryCode + " " + People_Employees.get(i).getTel(),
				People_Employees.get(i).getId());
	}

	public int searchEmployee() {

		if (employeeCounter != 0) {
			Scanner cin = new Scanner(System.in);
			String fullName;
			int[] matchingEmployees = new int[employeeCounter];
			int matchingEmployeesCounter = 0;
			int iCopy = 0; // Takes position of employee in clients array

			do {
				System.out
						.print("Enter Employee full name ( Exit to return ): ");
				fullName = cin.nextLine();

				while (InputChecker.stringChecker(fullName)) {
					System.out.print(
							"Input contains unsupported characters type again:");
					fullName = cin.nextLine();
				}

				for (int i = 0; i < employeeCounter; i++) {
					if (fullName.equalsIgnoreCase(
							People_Employees.get(i).getFullName())) {
						matchingEmployees[matchingEmployeesCounter] = i;
						matchingEmployeesCounter++;
						iCopy = i;
					}
				}

			} while (matchingEmployeesCounter == 0
					&& !fullName.equalsIgnoreCase("exit"));

			if (matchingEmployeesCounter > 1) { // If found more than one
												// employee
				for (int i = 0; i < matchingEmployeesCounter; i++) {
					System.out.println(People_Employees
							.get(matchingEmployees[i]).toString(i));
				}
				// If more than 1 employee was found, search by id
				System.out.print(
						"Please enter employee Id to search for the specific employee you want: ");
				String searchID = cin.nextLine();

				for (int i = 0; i < employeeCounter; i++) {
					if (searchID.toLowerCase().equalsIgnoreCase(
							People_Employees.get(i).getId())) {
						matchingEmployeesCounter = 1; // resets for next if case
						iCopy = i; // If "if" matches an employee copy the "i"
									// value
						break;
					}
				}
			}
			if (matchingEmployeesCounter == 1) {
				System.out.println("Employee Found!");
				return iCopy;
			}

			if (matchingEmployeesCounter == 0
					&& !fullName.equalsIgnoreCase("exit")) {
				return -1; // if specific client wasn't found
			}
			if (fullName.equalsIgnoreCase("exit")) {
				return -3; // to go back where exit is entered
			}
		}
		return -2; // if no clients were found at all
	}

	public String toString(int i) {
		return "==========\nEmployee number " + (i + 1) // d
				+ "\nFirst name: " + People_Employees.get(i).getFullName() // s
				+ "\nAge: " + People_Employees.get(i).getAge() // d
				+ "\nPosition: " + People_Employees.get(i).position // s
				+ "\nSalary: " + fmt1.format(People_Employees.get(i).salary) // s
				+ "\nAddress: " + People_Employees.get(i).getAddress() // s
				+ "\nTel: " + countryCode + " "
				+ People_Employees.get(i).getTel() // d
				+ "\nID: " + People_Employees.get(i).getId() // s
				+ "\n";
	}
}