package com.example.demo.service;

import java.util.Scanner;

public class FindCourses {
      private FindCourse finc;
      public FindCourses(FindCourse finc)
      {
    	  super();
    	  this.finc=finc;
      }
      
      public boolean find()
      {
    	  String[] l= finc.cour();
          Scanner sc= new Scanner(System.in);
          System.out.println("Which course do you want to find?");
          String s= sc.nextLine();
          for(String a : l)
          {
              if(s.equals(a))
                  return true;
          }
          return false;
    	  
      }
}
