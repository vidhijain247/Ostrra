package com.university;

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

public class CollegeBO {
public static List<College> findCollege(List<String> nameList) throws IOException {
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        List<College> resultList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
                    nameList.forEach(curr->{
                        try {
                            College res=searchClgByName(conn, curr);
                            if(res!=null) resultList.add(res);
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;

    }
    public static List<College> findCollege(Date keyStartingDate) throws IOException {
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        List<College> resultList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
                    College c = null;
                    PreparedStatement ps = conn.prepareStatement("select * from college where startingdate = ?");
                    java.sql.Date d=(java.sql.Date) (keyStartingDate);
                    ps.setDate(1, d);
                    ResultSet rs = ps.executeQuery();
                    int count = 0;
                    while (rs.next()) {
                        count++;
                        c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                                rs.getString(6), rs.getDate(7));
                        resultList.add(c);
                    }         
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;

    }
    public static List<College> findCollege(String keyLocation) throws IOException {
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        List<College> resultList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
                    College c = null;
                    PreparedStatement ps = conn.prepareStatement("select * from college where location = ?");
                    ps.setString(1, keyLocation);
                    ResultSet rs = ps.executeQuery();
                    int count = 0;
                    while (rs.next()) {
                        count++;
                        c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                                rs.getString(6), rs.getDate(7));
                        resultList.add(c);
                    }         
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;

    }
    public static void main(String[] args) throws IOException {
        FileInputStream f = new FileInputStream("dbProp.txt");
        Properties p = new Properties();
        p.load(f);
        List<College> resultList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"),
                p.getProperty("pass"))) {
                    printAll(conn); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static College searchClgByName(Connection conn, String currName) throws SQLException {
        College c = null;
        PreparedStatement ps = conn.prepareStatement("select * from college where name = ?");
        ps.setString(1, currName);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count++;
            c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                    rs.getString(6), rs.getDate(7));
        }
        if (count == 0) {
            System.out.println("NO STUDENT FOUND");
            return null;
        } else
            return c;
    }
    private static void printAll(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from college");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            College c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                    rs.getString(6), rs.getDate(7));
            System.out.println(c);
        }
    }
}
