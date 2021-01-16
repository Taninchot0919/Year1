package cinema;

import Customer_Model.Customer;

public interface CustomerDatabase {
    int insert(Customer obj);
    int delete(Customer obj);
    int update(Customer obj);
    GenList<Customer> searchById(long id);
    GenList<Customer> getAll();
}
