/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BookedHouse;

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
 * @author Laptop
 */
public class BookedHouseDaoImpl implements BookedHouseDao {

    private final Connection conn = DatabaseController.connectDB();
    private final String SQL_CREATE_BOOKEDHOUSE = "INSERT INTO bookedhouse (customerID, houseID, checkInDate, checkOutDate) VALUES ( ?, ?, ?, ?)";
    private final String SQL_GET_BOOKEDHOUSE_BY_ID = "SELECT * FROM bookedhouse WHERE BookedHouseID=?";
    private final String SQL_GET_ALL_BOOKEDHOUSE = "SELECT * FROM bookedhouse";
    private final String SQL_UPDATE_BOOKEDHOUSE = "UPDATE bookedhouse SET customerID=?, houseID=?, checkInDate=?, checkOutDate=? WHERE BookedHouseID=?";
    private final String SQL_DELETE_BOOKEDHOUSE = "DELETE FROM bookedhouse WHERE BookedHouseID=?";

    @Override
    public int createBookedHouse(BookedHouse bookedHouse) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_BOOKEDHOUSE, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, bookedHouse.getCustomerID());
            pstmt.setInt(2, bookedHouse.getHouseID());
            pstmt.setTimestamp(3, bookedHouse.getCheckIndate());
            pstmt.setTimestamp(4, bookedHouse.getCheckOutdate());
            row = pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    bookedHouse.setBookedHouseID(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookedHouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public BookedHouse getBookedHouseById(int bookHouseID) {
        BookedHouse bookedHouse = new BookedHouse();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_BOOKEDHOUSE_BY_ID)) {
            pstmt.setInt(1, bookHouseID);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    bookedHouse.setBookedHouseID(rs.getInt(1));
                    bookedHouse.setCustomerID(rs.getInt(2));
                    bookedHouse.setHouseID(rs.getInt(3));
                    bookedHouse.setCheckIndate(rs.getTimestamp(4));
                    bookedHouse.setCheckOutdate(rs.getTimestamp(5));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookedHouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookedHouse;
    }

    @Override
    public ArrayList<BookedHouse> getAllBookedHouse() {
        ArrayList<BookedHouse> allBookedHouse = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_BOOKEDHOUSE);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                BookedHouse bookedHouse = new BookedHouse();
                bookedHouse.setBookedHouseID(rs.getInt(1));
                bookedHouse.setCustomerID(rs.getInt(2));
                bookedHouse.setHouseID(rs.getInt(3));
                bookedHouse.setCheckIndate(rs.getTimestamp(4));
                bookedHouse.setCheckOutdate(rs.getTimestamp(5));
                allBookedHouse.add(bookedHouse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookedHouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allBookedHouse;
    }

    @Override
    public int updateBookedHouse(BookedHouse bookedHouse) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_BOOKEDHOUSE)) {
            pstmt.setInt(1, bookedHouse.getCustomerID());
            pstmt.setInt(2, bookedHouse.getHouseID());
            pstmt.setTimestamp(3, bookedHouse.getCheckIndate());
            pstmt.setTimestamp(4, bookedHouse.getCheckOutdate());
            pstmt.setInt(6, bookedHouse.getBookedHouseID());
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookedHouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int deleteBookedHouse(int bookHouseID) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_BOOKEDHOUSE)) {
            pstmt.setInt(1, bookHouseID);
            row = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookedHouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

}
