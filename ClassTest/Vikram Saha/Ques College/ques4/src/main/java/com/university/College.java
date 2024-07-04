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
import java.util.Scanner;

public class College {
    private String name;
    private String website;
    private String mobile;
    private String founder;

    private int numberOfDept;
    private String location;
    private Date startingDate;

    public College(String name, String website, String mobile, String foudner, int numberOfDept, String location,
            Date startingDate) {
        this.name = name;
        this.website = website;
        this.mobile = mobile;
        this.founder = foudner;
        this.numberOfDept = numberOfDept;
        this.location = location;
        this.startingDate = startingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String foudner) {
        this.founder = foudner;
    }

    public int getNumberOfDept() {
        return numberOfDept;
    }

    public void setNumberOfDept(int numberOfDept) {
        this.numberOfDept = numberOfDept;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public College() {
    }

    

    @Override
    public String toString() {
        return String.format("%-20s %-30s %-15s %-20s %-15d %-20s %-10s\n", 
                             name, website, mobile, founder, numberOfDept, location,startingDate);
    }
    
}