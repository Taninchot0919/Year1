package Model.Customer;

import Controller.DatabaseController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PIYATHIDATHANEEWAN
 */
public class CustomerDaoImpl implements CustomerDao {

    private final Connection conn = DatabaseController.connectDB();
    private final String SQL_CREATE_CUSTOMER = "INSERT INTO customer (firstName, lastName, email, age, phone) VALUES ( ?, ?, ?, ?, ?)";
    private final String SQL_GET_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE CustomerID=?";
    private final String SQL_GET_ALL_CUSTOMER = "SELECT * FROM customer";
    private final String SQL_UPDATE_CUSTOMER = "UPDATE customer SET firstName=?, lastName=?, email=?, age=?, phone=? WHERE CustomerID=?";
    private final String SQL_DELETE_CUSTOMER = "DELETE FROM customer WHERE CustomerID=?";

    @Override
    public int createCustomer(Customer customer) {
        int id = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_CUSTOMER, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getFirstname());
            pstmt.setString(2, customer.getLastname());
            pstmt.setString(3, customer.getEmail());
            pstmt.setInt(4, customer.getAge());
            pstmt.setString(5, customer.getPhone());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = new Customer();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_CUSTOMER_BY_ID)) {
            pstmt.setInt(1, customerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    customer.setCustomerID(rs.getInt(1));
                    customer.setFirstname(rs.getString(2));
                    customer.setLastname(rs.getString(3));
                    customer.setEmail(rs.getString(4));
                    customer.setAge(rs.getInt(5));
                    customer.setPhone(rs.getString(6));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> allCustomer = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_CUSTOMER);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt(1));
                customer.setFirstname(rs.getString(2));
                customer.setLastname(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setAge(rs.getInt(5));
                customer.setPhone(rs.getString(6));
                allCustomer.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allCustomer;
    }

    @Override
    public int updateCustomer(Customer customer) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_CUSTOMER)) {
            pstmt.setString(1, customer.getFirstname());
            pstmt.setString(2, customer.getLastname());
            pstmt.setString(3, customer.getEmail());
            pstmt.setInt(4, customer.getAge());
            pstmt.setString(5, customer.getPhone());
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int deleteCustomer(int customerId) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_CUSTOMER)) {
            pstmt.setInt(1, customerId);
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
