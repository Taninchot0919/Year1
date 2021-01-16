package cinema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    private static final String DRIVERNAME = "org.apache.derby.jdbc.ClientDriver";
    private static final String URL = "jdbc:derby://localhost:1527/Cinema";
    private static final String USERNAME = "Cinema";
    private static final String PASSWORD = "Cinema";
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(DRIVERNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver is not found");
        }
        catch(SQLException e){
            System.out.println("Can not connect to database");
        }
        return con;
    }
}
