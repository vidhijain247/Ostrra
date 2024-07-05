package edu.osttra.training.FoodAggregator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemDAO {

    public void addItem(Item item) throws IOException {
        try {
            Properties p = new Properties();
            InputStream is =new FileInputStream("foodAgg.properties");
            p.load(is);

            Connection con = DriverManager.getConnection(p.getProperty("CONNECTION_URL"), p.getProperty("USER_NAME"), p.getProperty("PASSWORD"));
            Class.forName(p.getProperty("DRIVER_NAME"));

            PreparedStatement stat = con.prepareStatement("insert into foodAgg (name,price,type) values(?,?,?)");
            stat.setString(1, item.getName());
            stat.setDouble(2, item.getPrice());
            stat.setString(3, item.getType());
            int response = stat.executeUpdate();
            if(response > 0) {
                System.out.println("Data Inserted!");
            } else {
                System.out.println("Something went wrong!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void bulkCopy(List<Item> itemList) {
        itemList.forEach(item->{
            try {
                addItem(item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<Item> findItem(String type) {
        List<Item> result = new ArrayList<>();
        try {
            Properties p = new Properties();
            InputStream is =new FileInputStream("foodAgg.properties");
            p.load(is);

            Connection con = DriverManager.getConnection(p.getProperty("CONNECTION_URL"), p.getProperty("USER_NAME"), p.getProperty("PASSWORD"));
            Class.forName(p.getProperty("DRIVER_NAME"));

            PreparedStatement stat = con.prepareStatement("select* from foodAgg where type = ?");
            stat.setString(1, type);
            ResultSet rs = stat.executeQuery();

            while(rs.next()) {
                Item i = new Item(rs.getString(1), rs.getDouble(2), rs.getString(3));
                result.add(i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Item> findItem(double price) {
        List<Item> result = new ArrayList<>();
        try {
            Properties p = new Properties();
            InputStream is =new FileInputStream("foodAgg.properties");
            p.load(is);

            Connection con = DriverManager.getConnection(p.getProperty("CONNECTION_URL"), p.getProperty("USER_NAME"), p.getProperty("PASSWORD"));
            Class.forName(p.getProperty("DRIVER_NAME"));

            PreparedStatement stat = con.prepareStatement("select* from foodAgg where price = ?");
            stat.setDouble(1, price);
            ResultSet rs = stat.executeQuery();

            while(rs.next()) {
                Item i = new Item(rs.getString(1), rs.getDouble(2), rs.getString(3));
                result.add(i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
