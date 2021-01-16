/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account.Account;
import Model.BookedHouse.BookedHouse;
import Model.Customer.Customer;
import Model.House.House;
import Model.House.HouseStatus;
import Model.Person.Person;
import Model.Service.AccountService;
import Model.Service.BookedHouseService;
import Model.Service.CustomerService;
import Model.Service.HouseService;
import Model.Service.PersonService;
import View.HouseServiceView;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Laptop
 */
public class HouseServiceController {

    public void startApplication() {
        HouseServiceView view = new HouseServiceView();
        view.initComponents();
    }

    public Account checkCredentials(String username, String password) {
        AccountService accountService = new AccountService();
        ArrayList<Account> allAccounts = accountService.getAllAccount();
        for (Account allAccount : allAccounts) {
            if (allAccount.getUsername().equals(username) && allAccount.getPassword().equals(password)) {
//                return accountService.getAccountById(allAccount.getAccountId()); O(n^2) เสียเวลา
                return allAccount;
            }
        }
        return null;
    }

    public ArrayList<Account> getAllAccount() {
        AccountService accountService = new AccountService();
        ArrayList<Account> allAccount = accountService.getAllAccount();
        return allAccount;
    }

    public ArrayList<House> getAllHouse() {
        HouseService houseService = new HouseService();
        ArrayList<House> allHouses = houseService.getAllHouse();
        return allHouses;
    }

    public ArrayList<House> getHouseAvaliable() {
        HouseService houseService = new HouseService();
        ArrayList<House> allHouses = houseService.getAllHouse();

        Iterator<House> iter = allHouses.iterator();
        while (iter.hasNext()) {
            House house = iter.next();
            if (house.getHouseStatus().equals("BOOKED")) {
                iter.remove();
            }
        }
//        for (House allHouse : allHouses) {
//            allHouse = allHouse.getHouseStatus().equals("BOOKED") ? allHouse : null;
//            allHouses.remove(allHouse); จะเกิด concurrentmodificationexception
//        }
        return allHouses;

    }

    public ArrayList<BookedHouse> getAllBookedHouse() {
        BookedHouseService bookedHouseService = new BookedHouseService();
        ArrayList<BookedHouse> allBookedHouses = bookedHouseService.getAllBookedHouse();
        return allBookedHouses;
    }

    public ArrayList<House> getHouseSchedule() {
        HouseService houseService = new HouseService();
        ArrayList<House> allHouses = houseService.getAllHouse();
        return allHouses;
    }

    interface crud {

        int create();

        int update();

        int delete();

    }

    public int manageHouse(String o, House house, int id) {
        int row = 0;

        crud r = new crud() {
            @Override
            public int create() {
                HouseService houseService = new HouseService();
                int rs = houseService.createHouse(house);
                return rs;
            }

            @Override
            public int update() {
                HouseService houseService = new HouseService();
                int rs = houseService.updateHouse(house);
                return rs;
            }

            @Override
            public int delete() {
                HouseService houseService = new HouseService();
                int rs = houseService.deleteHouse(id);
                return rs;
            }

        };

        switch (o) {
            case "C":
                row = r.create();
                break;
            case "U":
                row = r.update();
                break;
            case "D":
                row = r.delete();
                break;

        }
        return row;
    }

    interface crud1 {

        int create();

        int delete();

    }

    public int manageAccount(String o, Account account, int accountId) {
        int row = 0;
        crud1 r = new crud1() {
            int rs = 0;

            @Override
            public int create() {
                AccountService accountService = new AccountService();
                ArrayList<Account> allAccount = accountService.getAllAccount();

                for (Account account1 : allAccount) {
                    if (account1.getUsername().equals(account.getUsername())) {
                        rs = -1;
                        return rs;
                    }
                }

                rs = accountService.createAccount(account);

                return rs;

            }

            @Override
            public int delete() {
                if (accountId == 1) {
                    rs = 0;
                } else {
                    AccountService accountService = new AccountService();
                    PersonService personService = new PersonService();
                    Account account = accountService.getAccountById(accountId);
                    rs = accountService.deleteAccount(accountId);

                    int rt = personService.deletePerson(account.getPersonID());
                    if (rs > 0 && rt > 0) {
                        return rs;
                    } else {
                        rs = 0;
                    }
                }
                return rs;
            }

        };

        switch (o) {
            case "C":
                row = r.create();
                break;
            case "D":
                row = r.delete();
                break;

        }
        return row;
    }

    interface checkInCheckOutController {

        int checkIn();

        int checkOut();

    }

    public int checkInCheckOut(String o, Customer customer, int houseID, int day) {
        int row = 0;
        class checkInCheckOutControllerLocal implements checkInCheckOutController {

            private int rs = 0;
            private int customerID;

            @Override
            public int checkIn() {
                BookedHouseService bookedHouseService = new BookedHouseService();
                CustomerService customerService = new CustomerService();
                HouseService houseService = new HouseService();

                House house = houseService.getHouseById(houseID);

                ArrayList<BookedHouse> allBookedHouses = bookedHouseService.getAllBookedHouse();
                for (BookedHouse allBookedHouse : allBookedHouses) {
                    if (allBookedHouse.getHouseID() == houseID) {
                        rs = -1;
                        return rs;
                    }
                }
                ArrayList<Customer> allCustomers = customerService.getAllCustomer();
                for (Customer allCustomer : allCustomers) {
                    if (allCustomer.getFirstname().equals(customer.getFirstname()) && allCustomer.getLastname().equals(customer.getLastname())) {
                        customerID = allCustomer.getCustomerID();
                        break;
                    }
                }

                if (customerID == 0) {
                    rs = customerService.createCustomer(customer);
                } else {
                    rs = customerID;
                }

                house.setHouseStatus(HouseStatus.BOOKED.toString());
                houseService.updateHouse(house);

                Date date = new Date();
                Timestamp timestamp1 = new Timestamp(date.getTime());

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(timestamp1.getTime());

                // add a bunch of seconds to the calendar
                cal.add(Calendar.SECOND, 86400 * day);

                // create a second time stamp
                Timestamp timestamp2 = new Timestamp(cal.getTime().getTime());

                bookedHouseService.createBookedHouse(new BookedHouse(rs, houseID, timestamp1, timestamp2));

                return rs;
            }

            @Override
            public int checkOut() {
                int bookedHouseID = 0;
                BookedHouseService bookedHouseService = new BookedHouseService();
                HouseService houseService = new HouseService();

                ArrayList<BookedHouse> allBookedHouses = bookedHouseService.getAllBookedHouse();
                for (BookedHouse allBookedHouse : allBookedHouses) {
                    if (allBookedHouse.getHouseID() == houseID) {
                        bookedHouseID = allBookedHouse.getBookedHouseID();
                        break;
                    }
                }
                rs = bookedHouseService.deleteBookedHouse(bookedHouseID);
                House house = houseService.getHouseById(houseID);
                house.setHouseStatus(HouseStatus.AVALIABLE.toString());
                houseService.updateHouse(house);
                return rs;
            }
        };

        switch (o) {
            case "I":
                row = new checkInCheckOutControllerLocal().checkIn();
                break;
            case "O":
                row = new checkInCheckOutControllerLocal().checkOut();
                break;
        }

        return row;
    }
}
