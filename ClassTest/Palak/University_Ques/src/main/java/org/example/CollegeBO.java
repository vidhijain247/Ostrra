package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class CollegeBO {
   static String url;
    static String user;
    static String password;


    static {
        try (FileInputStream fis = new FileInputStream("uni_DB.properties")) {
            Properties properties = new Properties();
            properties.load(fis);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<College> findCollege(List<String> nameList) {
        List<College> colleges = new ArrayList<>();
        String sql = "SELECT * FROM colleges WHERE name IN (" + nameList.stream().map(name -> "?").collect(Collectors.joining(",")) + ")";

        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {

            for (int i = 0; i < nameList.size(); i++) {
                ps.setString(i + 1, nameList.get(i));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                colleges.add(mapResultSetToCollege(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }


    public List<College> searchByDate(Date startDate) {
        List<College> colleges = new ArrayList<>();
        String sql = "SELECT * FROM colleges WHERE startingDate = ?";

        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(startDate.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                colleges.add(mapResultSetToCollege(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }

    public List<College> findByLocation(String location) {
        List<College> colleges = new ArrayList<>();
        String sql = "SELECT * FROM colleges WHERE location = ?";

        try (Connection c = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, location);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                colleges.add(mapResultSetToCollege(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colleges;
    }


    public void sortCollegesName(List<College> collegeList) {
        collegeList.sort((c1, c2) -> c1.getName().compareTo(c2.getName()));
        for (College c : collegeList) {
            System.out.println(c);
        }
    }


    public void sortCollegesByDate(List<College> collegeList) {
        collegeList.sort((c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));
        for (College c : collegeList) {
            System.out.println(c);
        }
    }


    public void sortCollegesDept(List<College> collegeList) {
        collegeList.sort((c1, c2) -> {
            return c1.getNumberOfDept();

        });
        for (College c : collegeList) {
            System.out.println(c);
        }
    }


    private College mapResultSetToCollege(ResultSet rs) throws SQLException {
        return new College(
                rs.getString("name"),
                rs.getString("website"),
                rs.getString("mobile"),
                rs.getString("founder"),
                rs.getInt("numberOfDept"),
                rs.getString("location"),
                rs.getDate("startingDate")
        );
    }
}

