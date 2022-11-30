package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvReaderWriter {

	public static void carsReadCsv(String filePath) {
		BufferedReader reader = null;

		try {
			String line;
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");

				if (fields.length > 0) {
					for (int i = 0; i < fields.length; i++) {

						String brand = ((fields[i]));
						++i;
						String color = (fields[i]);
						++i;
						int nbDoors = (Integer.parseInt(fields[i]));
						++i;
						double price = (Double.parseDouble(fields[i]));
						++i;
						int discount = (Integer.parseInt(fields[i]));

						switch (brand.toLowerCase()) {
							case "bmw" -> {
								BMW bmw = new BMW();
								bmw = new BMW(brand, color, nbDoors);
								bmw.addBMW(bmw);
								BMW.BMWCars
										.get(BMW.counterBMW - 1).price = price;
								BMW.BMWCars.get(
										BMW.counterBMW - 1).discount = discount;
							}
							case "toyota" -> {
								Toyota toyota = new Toyota();
								toyota = new Toyota(brand, color, nbDoors);
								toyota.addToyota(toyota);
								Toyota.ToyotaCars.get(
										Toyota.counterToyota - 1).price = price;
								Toyota.ToyotaCars.get(Toyota.counterToyota
										- 1).discount = discount;

							}
							case "ferrari" -> {
								Ferrari ferrari = new Ferrari();
								ferrari = new Ferrari(brand, color, nbDoors);
								ferrari.addFerrari(ferrari);
								Ferrari.FerrariCars.get(Ferrari.counterFerrari
										- 1).price = price;
								Ferrari.FerrariCars.get(Ferrari.counterFerrari
										- 1).discount = discount;

							}
							case "nissan" -> {
								Nissan nissan = new Nissan();
								nissan = new Nissan(brand, color, nbDoors);
								nissan.addNissan(nissan);
								Nissan.NissanCars.get(
										Nissan.counterNissan - 1).price = price;
								Nissan.NissanCars.get(Nissan.counterNissan
										- 1).discount = discount;

							}
							case "audi" -> {
								Audi audi = new Audi();
								audi = new Audi(brand, color, nbDoors);
								audi.addAudi(audi);
								Audi.AudiCars.get(
										Audi.counterAudi - 1).price = price;
								Audi.AudiCars.get(Audi.counterAudi
										- 1).discount = discount;

							}

						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				assert reader != null;
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void carsWriteCsv(String filePath) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);

			fileWriter.append("Brand, Color, nbDoors, price, discount\n");

			if (BMW.counterBMW != 0) {
				for (int i = 0; i < BMW.BMWCars.size(); i++) {
					fileWriter.append(BMW.BMWCars.get(i).getBrand());
					fileWriter.append(",");
					fileWriter.append(BMW.BMWCars.get(i).getColor());
					fileWriter.append(",");
					fileWriter.append(
							String.valueOf(BMW.BMWCars.get(i).getNbOfDoors()));
					fileWriter.append(",");
					fileWriter.append(
							String.valueOf(BMW.BMWCars.get(i).getPrice()));
					fileWriter.append(",");
					fileWriter.append(
							String.valueOf(BMW.BMWCars.get(i).getDiscount()));
					fileWriter.append("\n");
				}
			}
			if (Toyota.counterToyota != 0) {
				for (int i = 0; i < Toyota.ToyotaCars.size(); i++) {
					fileWriter.append(Toyota.ToyotaCars.get(i).getBrand());
					fileWriter.append(",");
					fileWriter.append(Toyota.ToyotaCars.get(i).getColor());
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Toyota.ToyotaCars.get(i).getNbOfDoors()));
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Toyota.ToyotaCars.get(i).getPrice()));
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Toyota.ToyotaCars.get(i).getDiscount()));
					fileWriter.append("\n");
				}
			}
			if (Ferrari.counterFerrari != 0) {
				for (int i = 0; i < Ferrari.FerrariCars.size(); i++) {
					fileWriter.append(Ferrari.FerrariCars.get(i).getBrand());
					fileWriter.append(",");
					fileWriter.append(Ferrari.FerrariCars.get(i).getColor());
					fileWriter.append(",");
					fileWriter.append(String.valueOf(
							Ferrari.FerrariCars.get(i).getNbOfDoors()));
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Ferrari.FerrariCars.get(i).getPrice()));
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Ferrari.FerrariCars.get(i).getDiscount()));
					fileWriter.append("\n");
				}
			}
			if (Nissan.counterNissan != 0) {
				for (int i = 0; i < Nissan.NissanCars.size(); i++) {
					fileWriter.append(Nissan.NissanCars.get(i).getBrand());
					fileWriter.append(",");
					fileWriter.append(Nissan.NissanCars.get(i).getColor());
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Nissan.NissanCars.get(i).getNbOfDoors()));
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Nissan.NissanCars.get(i).getPrice()));
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Nissan.NissanCars.get(i).getDiscount()));
					fileWriter.append("\n");
				}
			}
			if (Audi.counterAudi != 0) {
				for (int i = 0; i < Audi.AudiCars.size(); i++) {
					fileWriter.append(Audi.AudiCars.get(i).getBrand());
					fileWriter.append(",");
					fileWriter.append(Audi.AudiCars.get(i).getColor());
					fileWriter.append(",");
					fileWriter.append(String
							.valueOf(Audi.AudiCars.get(i).getNbOfDoors()));
					fileWriter.append(",");
					fileWriter.append(
							String.valueOf(Audi.AudiCars.get(i).getPrice()));
					fileWriter.append(",");
					fileWriter.append(
							String.valueOf(Audi.AudiCars.get(i).getDiscount()));
					fileWriter.append("\n");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				assert fileWriter != null;
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void employeeReadCsv(String filePath) {
		BufferedReader reader = null;

		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");

				if (fields.length > 0) {
					String fName, lName, address, position, id;
					int age, tel, salary;

					fName = fields[0];
					lName = fields[1];
					age = Integer.parseInt(fields[2]);
					position = fields[3];
					salary = (Integer.parseInt(fields[4]));
					address = fields[5];
					tel = (Integer.parseInt(fields[6]));
					id = fields[7];

					Employee emp = new Employee(fName, lName, age, position,
							salary, address, tel, id); // now you enter
														// l info men l
														// file to make
														// the employees
														// back, we dont
														// need to
														// verify //any
														// of the info
														// since for it
														// to get in the
														// CSV it needs
														// to be 100%
														// correct...

					Employee.People_Employees.add(emp); // and after we created
														// the employee we add
														// him to the new Array
														// list
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				assert reader != null;
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void clientWriteCsv(String filePath) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);

			fileWriter.append(
					"First name- Last name- Age- Address- Tel- ID- Cars owned- Cars owned CSV\n");
			for (int i = 0; i < Client.People_Clients.size(); i++) {
				fileWriter.append(Client.People_Clients.get(i).getFirstName());
				fileWriter.append("-");
				fileWriter.append(Client.People_Clients.get(i).getLastName());
				fileWriter.append("-");
				fileWriter.append(
						String.valueOf(Client.People_Clients.get(i).getAge()));
				fileWriter.append("-");
				fileWriter.append(Client.People_Clients.get(i).getAddress());
				fileWriter.append("-");
				fileWriter.append(
						String.valueOf(Client.People_Clients.get(i).getTel()));
				fileWriter.append("-");
				fileWriter.append(Client.People_Clients.get(i).getId());
				fileWriter.append("-");
				fileWriter.append(String.valueOf(
						Client.People_Clients.get(i).getNbCarsOwned()));
				fileWriter.append("-");
				fileWriter
						.append(Client.People_Clients.get(i).getCarsOwnedCSV());
				fileWriter.append("\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				assert fileWriter != null;
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void clientReadCsv(String filePath) {
		BufferedReader reader = null;

		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();

			while ((line = reader.readLine()) != null) {
				String[] fields = line.split("-");

				if (fields.length > 0) {
					String fName, lName, address, id, carsOwnedCSV = "",
							carsOwnedForNextCSVSave = ""; // i made the
															// last one so i
															// can resave it
															// with the info
															// seperated by
															// "-" since
															// they get
															// removed once
															// i read them
															// back which
															// makes it
															// impossible to
															// write them
															// back here
															// after
															// existing
															// program 2
															// times...
					int age, tel, carsOwned;

					fName = fields[0];
					lName = fields[1];
					age = Integer.parseInt(fields[2]);
					address = fields[3];
					tel = Integer.parseInt(fields[4]);
					id = fields[5];
					carsOwned = Integer.parseInt(fields[6]);
					carsOwnedCSV += fields[7] + "\n" + fields[8] + "\n"
							+ fields[9] + "\n" + fields[10] + "\n" + fields[11]
							+ "\n" + fields[12] + "\n" + fields[13] + "\n\n"
							+ fields[14] + "\n" + fields[15] + "\n" + fields[16]
							+ "\n" + fields[17] + "\n" + fields[18] + "\n\n"; // we
																				// did
																				// "(j==0?0:-1)"
																				// because
																				// if
																				// j=0
																				// (first
																				// car)
																				// we
																				// dont
																				// need
																				// to
																				// remove
																				// that
																				// extra
																				// "1"
																				// that
																				// is
																				// cause
																				// by
																				// the
																				// "========"
																				// when
																				// displaying
																				// cars
																				// owned
																				// by
																				// client!
																				// -Ralph
																				// Daher
																				// problem
																				// solving
																				// 101.
					carsOwnedForNextCSVSave += fields[7] + "-" + fields[8] + "-"
							+ fields[9] + "-" + fields[10] + "-" + fields[11]
							+ "-" + fields[12] + "-" + fields[13] + "-"
							+ fields[14] + "-" + fields[15] + "-" + fields[16]
							+ "-" + fields[17] + "-" + fields[18] + "-";
					if (carsOwned > 1) {
						int j = 0;
						for (int i = 0; i < carsOwned - 1; i++) { // -1 because
																	// first car
																	// was saved
																	// in lines
																	// 275-276
							carsOwnedCSV += fields[j + 19] + "\n"
									+ fields[j + 20] + "\n" + fields[j + 21]
									+ "\n" + fields[j + 22] + "\n"
									+ fields[j + 23] + "\n" + fields[j + 24]
									+ "\n" + fields[j + 25] + "\n"
									+ fields[j + 26] + "\n" + fields[j + 27]
									+ "\n" + fields[j + 28] + "\n"
									+ fields[j + 29] + "\n\n";
							carsOwnedForNextCSVSave += fields[j + 19] + "-"
									+ fields[j + 20] + "-" + fields[j + 21]
									+ "-" + fields[j + 22] + "-"
									+ fields[j + 23] + "-" + fields[j + 24]
									+ "-" + fields[j + 25] + "-"
									+ fields[j + 26] + "-" + fields[j + 27]
									+ "-" + fields[j + 28] + "-"
									+ fields[j + 29] + "-";
							j += 11;
						}
					}
					Client clt = new Client(fName, lName, age, address, tel, id,
							carsOwned, carsOwnedCSV, carsOwnedForNextCSVSave); // now
																				// you
																				// enter
																				// l
																				// info
																				// men
																				// l
																				// file
																				// to
																				// make
																				// the
																				// employees
																				// back,
																				// we
																				// dont
																				// need
																				// to
																				// verify
																				// //any
																				// of
																				// the
																				// info
																				// since
																				// for
																				// it
																				// to
																				// get
																				// in
																				// the
																				// CSV
																				// it
																				// needs
																				// to
																				// be
																				// 100%
																				// correct...

					Client.People_Clients.add(clt); // and after we created the
													// employee we add him to
													// the new Array
													// list
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				assert reader != null;
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void employeeWriteCsv(String filePath) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);

			fileWriter.append(
					"First name, Last name, Age, Position, Salary, Address, Tel, ID\n");
			for (int i = 0; i < Employee.People_Employees.size(); i++) {
				fileWriter.append(
						Employee.People_Employees.get(i).getFirstName());
				fileWriter.append(",");
				fileWriter
						.append(Employee.People_Employees.get(i).getLastName());
				fileWriter.append(",");
				fileWriter.append(String
						.valueOf(Employee.People_Employees.get(i).getAge()));
				fileWriter.append(",");
				fileWriter
						.append(Employee.People_Employees.get(i).getPosition());
				fileWriter.append(",");
				fileWriter.append(String
						.valueOf(Employee.People_Employees.get(i).getSalary()));
				fileWriter.append(",");
				fileWriter
						.append(Employee.People_Employees.get(i).getAddress());
				fileWriter.append(",");
				fileWriter.append(String
						.valueOf(Employee.People_Employees.get(i).getTel()));
				fileWriter.append(",");
				fileWriter.append(Employee.People_Employees.get(i).getId());
				fileWriter.append("\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				assert fileWriter != null;
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
