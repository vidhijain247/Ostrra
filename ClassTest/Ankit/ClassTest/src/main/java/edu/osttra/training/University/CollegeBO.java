package edu.osttra.training.University;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class CollegeBO {

    public List<College> findCollege(List<String> nameList) {
        List<College> result = new ArrayList<>();
        try {
            Properties p = new Properties();
            InputStream is =new FileInputStream("university.properties");
            p.load(is);

            Connection con = DriverManager.getConnection(p.getProperty("CONNECTION_URL"), p.getProperty("USER_NAME"), p.getProperty("PASSWORD"));
            Class.forName(p.getProperty("DRIVER_NAME"));

            nameList.forEach(name-> {
                try {
                    PreparedStatement stat = con.prepareStatement("select * from college where name = ?");
                    stat.setString(1, name);
                    ResultSet rs = stat.executeQuery();
                    if(!rs.next()) {
                        System.out.println("No Record Found!");
                    } else {
                        while(rs.next()) {
                            College c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDate(7));
                            result.add(c);
                        }
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public List<College> findCollege(Date startingDate) {
        List<College> result = new ArrayList<>();
        try {
            Properties p = new Properties();
            InputStream is =new FileInputStream("university.properties");
            p.load(is);

            Connection con = DriverManager.getConnection(p.getProperty("CONNECTION_URL"), p.getProperty("USER_NAME"), p.getProperty("PASSWORD"));
            Class.forName(p.getProperty("DRIVER_NAME"));

            PreparedStatement stat = con.prepareStatement("select * from college where startingDate = ?");
            java.sql.Date date = (java.sql.Date) startingDate;
            stat.setDate(1, date);
            ResultSet rs = stat.executeQuery();
            if(!rs.next()) {
                System.out.println("No Record Found!");
            } else {
                while(rs.next()) {
                    College c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDate(7));
                    result.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public List<College> findCollege(String location) {
        List<College> result = new ArrayList<>();
        try {
            Properties p = new Properties();
            InputStream is =new FileInputStream("university.properties");
            p.load(is);

            Connection con = DriverManager.getConnection(p.getProperty("CONNECTION_URL"), p.getProperty("USER_NAME"), p.getProperty("PASSWORD"));
            Class.forName(p.getProperty("DRIVER_NAME"));

            PreparedStatement stat = con.prepareStatement("select * from college where location = ?");
            stat.setString(1, location);
            ResultSet rs = stat.executeQuery();
            if(!rs.next()) {
                System.out.println("No Record Found!");
            } else {
                while(rs.next()) {
                    College c = new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDate(7));
                    result.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
