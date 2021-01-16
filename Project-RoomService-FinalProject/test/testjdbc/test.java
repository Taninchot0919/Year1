/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjdbc;

import Controller.DatabaseController;
import Model.Account.Account;
import Model.BookedHouse.BookedHouse;
import Model.Customer.Customer;
import Model.Person.Person;
import Model.Person.Rank;
import Model.Service.AccountService;
import Model.Service.BookedHouseService;
import Model.Service.CustomerService;
import Model.Service.PersonService;
import com.mysql.cj.util.StringUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class test {
    
    public static void main(String[] args) {
        testAccount();
        testCustomer();
        testPerson();
        DatabaseController c = new DatabaseController();
        ResultSet resultSet;
        BookedHouseService bookedHouseService = new BookedHouseService();
        List<BookedHouse> bookedHouseList = bookedHouseService.getAllBookedHouse();
        
        int i = 0;
        //            while (resultSet.next()) {
////                int BookedHouseID = resultSet.getInt("BookedHouseID"); //อ่าน colum id 
////                int customerID = resultSet.getInt("customerID");
////                int houseID = resultSet.getInt("houseID");
////                String checkInDate = resultSet.getString("checkInDate");
////                String checkOutDate = resultSet.getString("checkOutDate");
////                double fine = resultSet.getDouble("fine");
////
//////                 customers[i++] = new Customer(id,name,numreference,point,timestamp);
////                customerList.add(new BookedHouse(BookedHouseID, customerID, houseID, checkInDate, checkOutDate,fine));
////                System.out.println("TestJDBC{id=" + id + ",imessage=" + name + ",numreference=" + numreference + ",point=" + point + ",date=" + timestamp + "}");
//            }

//            for (Customer customer : customers) {
//                System.out.println(customer);
//            }
//        System.out.println(bookedHouseList);
        System.out.println("");
        System.out.println("GetAllBookedHouse");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %20s\t %16s\t %5s", "ID", "CustomerID", "HouseID", "CheckInDate", "CheckOutDate");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (BookedHouse bookedHouse : bookedHouseList) {
            System.out.format("%10s %15s %15s\t %10s\t %5s",
                    bookedHouse.getBookedHouseID(), bookedHouse.getCustomerID(), bookedHouse.getHouseID(), bookedHouse.getCheckIndate(), bookedHouse.getCheckOutdate());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

//            System.out.println(c.disconnect());
    }
    
    public static void testAccount() {
        AccountService accountService = new AccountService();
        int row = accountService.createAccount(new Account("mew556", "12345", 1, 0));
        System.out.println(row);
        ArrayList<Account> allAccounts = accountService.getAllAccount();
        System.out.println("GetAllAccount");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %20s\t ", "ID", "Username", "password");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Account allAccount : allAccounts) {
            System.out.format("%10s %15s %20s\t ",
                    allAccount.getAccountId(), allAccount.getUsername(), allAccount.getPassword());
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println(test.getAllAccount());

    }
    
    public static void testCustomer() {
        CustomerService customerService = new CustomerService();
        ArrayList<Customer> allCustomers = customerService.getAllCustomer();
        
        System.out.println("Get All Customer");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %20s\t %20s\t %20s\t %20s\t", "CustomerID", "firstname", "lastname", "email", "age", "phone");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Customer allCustomer : allCustomers) {
            System.out.format("%10s %15s %20s\t %20s\t %20s\t %20s\t",
                    allCustomer.getCustomerID(), allCustomer.getFirstname(), allCustomer.getLastname(), allCustomer.getEmail(), allCustomer.getAge(), allCustomer.getPhone());
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public static void testPerson() {
        PersonService personService = new PersonService();
       int row = personService.createPerson(new Person("Panus", "kotrajarus", "0948219901","STAFF"));
        ArrayList<Person> allPerson = personService.getAllPerson();
        
    }
}
