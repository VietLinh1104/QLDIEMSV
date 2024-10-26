/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom2.qlsv.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DBConnect {
    
    public static Connection getConnection() {
        Connection cons = null;
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to database
            cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsv", "vietlinh", "622004");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();  // In lỗi ra console để dễ dàng debug
        }
        return cons;
    }

    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
               System.out.println(c.toString());
               c.close();  // Đóng kết nối sau khi sử dụng
            
            
    } 
}
                
                
            




    
    

