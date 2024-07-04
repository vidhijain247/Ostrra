package com.university;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> keyNames=Arrays.asList("College3","College1","College6");
        CollegeBO.findCollege("Location1").forEach(System.out::println);
        // System.out.println("Hello world!");

        //part c
        List<College> collegeLis = CollegeBO.findCollege(keyNames);
        Collections.sort(collegeLis,(a,b)->a.getName().compareTo(b.getName()));
        collegeLis.forEach(System.out::println);

        //part d
        List<College> collegeLis2 = CollegeBO.findCollege(keyNames);
        Collections.sort(collegeLis2,(a,b)->a.getStartingDate().compareTo(b.getStartingDate()));
        collegeLis2.forEach(System.out::println);
        
        
        //part e
        List<College> collegeLis3 = CollegeBO.findCollege(keyNames);
        Collections.sort(collegeLis3,(a,b)->a.getNumberOfDept()<b.getNumberOfDept()?-1:1);
        collegeLis3.forEach(System.out::println);
    }
}