package com.example.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import findLargestFromList.DataService;
import findLargestFromList.findLargest;

@ExtendWith(MockitoExtension.class)
public class findLargestTest {
	
	@Mock
	private DataService service;
	
	@InjectMocks
	findLargest courses;
	
	@Test
	public void TestCase() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of course: ");
		String courseName = sc.next();
		
		when(service.dataList()).thenReturn(List.of("English","Hindi","Maths"));
		boolean results = courses.findCourseName(courseName);
		assertEquals(true, results);
	}

}
