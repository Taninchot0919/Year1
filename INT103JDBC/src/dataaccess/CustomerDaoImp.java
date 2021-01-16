/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.GeneralList;
import model.dao.CustomerDao;

/**
 *
 * @author TANINCHOTPHUWALOERTT
 */
public class CustomerDaoImp implements CustomerDao {

    @Override
    public int insert(Customer customer) {
        int nRow = 0;
        String sql = "INSERT INTO customer VALUES( ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, customer.getCus_id());
            pstm.setString(2, customer.getCus_name());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return nRow;
    }

    @Override
    public int delete(int customer) {
    }

    @Override
    public int update(Customer customer) {

    }

    @Override
    public Customer findById(int id) {

    }

    @Override
    public GeneralList<Customer> findByName(String name) {

    }

    @Override
    public GeneralList<Customer> getAll() {
        GeneralList<Customer> custs = new GeneralList<>();
        try(Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
                ResultSet rs = stm.executeQuery("SELECT * FROM customer");
                while(rs.next()){
                    custs.add(new Customer(rs.getInt("cus_id"),rs.getString("cus_name")));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return custs;
    }

}
