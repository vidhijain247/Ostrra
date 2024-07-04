package com.foodag;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ItemDAO {
   private static void addItem(Item item) throws SQLException {
         Properties properties = new Properties();
           try (FileInputStream fis = new FileInputStream("db.properties")){
             properties.load(fis);
         } catch (IOException e) {
             e.printStackTrace();
         }
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USER");
        String password = properties.getProperty("PASSWORD");
        try {
        Connection conn = DriverManager.getConnection(url,user,password); 
        String name = item.getName();
        double price = item.getPrice();
        String type = item.getType();
        String insertSQL = "INSERT INTO std (Name,Price,Type) VALUES (?,?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, type);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
            }
        }
            catch (Exception e) {

        }
    }
    private static void bulkCopy(List<Item> items) throws SQLException {
        for(var i : items)
        {
            addItem(i);
        }
   }
   private static List<Item> findItem(String type) throws SQLException {
        Properties properties = new Properties();
           try (FileInputStream fis = new FileInputStream("db.properties")){
             properties.load(fis);
         } catch (IOException e) {
             e.printStackTrace();
         }
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USER");
        String password = properties.getProperty("PASSWORD");
        Connection conn = DriverManager.getConnection(url,user,password);
        List<Item> ans= new ArrayList<>();
        String searchSQL = "SELECT * FROM std WHERE Type = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
            pstmt.setString(1, type);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()){
                        String n=rs.getString("Name");
                        Double price = rs.getDouble("Price");
                        String Type=rs.getString("Type");
                        Item c= new Item(n,price,Type);
                        ans.add(c);        
                }
             }
        }
        return ans;
    }
   private static List<Item> findItemPrice(Double price) throws SQLException {
        Properties properties = new Properties();
           try (FileInputStream fis = new FileInputStream("db.properties")){
             properties.load(fis);
         } catch (IOException e) {
             e.printStackTrace();
         }
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USER");
        String password = properties.getProperty("PASSWORD");
        Connection conn = DriverManager.getConnection(url,user,password);
        List<Item> ans= new ArrayList<>();
        String searchSQL = "SELECT * FROM std WHERE Price = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
            pstmt.setDouble(1,price);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()){
                        String n=rs.getString("Name");
                        Double p = rs.getDouble("Price");
                        String Type=rs.getString("Type");
                        Item c= new Item(n,p,Type);
                        ans.add(c);        
                }
             }
        }
        return ans;
    }
}
