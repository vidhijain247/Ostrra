package com.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class CollegeBo {
    private static List<College> searchRecord(List<String> names) throws SQLException {
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
        List<College> ans= new ArrayList<>();
        for(var name: names){
        String searchSQL = "SELECT * FROM std WHERE name > ?";
        try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()){
                        String n=rs.getString("Name");
                        String website= rs.getString("Website");
                        String mobile=rs.getString("Mobile");
                        String founder= rs.getString("Founder");
                        int numberOfDept=rs.getInt("Dept");
                        String location=rs.getString("Location");
                        Date startingDate= rs.getDate("StartDate");
                        College c= new College(n, website, mobile, founder, numberOfDept, location, startingDate);
                        ans.add(c);
                    }        
                }
             }
        }
        return ans;
    }
    private static List<College> searchRecord(Date starDate) throws SQLException {
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
        List<College> ans= new ArrayList<>();
        java.sql.Date x = (java.sql.Date) starDate;
        String searchSQL = "SELECT * FROM std WHERE Date = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
            pstmt.setDate(1, x);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()){
                        String n=rs.getString("Name");
                        String website= rs.getString("Website");
                        String mobile=rs.getString("Mobile");
                        String founder= rs.getString("Founder");
                        int numberOfDept=rs.getInt("Dept");
                        String location=rs.getString("Location");
                        Date startingDate= rs.getDate("StartDate");
                        College c= new College(n, website, mobile, founder, numberOfDept, location, startingDate);
                        ans.add(c);        
                }
             }
        }
        return ans;
    }
    private static List<College> searchRecord(String loc) throws SQLException {
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
        List<College> ans= new ArrayList<>();
        String searchSQL = "SELECT * FROM std WHERE Location = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
            pstmt.setString(1, loc);
            try (ResultSet rs = pstmt.executeQuery()) {
                while(rs.next()){
                        String n=rs.getString("Name");
                        String website= rs.getString("Website");
                        String mobile=rs.getString("Mobile");
                        String founder= rs.getString("Founder");
                        int numberOfDept=rs.getInt("Dept");
                        String location=rs.getString("Location");
                        Date startingDate= rs.getDate("StartDate");
                        College c= new College(n, website, mobile, founder, numberOfDept, location, startingDate);
                        ans.add(c);        
                }
             }
        }
        return ans;
    }
    static void sortCollegeName(List<College>colleges){
        Collections.sort(colleges, new Comparator<College>() {
            @Override
            public int compare(College s1, College s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        for (College c : colleges) {
            System.out.println(c);
        }
    }
    static void sortCollegeStartDate(List<College>colleges){
        Collections.sort(colleges, new Comparator<College>() {
            @Override
            public int compare(College s1, College s2) {
                return s1.getStartingDate().compareTo(s2.getStartingDate());
            }
        });
        for (College c : colleges) {
            System.out.println(c);
        }
    }
    static void sortCollegeDept(List<College>colleges){
        Collections.sort(colleges, new Comparator<College>() {
            @Override
            public int compare(College s1, College s2) {
                return s1.getNumberOfDept()>s2.getNumberOfDept()?1:-1;
            }
        });
        for (College c : colleges) {
            System.out.println(c);
        }
    }
}
