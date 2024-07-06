package edu.osttra.training.University;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        CollegeBO bo = new CollegeBO();

//        Assuming there is already data inside the DB
        List<College> result1;
        result1 = bo.findCollege("Delhi");
        result1.forEach(System.out::println);

        List<College> result2;
        result2 = bo.findCollege(Arrays.asList("DU", "IPU", "JNU"));
        Collections.sort(result2, (r1, r2)-> r1.getName().compareTo(r2.getName()));
        result2.forEach(System.out::println);

        List<College> result3;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-05-01");
        result3 = bo.findCollege(date);
        Collections.sort(result3, (r1, r2)-> r1.getStartingDate().compareTo(r2.getStartingDate()));
        result3.forEach(System.out::println);


        List<College> result4;
        result4 = bo.findCollege(Arrays.asList("DU", "IPU", "JNU"));
        Collections.sort(result4, (r1, r2)-> r1.getNumberOfDept()>r2.getNumberOfDept()?1:-1);
        result4.forEach(System.out::println);
    }
}
