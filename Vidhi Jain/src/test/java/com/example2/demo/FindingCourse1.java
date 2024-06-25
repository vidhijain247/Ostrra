package com.example2.demo;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example2.demo.service.DataService;
import com.example2.demo.service.FindingCourseFromTheList;

@ExtendWith(MockitoExtension.class)
public class FindingCourse1 {
	
	@Mock
	private DataService service;
	
	
	@InjectMocks
	FindingCourseFromTheList list;
	
	
	@Test
	public void TestCase()
	{
		when(service.dataList()).thenReturn(new String[] {"Science","English","Maths"});
		
//		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//		System.out.println("Enter Course Name");
//		String courseName = myObj.nextLine();  // Read user input
		
		String courseName = "Maths";  // Read user input
		
		boolean result = list.findCourse(courseName);
		assertEquals(true, result);
	}

	@Test
	public void TestCase2()
	{
	    when(service.dataList()).thenReturn(new String[] {"Science","English","Maths"});
		
//		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//		System.out.println("Enter Course Name");
		String courseName = "Hindi";  // Read user input
		
		boolean result = list.findCourse(courseName);
		assertEquals(false, result);
	}
	
	@Test
	public void TestCase3()
	{
	    when(service.dataList()).thenReturn(new String[] {"Hindi","English","Maths"});
		
//		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//		System.out.println("Enter Course Name");
		String courseName = "English";  // Read user input
		
		boolean result = list.findCourse(courseName);
		assertEquals(true, result);
	}
}
