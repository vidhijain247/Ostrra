package testq3;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlMain {
    private static final String URL = "jdbc:mysql://localhost:3306/food_aggregator";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void addItem(FoodItem item) throws SQLException {
        String query = "INSERT INTO item (name, price, type) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setString(3, item.getType());
            stmt.executeUpdate();
        }
    }

    public void bulkCopy(List<FoodItem> itemList) throws SQLException {
        for (FoodItem item : itemList) {
            addItem(item);
        }
    }

    public List<FoodItem> findItem(String type) throws SQLException {
        String query = "SELECT * FROM item WHERE type = ?";
        List<FoodItem> items = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new FoodItem(rs.getString("name"), rs.getDouble("price"), rs.getString("type")));
                }
            }
        }
        return items;
    }

    public List<FoodItem> findItem(Double price) throws SQLException {
        String query = "SELECT * FROM item WHERE price = ?";
        List<FoodItem> items = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, price);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new FoodItem(rs.getString("name"), rs.getDouble("price"), rs.getString("type")));
                }
            }
        }
        return items;
    }
}