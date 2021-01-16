    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.HouseServiceController;
import Model.Account.Account;
import Model.BookedHouse.BookedHouse;
import Model.Customer.Customer;
import Model.House.House;
import Model.Person.Person;
import Model.Person.Rank;
import Model.Service.BookedHouseService;
import Model.Service.PersonService;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Laptop
 */
public class HouseServiceView {

    public static final HouseServiceController rsc = new HouseServiceController();
    public static final Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private Account account;

    public HouseServiceView() {
    }

    public void initComponents() {
        do {
            account = checkCredentials();
            if (account != null) {
                System.out.println(ANSI_GREEN + "Login Success" + ANSI_RESET);
                System.out.print(ANSI_BLUE + "Welome User -> " + ANSI_RESET + account.getUsername());
                String role = (account.getPrivilege() == 0) ? "STAFF" : "MANAGER";
                System.out.println("\tRole : " + role);
                System.out.println();
                if (account.getPrivilege() == 0) {
                    menuStaff();
                    continue;
                }

                if (account.getPrivilege() == 1) {
                    menuManager();
                    continue;
                }
            } else {
                System.out.println(ANSI_RED + "These credentials do not match our records" + ANSI_RESET);
            }
        } while (account == null);

    }

    private void menuStaff() {
        int menuId;
        do {
            System.out.println("<STAFF OPTION>");
            System.out.println("<<Main Menu>>");
            System.out.println("1. SearchAllHouse ");
            System.out.println("2. SearchHouseAvaliable");
            System.out.println("3. HouseSchedule");
            System.out.println("4. CheckIn/CheckOut");
            System.out.println("5. Log Out ");
            System.out.print("Enter your menu [1-5]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 1:
                    getAllHouse();
                    break;
                case 2:
                    getHouseAvaliable();
                    break;
                case 3:
                    gethouseSchedule();
                    break;
                case 4:
                    checkInCheckOut();
                    break;
//         
                case 5:
                    account = null;

            }
        } while (menuId != 5);
    }

    private void menuManager() {
        int menuId;
        do {
            System.out.println("<MANAGER OPTION>");
            System.out.println("<<Main Menu>>");
            System.out.println("1. SearchAllHouse ");
            System.out.println("2. SearchHouseAvaliable");
            System.out.println("3. HouseSchedule");
            System.out.println("4. ManageHouse");
            System.out.println("5. ManageAccount");
            System.out.println("6. CheckIn/CheckOut");
            System.out.println("7. Log Out ");
            System.out.print("Enter your menu [1-7]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 1:
                    getAllHouse();
                    break;
                case 2:
                    getHouseAvaliable();
                    break;
                case 3:
                    gethouseSchedule();
                    break;
                case 4:
                    manageHouse();
                    break;
                case 5:
                    manageAccount();
                    break;
                case 6:
                    checkInCheckOut();
                    break;
                case 7:
                    account = null;
            }
        } while (menuId != 7);
    }

    private Account checkCredentials() {
        System.out.println("<<--Login-->>");
        System.out.print("Username : ");
        String username = sc.next();
        System.out.print("Password : ");
        String password = sc.next();
        Account rs = rsc.checkCredentials(username, password);
        return rs;
    }

