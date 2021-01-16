/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class TestJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
// 1. โหลด JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
// 2. ก ำหนด URL ส ำหรบัตดิ ตอ่ กบัฐำนขอ้ มลู
            String dbURL = "jdbc:mysql://localhost/walletauto?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Bangkok";
// 3. เชอื่ มตอ่ กบัฐำนขอ้ มลู
            Connection con = DriverManager.getConnection(dbURL, "root", "");
// 4. เตรยีมคำ สง่ั SQL ที่จะประมวลผล
            PreparedStatement pStatement = con.prepareStatement("SELECT * FROM tw_transactions ");
//            pStatement.setString(1, "poomttc");
// 5. สง่ คำ สง่ั SQL ไปยังฐำนข้อมูล
            ResultSet resultSet = pStatement.executeQuery();
// 6. อำ่ นผลลพั ธท์ ฐี่ ำนขอ้ มลู สง่ กลบั
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String numreference = resultSet.getString("id_kmutt");
                String point = resultSet.getString("point");
                String timestamp = resultSet.getString("timestamp");
                System.out.println("TestJDBC{id=" +id+",imessage="+name+",id_kmutt="+numreference+",point="+point+",date="+timestamp +"}");
            }
// 7. ปิดกำรเชอื่ มตอ่
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading driver: " + e);
        } catch (SQLException e) {
            System.err.println("Error database connection: " + e);
        }

    }
}
