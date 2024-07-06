package com.foodagg;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ItemDAO {
    public static void addItem(Item item) throws IOException{
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
        PreparedStatement ps = conn.prepareStatement("insert into items (name,price,type) values(?,?,?)");
        ps.setString(1,item.getName());
        ps.setDouble(2, item.getPrice());
        ps.setString(3, item.getType());
        int res = ps.executeUpdate();
        if (res > 0)
            System.out.println("done");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void bulkCopy(List<Item> items){
        items.forEach(a->{
            try {
                addItem(a);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
    public static List<Item> findItem(String keyType) throws IOException{
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        List<Item> resultList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
                    Item c = null;
                    PreparedStatement ps = conn.prepareStatement("select * from items where type = ?");
                    ps.setString(1, keyType);
                    ResultSet rs = ps.executeQuery();
                    int count = 0;
                    while (rs.next()) {
                        count++;
                        c = new Item(rs.getString(1), rs.getDouble(2), rs.getString(3));
                        resultList.add(c);
                    }         
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }
    public static List<Item> findItem(double keyPrice) throws IOException{
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        List<Item> resultList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
                    Item c = null;
                    PreparedStatement ps = conn.prepareStatement("select * from items where price = ?");
                    ps.setDouble(1, keyPrice);
                    ResultSet rs = ps.executeQuery();
                    int count = 0;
                    while (rs.next()) {
                        count++;
                        c = new Item(rs.getString(1), rs.getDouble(2), rs.getString(3));
                        resultList.add(c);
                    }         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
   
}
