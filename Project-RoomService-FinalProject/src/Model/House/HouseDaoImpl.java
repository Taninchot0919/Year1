package Model.House;

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
public class HouseDaoImpl implements HouseDao {

    private final Connection conn = DatabaseController.connectDB();
    private final String SQL_CREATE_HOUSE = "INSERT INTO house (nameOfHourse, typeOfHourse, price, houseStatus) VALUES ( ?, ?, ?, ?)";
    private final String SQL_GET_HOUSE_BY_ID = "SELECT * FROM house WHERE HouseID=?";
    private final String SQL_GET_ALL_HOUSE = "SELECT * FROM house";
    private final String SQL_UPDATE_HOUSE = "UPDATE house SET nameOfHourse=?, typeOfHourse=?, price=? , houseStatus=? WHERE HouseID=?";
    private final String SQL_DELETE_HOUSE = "DELETE FROM house WHERE HouseID=?";

    @Override
    public int createHouse(House house) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_CREATE_HOUSE, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, house.getNameOfHouse());
            pstmt.setString(2, house.getTypeofHouse());
            pstmt.setDouble(3, house.getPrice());
            pstmt.setString(4, house.getHouseStatus());
            row = pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    house.setHouseID(generatedKeys.getInt(1));
                }
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("An error has occurred.");
            System.out.println("See full details below.");
            Logger.getLogger(HouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public House getHouseById(int houseId) {
        House house = new House();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_HOUSE_BY_ID)) {
            pstmt.setInt(1, houseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    house.setHouseID(rs.getInt(1));
                    house.setNameOfHouse(rs.getString(2));
                    house.setTypeofHouse(rs.getString(3));
                    house.setPrice(rs.getDouble(4));
                    house.setHouseStatus(rs.getString(5));
                }
            }
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(HouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return house;
    }

    @Override
    public ArrayList<House> getAllHouse() {
        ArrayList<House> allHouse = new ArrayList();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_GET_ALL_HOUSE);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                House house = new House();
                house.setHouseID(rs.getInt(1));
                house.setNameOfHouse(rs.getString(2));
                house.setTypeofHouse(rs.getString(3));
                house.setPrice(rs.getDouble(4));
                house.setHouseStatus(rs.getString(5));
                allHouse.add(house);
            }
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(HouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allHouse;

    }

    @Override
    public int updateHouse(House house) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE_HOUSE)) {
            pstmt.setString(1, house.getNameOfHouse());
            pstmt.setString(2, house.getTypeofHouse());
            pstmt.setDouble(3, house.getPrice());
            pstmt.setString(4, house.getHouseStatus());
            pstmt.setInt(5, house.getHouseID());
            row = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(HouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    @Override
    public int deleteHouse(int houseId) {
        int row = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE_HOUSE)) {
            pstmt.setInt(1, houseId);
            row = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(HouseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
