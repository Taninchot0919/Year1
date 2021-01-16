
import dataaccess.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Test {

    static Scanner sc;

    public static void main(String[] args) {
//        readCSV("files/customers.csv");
        createCustomerTable();
    }

    public static void createCustomerTable() {

        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            try {
                stm.executeUpdate("DROP TABLE customer");
            } catch (SQLException ex) {
            }
            try {
                stm.executeUpdate("CREATE TABLE customer (cus_id INT NOT NULL,cus_name VARCHAR(100),PRIMARY KEY(cus_id))");
            } catch (SQLException ex) {
            }
        } catch (SQLException ex) {
            
        }
    }

    public static void readCSV(String file) {
        try {
            sc = new Scanner(new File(file));
            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found: " + ex.getMessage());
        } finally {
            sc.close();
        }
    }

}
