package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemDAO {
     static String url;
     static String user;
     static String password;


static {
    try (FileInputStream fis = new FileInputStream("food_db.properties")) {
        Properties properties = new Properties();
        properties.load(fis);
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public void addItem(Item item) {
        String sql = "INSERT INTO items (name, price, type) VALUES (?, ?, ?)";
        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setString(3, item.getType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void bulkCopy(List<Item> itemList) {
        for (Item item : itemList) {
            addItem(item);
        }
    }


    public List<Item> findItem(String type) {
        String sql = "SELECT * FROM items WHERE type = ?";
        List<Item> items = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getDouble("price"), rs.getString("type"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


    public List<Item> findItem(Double price) {
        String sql = "SELECT * FROM items WHERE price = ?";
        List<Item> items = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, price);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getDouble("price"), rs.getString("type"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}

