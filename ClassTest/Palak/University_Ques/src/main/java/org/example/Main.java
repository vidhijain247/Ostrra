package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        CollegeBO collegeBO= new CollegeBO();

        List<College> colleges= new ArrayList<>();
        colleges.add(new College("College1", "http://www.college1.edu/", "123456", "founder1", 5, "Location 1", new Date(2024 - 1900, 0, 1)));
        colleges.add(new College("College2", "http://www.college2.edu/", "234567", "founder2", 8, "Location 2", new Date(2023 - 1900, 6, 15)));
        colleges.add(new College("College3", "http://www.college3.edu/", "345678", "founder3", 12, "Location 3", new Date(2022 - 1900, 11, 20)));
        colleges.add(new College("College4", "http://www.college4.edu/", "456789", "founder4", 10, "Location 4", new Date(2021 - 1900, 4, 30)));
        colleges.add(new College("College5", "http://www.college5.edu/", "567890", "founder5", 6, "Location 5", new Date(2020 - 1900, 2, 10)));

        collegeBO.sortCollegesDept(colleges);
        for(var x : colleges)
        {
            System.out.println(x);
        }

        collegeBO.sortCollegesName(colleges);
        System.out.println("Colleges sorted by name:");
        colleges.forEach(System.out::println);

        collegeBO.sortCollegesByDate(colleges);
        System.out.println("Colleges sorted by starting date:");
        colleges.forEach(System.out::println);

        List<String> nameList = List.of("College A", "College C");
        List<College> name = collegeBO.findCollege(nameList);
        System.out.println("Colleges found by name:");
        name.forEach(System.out::println);

        List<College> date = collegeBO.findCollege((List<String>) sdf.parse("01-01-2001"));
        System.out.println("Colleges found by starting date:");
        date.forEach(System.out::println);

        List<College> foundByLocation = collegeBO.findCollege(Collections.singletonList("Location A"));
        System.out.println("Colleges found by location:");
        foundByLocation.forEach(System.out::println);


    }
}