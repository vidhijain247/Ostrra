import java.sql.*;
import java.util.*;

public class ItemDAO {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/test";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    public void addItem(Item item) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO items (name, price, type) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, item.getName());
                stmt.setDouble(2, item.getPrice());
                stmt.setString(3, item.getType());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void bulkCopy(List<Item> list) {
        for (Item item : list) {
            addItem(item);
        }
    }

    public List<Item> findItem(String type) {
        List<Item> items = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM items WHERE type = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, type);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    String itemType = rs.getString("type");
                    Item item = new Item(name, price, itemType);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return items;
    }

    public List<Item> findItem(Double price) {
        List<Item> items = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM items WHERE price = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, price);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    double itemPrice = rs.getDouble("price");
                    String type = rs.getString("type");
                    Item item = new Item(name, itemPrice, type);
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return items;
    }
}