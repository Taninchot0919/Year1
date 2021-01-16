package Model.Service;

import Model.Customer.Customer;
import Model.Customer.CustomerDao;
import Model.Customer.CustomerDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author PIYATHIDATHANEEWAN
 */
public class CustomerService {

    private final CustomerDao customerDaoImpl = new CustomerDaoImpl();

    public int createCustomer(Customer customer) {
        return customerDaoImpl.createCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDaoImpl.getCustomerById(customerId);
    }

    public ArrayList<Customer> getAllCustomer() {
        return customerDaoImpl.getAllCustomer();
    }

    public int updateCustomer(Customer customer) {
        return customerDaoImpl.updateCustomer(customer);
    }

    public int deleteCustomer(int customerId) {
        return customerDaoImpl.deleteCustomer(customerId);
    }

}
