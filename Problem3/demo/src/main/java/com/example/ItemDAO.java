package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    
    public void addItem(Item item) throws SQLException {
        Connection connection = getConnection();
    
        String sql = "INSERT INTO items (name, price, type) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
    
        statement.setString(1, item.getName());
        statement.setDouble(2, item.getPrice());
        statement.setString(3, item.getType());
    
        statement.executeUpdate();
    
        statement.close();
        connection.close();
    }
  
    public void bulkCopy(List<Item> itemList) throws SQLException {
      for (Item item : itemList) {
        addItem(item);
      }
    }
  
    public List<Item> findItem(String type) throws SQLException {
      List<Item> items = new ArrayList<>();
  
      Connection connection = getConnection();
  
      String sql = "SELECT * FROM items WHERE type = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
  
      statement.setString(1, type);
  
      ResultSet resultSet = statement.executeQuery();
  
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        Double price = resultSet.getDouble("price");
        String retrievedType = resultSet.getString("type");
  
        items.add(new Item(name, price, retrievedType));
      }
  
      resultSet.close();
      statement.close();
      connection.close();
  
      return items;
    }
  
    public List<Item> findItem(Double price) throws SQLException {
      List<Item> items = new ArrayList<>();
  
      Connection connection = getConnection();
  
      String sql = "SELECT * FROM items WHERE price = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
  
      statement.setDouble(1, price);
  
      ResultSet resultSet = statement.executeQuery();
  
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        Double retrievedPrice = resultSet.getDouble("price");
        String type = resultSet.getString("type");
  
        items.add(new Item(name, retrievedPrice, type));
      }
  
      resultSet.close();
      statement.close();
      connection.close();
  
      return items;
    }
  
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

      String url = "jdbc:mysql://localhost:3306/osttra";
      String user = "root";
      String password = "root";

       return DriverManager.getConnection(url, user, password);
    }
}
  
