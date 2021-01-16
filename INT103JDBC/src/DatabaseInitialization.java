


import dataaccess.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DatabaseInitialization {

    public static void main(String[] args) {
        createTables();
        initializeDb(true);
    }
    
    public static void reNew() {
        createTables();
        initializeDb(false);
    }
    
    private static void createTables() {

        try (Connection conn = DBConnection.getConnection();
                Statement stm = conn.createStatement()) {
            try {stm.executeUpdate("DROP TABLE customer");} catch (SQLException ex) {}         
            try {stm.executeUpdate("DROP TABLE product");} catch (SQLException ex) {}   
            try {stm.executeUpdate("DROP TABLE wishlist");} catch (SQLException ex) {}  
            
            try {stm.executeUpdate("CREATE TABLE customer (cus_id INT NOT NULL, cus_name VARCHAR(100),PRIMARY KEY (cus_id))");} catch (SQLException ex) {} 
            try {stm.executeUpdate("CREATE TABLE product (pro_id INT NOT NULL, pro_name VARCHAR(100),price DOUBLE,PRIMARY KEY (pro_id))");} catch (SQLException ex) {} 
            try {stm.executeUpdate("CREATE TABLE wishlist (cus_id INT NOT NULL, pro_id INT NOT NULL,PRIMARY KEY (cus_id,pro_id))");} catch (SQLException ex) {} 
        }catch (Exception ex) {
            System.out.println(ex.getMessage()+" แก้ไขตามคำแนะนำด้านบน แล้ว Run ใหม่จนกว่าจะผ่าน");
        }
    }

    private static void initializeDb(boolean show) {
       String sqlProduct="INSERT INTO product VALUES(?,?,?)";
       String sqlCustomer="INSERT INTO customer VALUES(?,?)";
       String sqlWishlist="INSERT INTO wishlist VALUES(?,?)";
        try(Connection conn = DBConnection.getConnection();
                PreparedStatement stm = conn.prepareStatement(sqlProduct);
                PreparedStatement stmC = conn.prepareStatement(sqlCustomer);
                PreparedStatement stmW = conn.prepareStatement(sqlWishlist)) {
            Scanner sc;
//            read product from csv file
            try {
                if(show)System.out.println("\n--- Import Product ---");
                sc=new Scanner(new File("files/products.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stm.setInt(1, Integer.parseInt(temp[0]));
                        stm.setString(2, temp[1]);
                        stm.setDouble(3, Double.parseDouble(temp[2]));
                        stm.executeUpdate();
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                
            }
//            read customer from csv file
            try {
                if(show)System.out.println("\n--- Import Customer ---");
                sc=new Scanner(new File("files/customers.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmC.setInt(1, Integer.parseInt(temp[0]));
                        stmC.setString(2, temp[1]);
                        stmC.executeUpdate();
                        if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
//            read wishlist from csv file
            try {
                if(show)System.out.println("\n--- Import Wishlist ---");
                sc=new Scanner(new File("files/wishlist.csv"));
                String line;
                try{
                    while((line=sc.nextLine())!=null){
                        String[] temp=line.split(",");
                        stmW.setInt(1, Integer.parseInt(temp[0]));
                        stmW.setInt(2, Integer.parseInt(temp[1]));
                        stmW.executeUpdate();
                       if(show)System.out.println("Insert: "+line);
                    }
                }catch(NoSuchElementException ex){}
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}


