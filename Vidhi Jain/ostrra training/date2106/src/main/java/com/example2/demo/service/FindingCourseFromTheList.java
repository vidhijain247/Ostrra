package com.example2.demo.service;
import java.util.Scanner;  // Import the Scanner class

public class FindingCourseFromTheList {
	
	private DataService service;

	public FindingCourseFromTheList(DataService service) {
		super();
		this.service = service;
	}
	
	public boolean findCourse(String courseName)
	{
		String[] dataArray = service.dataList();
		boolean coursePresent = false;
		
//		 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//		 System.out.println("Enter Course Name");
//
//		 String courseName = myObj.nextLine();  // Read user input
		 
		 for(String i : dataArray) {
			 if(i == courseName) {
				 coursePresent = true;
			 }
		 }
		 
		 return coursePresent;
		 
		
		
	}

}
