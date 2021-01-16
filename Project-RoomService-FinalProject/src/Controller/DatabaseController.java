/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Laptop
 */
import Model.Customer.Customer;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class DatabaseController {

    private static final String db_name = "guest_house_management_system";
    private static final String user = "root";
    private static final String pass = "";
    private static final String hostName = "localhost";
    private static final String db_driver = "com.mysql.jdbc.Driver";

    //กำหนด URL สำหรับเชื่อมต่อบานข้อมูล
    private static final String dbURL = "jdbc:mysql://" + hostName + "/" + db_name + "?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Bangkok";
    private static Connection con = null;
    private static ResultSet resultSet = null;
    /**
     * @param args the command line arguments
     */
    public DatabaseController() {
//        connectDB(); // เรียกใช้ class ผ่าน object    นี้แล้ว connect 
    }

    public static Connection connectDB() {
        try {
            Class.forName(db_driver);
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading driver: " + e);
        } catch (SQLException e) {
            System.err.println("Error database connection: " + e);
        }
        return con;
    }


}