    private void getAllHouse() {
        ArrayList<House> allHouse = rsc.getAllHouse();
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s", "HouseID", "NameOfHouse", "TypeofHouse", "Price", "HouseStatus");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        for (House house : allHouse) {
            System.out.format("%-10s %-20s\t %-20s\t %-20s  %-20s\t",
                    house.getHouseID(), house.getNameOfHouse(), house.getTypeofHouse(), house.getPrice(),
                    (house.getHouseStatus().equals("AVALIABLE")) ? ANSI_GREEN + house.getHouseStatus() + ANSI_RESET : ANSI_RED + house.getHouseStatus() + ANSI_RESET
            );
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    private void getHouseAvaliable() {
        ArrayList<House> allHouseAvaliable = rsc.getHouseAvaliable();
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s", "HouseID", "NameOfHouse", "TypeofHouse", "Price", "HouseStatus");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        for (House house : allHouseAvaliable) {
            System.out.format("%-10s %-20s\t %-20s\t %-20s %-20s\t",
                    house.getHouseID(), house.getNameOfHouse(), house.getTypeofHouse(), house.getPrice(),
                    (house.getHouseStatus().equals("AVALIABLE")) ? ANSI_GREEN + house.getHouseStatus() + ANSI_RESET : ANSI_RED + house.getHouseStatus() + ANSI_RESET
            );
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    public void gethouseSchedule() {
        ArrayList<House> allHouseSchedule = rsc.getHouseSchedule();
        ArrayList<BookedHouse> allBookedHouse = rsc.getAllBookedHouse();

        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s\t %-20s\t %-20s", "HouseID", "NameOfHouse", "TypeofHouse", "CheckIn", "CheckOut", "HouseStatus");
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        if (allBookedHouse.size() != 0) {
            for (House house : allHouseSchedule) {
                for (BookedHouse bookedHouse : allBookedHouse) {
                    if (bookedHouse.getHouseID() == house.getHouseID()) {
                        System.out.format("%-10s %-20s\t %-20s\t %-20s\t %-20s\t %-20s\t",
                                house.getHouseID(),
                                house.getNameOfHouse(),
                                house.getTypeofHouse(),
                                bookedHouse.getCheckIndate(),
                                bookedHouse.getCheckOutdate(),
                                (house.getHouseStatus().equals("AVALIABLE")) ? ANSI_GREEN + house.getHouseStatus() + ANSI_RESET : ANSI_RED + house.getHouseStatus() + ANSI_RESET
                        );
                        System.out.println();
                    }
                }
            }
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    interface crudInterface {

        int create();

        int update();

        int delete();

    }

    private void manageHouse() {

        crudInterface r = new crudInterface() {
            @Override

            public int create() {
                System.out.println("");
                System.out.print("NameOfHouse : ");
                String nameOfHouse = sc.next();
                System.out.print("TypeOfHouse : ");
                String typeofHouse = sc.next();
                System.out.print("Price : ");
                double price = sc.nextDouble();
                int rs = rsc.manageHouse("C", new House(0, nameOfHouse, typeofHouse, price), 0);
                return rs;
            }

            @Override
            public int update() {
                ArrayList<House> allHouse = rsc.getAllHouse();
                for (House house : allHouse) {
                    System.out.println(house.getHouseID() + ". " + house.getNameOfHouse());
                }
                System.out.print("Select House Id : ");
                int id = sc.nextInt();
                System.out.println("");
                System.out.print("NameOfHouse : ");
                String nameOfHouse = sc.next();
                System.out.print("TypeOfHouse : ");
                String typeofHouse = sc.next();
                System.out.print("Price : ");
                double price = sc.nextDouble();

                int rs = rsc.manageHouse("U", new House(id, nameOfHouse, typeofHouse, price), 0);
                return rs;
            }

            @Override
            public int delete() {
                ArrayList<House> allHouse = rsc.getAllHouse();
                for (House house : allHouse) {
                    System.out.println(house.getHouseID() + ". " + house.getNameOfHouse());
                }
                System.out.print("Select House Id : ");
                int id = sc.nextInt();
                int rs = rsc.manageHouse("D", null, id);
                return rs;
            }

        };
        //       

        int menuId;
        int row;
        String state;
        do {
            System.out.println("<<Management System>>");
            System.out.println("1. Create House");
            System.out.println("2. Edit House");
            System.out.println("3. Delete House");
            System.out.println("4. Back to menu");
            System.out.print("Enter your menu [1-4]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 1:
                    row = r.create();
                    System.out.println(row);
                    state = (row > 0)
                            ? ANSI_GREEN + "Create Success" + ANSI_RESET
                            : ANSI_RED + "Can't Create" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 2:
                    row = r.update();
                    state = (row > 0)
                            ? ANSI_GREEN + "Update Success" + ANSI_RESET
                            : ANSI_RED + "Can't Update" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 3:
                    row = r.delete();
                    state = (row > 0)
                            ? ANSI_GREEN + "Delete Success" + ANSI_RESET
                            : ANSI_RED + "Can't Delete" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 4:
                    break;
            }
        } while (menuId != 4);

    }

    interface crudInterface2 {
//

        int create();

        int delete();

    }

    private void manageAccount() {

        crudInterface2 r = new crudInterface2() {
            @Override

            public int create() {
                String rank = null;
                System.out.println("");
                System.out.print("Username : ");
                String username = sc.next();

                System.out.print("Password : ");
                String password = sc.next();

                System.out.print("Firstname : ");
                String firstname = sc.next();
                System.out.print("Lastname : ");
                String lastname = sc.next();
                System.out.print("Phone Number : ");
                String phone = sc.next();

                System.out.println("0." + Rank.STAFF.toString());
                System.out.println("1." + Rank.MANAGER.toString());
                System.out.print("Rank : ");
                int role = sc.nextInt();

                if (role == 0) {
                   rank = Rank.STAFF.toString();
                }

                if (role == 1) {
                    rank = Rank.MANAGER.toString();
                }

                Person person = new Person(firstname, lastname, phone, rank);
                PersonService personService = new PersonService();
                int personID = personService.createPerson(person);
                int rs = rsc.manageAccount("C", new Account(username, password, personID, role), 0);
                if (personID == 0 && rs != 1) {
                    return -1;
                }
                return rs;
            }

            @Override
            public int delete() {
                ArrayList<Account> allAccount = rsc.getAllAccount();
                for (Account account : allAccount) {
                    System.out.println(account.getAccountId() + ". " + account.getUsername());
                }
                System.out.print("Select Account Id : ");
                int id = sc.nextInt();
                int rs = rsc.manageAccount("D", null, id);
                return rs;
            }

        };

        int menuId;
        int row;
        String state;
        do {
            System.out.println("<<Management Account>>");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Back to menu");
            System.out.print("Enter your menu [1-3]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 1:
                    row = r.create();
                    state = (row == -1)
                            ? ANSI_RED + "This user account is already used." + ANSI_RESET
                            : (row > 0)
                                    ? ANSI_GREEN + "Create  Success." + ANSI_RESET
                                    : ANSI_RED + "Can't Create" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 2:
                    row = r.delete();
                    state = (row > 0)
                            ? ANSI_GREEN + "Delete Success" + ANSI_RESET
                            : ANSI_RED + "Can't Delete" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 3:
                    break;
            }
        } while (menuId != 3);
    }

    interface checkInCheckOutInterface {

        int checkIn();

        int checkOut();

    }

    private void checkInCheckOut() {

        class checkInCheckOutViewLocal implements checkInCheckOutInterface {
            private int rs;

            @Override
            public int checkIn() {
                ArrayList<House> allHouse = rsc.getAllHouse();
                for (House house : allHouse) {
                    String stat = (house.getHouseStatus().equals("AVALIABLE")) ? ANSI_GREEN + house.getHouseStatus() + ANSI_RESET : ANSI_RED + house.getHouseStatus() + ANSI_RESET;
                    System.out.println(house.getHouseID() + ". " + house.getNameOfHouse() + " -> " + stat);
                }
                System.out.print("Select House Id : ");
                int id = sc.nextInt();
                System.out.println("");

                System.out.print("First Name : ");
                String firstname = sc.next();
                System.out.print("Last Name : ");
                String lastname = sc.next();
                System.out.print("Email : ");
                String email = sc.next();
                System.out.print("Age : ");
                int age = sc.nextInt();
                System.out.print("Phone Number : ");
                String phone = sc.next();

                System.out.println("");
                System.out.print("How many days stay : ");
                int day = sc.nextInt();
                String ps;

                do {
                    System.out.println("Payment confirmation");
                    System.out.print("[Y] : ");
                    ps = sc.next();
                    if (ps.equalsIgnoreCase("Y") || ps.equalsIgnoreCase("y")) {
                        rs = rsc.checkInCheckOut("I", new Customer(firstname, lastname, email, age, phone), id, day);
                    }
                } while (!ps.equalsIgnoreCase("Y") || !ps.equalsIgnoreCase("y"));

                return rs;
            }

            @Override
            public int checkOut() {
                String st;
                ArrayList<House> allHouse = rsc.getAllHouse();
                for (House house : allHouse) {
                    String stat = (house.getHouseStatus().equals("AVALIABLE")) ? ANSI_GREEN + house.getHouseStatus() + ANSI_RESET : ANSI_RED + house.getHouseStatus() + ANSI_RESET;
                    System.out.println(house.getHouseID() + ". " + house.getNameOfHouse() + " -> " + stat);
                }
                System.out.print("Select House Id : ");
                int id = sc.nextInt();
                do {
                    System.out.println("Check the house to see if the condition is perfect");
                    System.out.print("[Y] : ");
                    st = sc.next();
                    if (st.equalsIgnoreCase("Y") || st.equalsIgnoreCase("y")) {
                        rs = rsc.checkInCheckOut("O", new Customer(), id, 0);
                    }
                } while (!st.equalsIgnoreCase("Y") || !st.equalsIgnoreCase("y"));

                return rs;
            }

        };

        int menuId;
        int row;
        String state;
        do {
            System.out.println("<<Check In / Check Out>>");
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. Back to menu");
            System.out.print("Enter your menu [1-3]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 1:
                    row = new checkInCheckOutViewLocal().checkIn();
                    state = (row == -1)
                            ? ANSI_RED + "That house has been booked" + ANSI_RESET
                            : (row > 0)
                                    ? ANSI_GREEN + "Check In Success." + ANSI_RESET
                                    : ANSI_RED + "Can't CheckIn" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 2:
                    row = new checkInCheckOutViewLocal().checkOut();
                    state = (row > 0)
                            ? ANSI_GREEN + "Checkout Success" + ANSI_RESET
                            : ANSI_RED + "Can't Checkout" + ANSI_RESET;
                    System.out.println(state);
                    break;
                case 3:
                    break;
            }
        } while (menuId != 3);
    }
}
