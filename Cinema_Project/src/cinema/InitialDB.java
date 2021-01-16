package cinema;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InitialDB {

    public static void main(String[] args) {
        createTables();
        initializeDB(true);
    }
        public static void reNew() {
        createTables();
        initializeDB(false);
    }

    private static void createTables() {
        try (Connection con = DataConnection.getConnection();
                Statement stmt = con.createStatement()) {
            try {
                stmt.executeUpdate("DROP TABLE Customers");
            } catch (SQLException ex) {
            }
            try {
                stmt.executeUpdate("CREATE TABLE Customers(Loaction VARCHAR(50) NOT NULL, "
                        + "Phone CHAR(50) NOT NULL, "
                        + "PersonId BIGINT NOT NULL, "
                        + "Firstname VARCHAR(50) NOT NULL, "
                        + "Lastname VARCHAR(50) NOT NULL,"
                        + "PRIMARY KEY (PersonId))");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initializeDB(boolean show) {
        String sqlCustomers = "INSERT INTO Customers VALUES(?,?,?,?,?)";
        try (Connection con = DataConnection.getConnection();
                PreparedStatement stmC = con.prepareStatement(sqlCustomers)) {
            Scanner sc;
            try {
                if (show) {
                    System.out.println("\n--- Import Customer ---");
                    sc = new Scanner(new File("files/customers.csv"));
                    String line;

                    try {
                        while ((line = sc.nextLine()) != null) {
                            String temp[] = line.split(",");
                            stmC.setString(1, temp[0]);
                            stmC.setString(2, temp[1]);
                            stmC.setBigDecimal(3, BigDecimal.valueOf(Long.parseLong(temp[2])));
                            stmC.setString(4, temp[3]);
                            stmC.setString(5, temp[4]);
                            stmC.executeUpdate();
                            if (show) {
                                System.out.println("Insert: " + line);
                            }
                        }
                    } catch (NoSuchElementException ex) {

                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
