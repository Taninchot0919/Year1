package cinema;

import Customer_Model.Customer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDatabaseIMP implements CustomerDatabase {

    @Override
    public int insert(Customer obj) {
        String sql = "INSERT INTO CUSTOMERS VALUES(?,?,?,?,?)";
        int nRow = 0;
        try (Connection con = DataConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, obj.getLocation());
            pstm.setString(2, obj.getPhone());
            pstm.setBigDecimal(3, BigDecimal.valueOf(obj.getPersonId()));
            pstm.setString(4, obj.getFirstname());
            pstm.setString(5, obj.getLastname());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return nRow;
    }

    @Override
    public GenList<Customer> searchById(long id) {
        String sql = "DELETE FROM CUSTOMERS WHERE ID = ?";
        GenList<Customer> cus = new GenList<>();
        try (Connection con = DataConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setBigDecimal(3, BigDecimal.valueOf(id));
        } catch (SQLException e) {

        }
        return cus;
    }

    @Override
    public int delete(Customer obj) {
        String sql = "DELETE FROM CUSTOMERS WHERE ID = ?";
        int nRow = 0;
        try (Connection con = DataConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setBigDecimal(3, BigDecimal.valueOf(obj.getPersonId()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nRow;

    }

    @Override
    public int update(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GenList<Customer> getAll() {
        GenList<Customer> cus = new GenList<>();
        try (Connection con = DataConnection.getConnection();
                Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");
            while (rs.next()) {
                cus.add(new Customer(rs.getString("Loaction"), rs.getString("Phone"), rs.getLong("PersonId"), rs.getString("Firstname"), rs.getString("Lastname")));

            }

        } catch (SQLException ex) {

        }
        return cus;
    }

}
