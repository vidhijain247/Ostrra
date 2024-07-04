import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ItemDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/food_aggregator_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "Alina@07"; 

    public void addItem(Item item) {
        String query = "INSERT INTO items (name, price, type) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, item.getName());
            pst.setDouble(2, item.getPrice());
            pst.setString(3, item.getType());
            pst.executeUpdate();
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
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items WHERE type = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, type);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                items.add(new Item(
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    public List<Item> findItem(Double price) {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM items WHERE price = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDouble(1, price);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                items.add(new Item(
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getString("type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}

