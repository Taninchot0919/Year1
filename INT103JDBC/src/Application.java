
import dataaccess.CustomerDaoImp;
import java.util.Scanner;
import model.Customer;
import model.GeneralList;
import model.dao.CustomerDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TANINCHOTPHUWALOERTT
 */
public class Application {

    public static void main(String[] args) {
        String menu = "Select menu :\n"
                + "1.Add Customer \n"
                + "2.List All Customer \n"
                + "0.Exit\n"
                + "-----Select : ";
        int key;
        CustomerDao custDao = new CustomerDaoImp();
        do {
            Scanner input = new Scanner(System.in);
            System.out.print(menu);
            key = input.nextInt();
            switch(key){
                case 1:
                    custDao.insert(new Customer(1,"Art"));
                    break;
                case 2:
                    GeneralList<Customer> custs = custDao.getAll();
                    System.out.println(custs.toString());
                    break;
            }
        } while (key != 0);
    }
}
