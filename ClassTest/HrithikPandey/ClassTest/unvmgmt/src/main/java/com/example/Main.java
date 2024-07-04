package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<College> colleges= new ArrayList<>();
        colleges.add(new College("College1", "http://www.college1.edu/", "123456", "founder1", 5, "Location 1", new Date(2024 - 1900, 0, 1)));
        colleges.add(new College("College2", "http://www.college2.edu/", "234567", "founder2", 8, "Location 2", new Date(2023 - 1900, 6, 15)));
        colleges.add(new College("College3", "http://www.college3.edu/", "345678", "founder3", 12, "Location 3", new Date(2022 - 1900, 11, 20)));
        colleges.add(new College("College4", "http://www.college4.edu/", "456789", "founder4", 10, "Location 4", new Date(2021 - 1900, 4, 30)));
        colleges.add(new College("College5", "http://www.college5.edu/", "567890", "founder5", 6, "Location 5", new Date(2020 - 1900, 2, 10)));
        CollegeBo cBo= new CollegeBo();
        cBo.sortCollegeDept(colleges);
        for(var x : colleges)
        {
            System.out.println(x);
        }
    }
}