/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Customer;

import Model.Account.Account;
import java.util.ArrayList;

/**
 *
 * @author PIYATHIDATHANEEWAN
 */
public interface CustomerDao {

    public int createCustomer(Customer customer);

    public Customer getCustomerById(int customerId);

    public ArrayList<Customer> getAllCustomer();

    public int updateCustomer(Customer customer);

    public int deleteCustomer(int customer);

}
