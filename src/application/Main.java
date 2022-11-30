package application;
import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int optionStage_1, optionStage_2, optionStage_3;
        Client clt = new Client();
        Employee emp = new Employee();
        boolean brandAvailable;

        String directory = System.getProperty("user.dir");//gets current user directory that the program runs in
        File folder = new File(directory+"\\DealerShip");

        if (!folder.exists()) { //checks if DealerShip folder is created or not
            folder.mkdir(); //creates DealerShip if it doesn't exist
        }

        String EmployeeFilePath = directory+"\\DealerShip\\Employee.csv"; //more specific directory of CSV files
        CsvReaderWriter.employeeReadCsv(EmployeeFilePath);

        String CarFilePath = directory+"\\DealerShip\\Car.csv";
        CsvReaderWriter.carsReadCsv(CarFilePath);

        String ClientFilePath = directory+"\\DealerShip\\Client.csv";
        CsvReaderWriter.clientReadCsv(ClientFilePath);


        System.out.println("Welcome to car dealership system !");
        System.out.println("Please choose an option:");
        System.out.println(directory);
//test
        do {
            System.out.print("""
                    --------------------
                    1-Cars options
                    2-Clients options
                    3-Employees options
                    4-Exit program
                    -------------------> Choice:""");

            optionStage_1 = InputChecker.nbIntChecker(); //uses method of main class to check if optionStage_1 is integer or not

            switch (optionStage_1) {
                case 1 -> {
                    do {
                        System.out.print("""
                                --------------------
                                1-Add Cars for sale
                                2-Display all cars
                                3-Change car options
                                4-Remove a car
                                5-Go back
                                --------------------> Choice:""");

                        optionStage_2 = InputChecker.nbIntChecker();

                        switch (optionStage_2) {
                            case 1 -> {
                                do {
                                    brandAvailable = true;
                                    System.out.print("Enter car brand (BMW, Ferrari, Nissan, Audi, Toyota): ");
                                    String brand = cin.nextLine();

                                    switch (brand.toLowerCase()) {
                                        case "bmw" -> {
                                            BMW bmw = new BMW();

                                            String color = bmw.createColor();
                                            int nbOfDoors = bmw.createNbOfDoors();

                                            bmw = new BMW(brand, color, nbOfDoors); //Price and discount and set in Cars class automatically
                                            bmw.addBMW(bmw);
                                        }
                                        case "ferrari" -> {
                                            Ferrari ferrari = new Ferrari();

                                            String color = ferrari.createColor();
                                            int nbOfDoors = ferrari.createNbOfDoors();

                                            ferrari = new Ferrari(brand, color, nbOfDoors);
                                            ferrari.addFerrari(ferrari);
                                        }
                                        case "nissan" -> {
                                            Nissan nissan = new Nissan();

                                            String color = nissan.createColor();
                                            int nbOfDoors = nissan.createNbOfDoors();

                                            nissan = new Nissan(brand, color, nbOfDoors);
                                            nissan.addNissan(nissan);
                                        }
                                        case "audi" -> {
                                            Audi audi = new Audi();

                                            String color = audi.createColor();
                                            int nbOfDoors = audi.createNbOfDoors();

                                            audi = new Audi(brand, color, nbOfDoors);
                                            audi.addAudi(audi);
                                        }
                                        case "toyota" -> {
                                            Toyota toyota = new Toyota();

                                            String color = toyota.createColor();
                                            int nbOfDoors = toyota.createNbOfDoors();

                                            toyota = new Toyota(brand, color, nbOfDoors);
                                            toyota.addToyota(toyota);
                                        }
                                        default -> {
                                            brandAvailable = false;
                                        }
                                    }
                                } while (!brandAvailable);
                                CsvReaderWriter.carsWriteCsv(CarFilePath);
                            }
                            case 2 -> {
                                Cars.displayCars();
                            }
                            case 3 -> {
                                do {
                                    System.out.println("""
                                            ---------------------------------
                                            Choose an option:
                                            1-Change car price
                                            2-Change car discount (default 0)
                                            3-Go back
                                            --------------------------------->Choice:""");

                                    optionStage_3 = InputChecker.nbIntChecker();

                                    Transaction transaction = new Transaction();

                                    switch (optionStage_3) {
                                        case 1 -> {
                                            transaction.SetPrice();
                                            CsvReaderWriter.carsWriteCsv(CarFilePath);
                                        }
                                        case 2 -> {
                                            transaction.setDiscount();
                                            CsvReaderWriter.carsWriteCsv(CarFilePath);
                                        }
                                        case 3 -> {
                                            System.out.println("Going back...");
                                        }
                                    }

                                } while (optionStage_3 != 3);

                            }
                            case 4 -> {
                                String brand;
                                int carID = 0;

                                if (Cars.totalCars != 0) {
                                    do {
                                        brand = Cars.verifyBrand(true);//if brand not found Cars.carNotFound becomes true

                                        if (!Cars.carNotFound) {       // If it found a brand match it enters in if
                                            carID = Cars.enterCarID(brand);
                                        }
                                    } while (Cars.carNotFound);
                                    Cars.deleteCar(brand, carID);
                                    CsvReaderWriter.carsWriteCsv(CarFilePath);
                                }else {
                                    System.out.println("There are no cars to delete");
                                }

                            }
                            case 5 -> {
                                System.out.println("Going back...");
                            }
                        }

                    } while (optionStage_2 != 5);

                }
                case 2 -> {
                    do {
                        System.out.print("""
                                ----------------------------
                                1-Add client
                                2-Display all clients
                                3-Search/Update clients info
                                4-Purge all clients info
                                5-Go back
                                ----------------------------> Choice:""");

                        optionStage_2 = InputChecker.nbIntChecker();

                        switch (optionStage_2) {
                            case 1 -> {
                                if (Cars.totalCars != 0) {
                                    String fName, lName, address;
                                    int age, tel;

                                    fName = clt.createFirstName();
                                    lName = clt.createLastName();
                                    age = clt.createAge();
                                    address = clt.createAddress();
                                    tel = clt.createTel();

                                    String ID = clt.createClientID(fName, lName, tel);


                                    clt = new Client(fName, lName, age, tel, address, ID.toLowerCase());
                                    clt.addClient(clt);

                                    //Adding a car to client
                                    String brand;
                                    int carID = 0;

                                    do {
                                        brand = Cars.verifyBrand(false);//if brand not found Cars.carNotFound becomes true
                                        if (!Cars.carNotFound) {       // If it found a brand match it enters in if
                                            carID = Cars.enterCarID(brand);
                                        }

                                    } while (Cars.carNotFound);
                                    System.out.println(Transaction.receipt(brand, carID - 1));
                                    Client.People_Clients.get(Client.clientCounter - 1).addCarsToClient(brand, carID, Client.clientCounter - 1);

                                    CsvReaderWriter.carsWriteCsv(CarFilePath);
                                    CsvReaderWriter.clientWriteCsv(ClientFilePath);

                                } else {
                                    System.out.println("\nThere are no cars for sale");
                                }
                            }
                            case 2 -> {
                                clt.displayClients();
                            }
                            case 3 -> {
                                int ID = clt.searchClient();
                                if (ID == -1) {
                                    System.out.println("Client not found.");
                                } else if (ID == -2) {
                                    System.out.println("You have no clients to update");
                                } else if (ID == -3) {
                                    System.out.println("Exiting...");
                                } else {
                                    int answer;
                                    do {

                                        System.out.println(Client.People_Clients.get(ID).toString(ID));
                                        System.out.println("""
                                                            What would you like to do ?
                                                1-Add car to client
                                                2-Change telephone Number
                                                3-Change address
                                                4-Go back
                                                                       
                                                Answer:""");

                                        answer = InputChecker.nbIntChecker();

                                        switch (answer) {
                                            case 1 -> {
                                                String brand;
                                                int carID;
                                                if (Cars.totalCars > 0) {

                                                    do {

                                                        Cars.displayCars();
                                                        System.out.print("Enter brand: ");
                                                        brand = cin.nextLine();
                                                        Cars.displayByBrand(brand);

                                                        if (!Cars.carNotFound) {     // If it found a brand match it enters in if
                                                            carID = Cars.enterCarID(brand);

                                                            Client.People_Clients.get(ID).addCarsToClient(brand, carID, ID);
                                                        }
                                                    } while (Cars.carNotFound);
                                                } else {
                                                    System.out.println("No cars available"); //since theres no cars it will tell him that
                                                }
                                                CsvReaderWriter.clientWriteCsv(ClientFilePath);
                                                CsvReaderWriter.carsWriteCsv(CarFilePath);
                                            }
                                            case 2 -> {
                                                int tel, deleteThisTel;
                                                String newID;

                                                tel = clt.createTel();

                                                deleteThisTel = Client.getTelID(Client.People_Clients.get(ID).tel); // Gives tel location in array of tels
                                                Client.People_Clients.get(ID).tel = tel;
                                                People.telAvailable.remove(deleteThisTel); //Removes old tel from array of tels
                                                newID = clt.createClientID(Client.People_Clients.get(ID).getFirstName(), Client.People_Clients.get(ID).getLastName(), Client.People_Clients.get(ID).getTel());
                                                Client.People_Clients.get(ID).setID(newID);
                                                CsvReaderWriter.clientWriteCsv(ClientFilePath);
                                            }
                                            case 3 -> {
                                                String newAddress;
                                                newAddress = clt.createAddress();
                                                Client.People_Clients.get(ID).setAddress(newAddress);
                                                CsvReaderWriter.clientWriteCsv(ClientFilePath);
                                            }
                                            case 4 -> {
                                                System.out.println("Going back...");
                                            }
                                            default -> {
                                                System.out.println("No such option.");
                                            }
                                        }
                                    } while (answer != 4);
                                }
                            }

                            case 4 -> {
                                clt.deleteAllClients();
                                CsvReaderWriter.clientWriteCsv(ClientFilePath);
                            }
                            case 5 -> {
                                System.out.println("Going back...");
                            }
                        }

                    } while (optionStage_2 != 5);
                }
                case 3 -> {
                    do {
                        System.out.print("""
                                -----------------------
                                1-Add employee
                                2-Display all employees
                                3-Update employees
                                4-Delete an employee
                                5-Go back
                                -----------------------> Choice:""");

                        optionStage_2 = InputChecker.nbIntChecker();

                        switch (optionStage_2) {
                            case 1 -> {
                                if (Employee.employeeCounter < 10) {
                                    String fName, lName, address;
                                    int age, tel;

                                    fName = emp.createFirstName();
                                    lName = emp.createLastName();
                                    age = emp.createAge();
                                    address = emp.createAddress();
                                    tel = emp.createTel();

                                    String ID = emp.createEmployeeID(fName, lName, tel);

                                    emp = new Employee(fName, lName, age, tel, address, ID.toLowerCase());
                                    emp.addEmployee(emp);
                                    CsvReaderWriter.employeeWriteCsv(EmployeeFilePath);
                                } else {
                                    System.out.println("You have reached the maximum number of employees you can have.");
                                }

                            }
                            case 2 -> {
                                emp.displayEmployees();
                            }
                            case 3 -> {
                                int ID = emp.searchEmployee();
                                if (ID == -1) {
                                    System.out.println("Employee not found.");
                                } else if (ID == -2) {
                                    System.out.println("You have no Employees to update");
                                } else if (ID == -3) {
                                    System.out.println("Exiting...");
                                } else {

                                    int answer;
                                    do {
                                        System.out.println(Employee.People_Employees.get(ID).toString(ID));
                                        System.out.println("""
                                                            What would you like to do ?
                                                1-Change position
                                                2-Change salary
                                                3-Go back
                                                			
                                                Answer:""");

                                        answer = InputChecker.nbIntChecker();

                                        switch (answer) {
                                            case 1 -> {
                                                emp.setPosition(ID);
                                                CsvReaderWriter.employeeWriteCsv(EmployeeFilePath);
                                            }
                                            case 2 -> {
                                                emp.setSalary(ID);
                                                CsvReaderWriter.employeeWriteCsv(EmployeeFilePath);
                                            }
                                            case 3 -> {
                                                System.out.println("Going back...");
                                            }
                                            default -> {
                                                System.out.println("No such option");
                                            }
                                        }
                                    } while (answer != 3);
                                }
                            }
                            case 4 -> {
                                emp.deleteEmployee();
                                CsvReaderWriter.employeeWriteCsv(EmployeeFilePath);
                            }
                            case 5 -> {
                                System.out.println("Going back...");
                            }
                        }

                    } while (optionStage_2 != 5);
                }
                case 4 -> {
                    System.out.println("Program terminated !");
                    CsvReaderWriter.carsWriteCsv(CarFilePath);
                    CsvReaderWriter.employeeWriteCsv(EmployeeFilePath);
                    CsvReaderWriter.clientWriteCsv(ClientFilePath);
                }
            }

        } while (optionStage_1 != 4);

    }
}