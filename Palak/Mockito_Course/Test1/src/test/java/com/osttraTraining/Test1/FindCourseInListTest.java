package com.osttraTraining.Test1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.osttraTraining.Test1.Service.DataService;
import com.osttraTraining.Test1.Service.FindCourseInList;

@ExtendWith(MockitoExtension.class)
public class FindCourseInListTest {

	 @Mock
		private DataService service;	
		
		@InjectMocks
		FindCourseInList courses;
		
		@Test
		public void TestCase()
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the name of course: ");
			String courseName = sc.next();
			
			when(service.dataList()).thenReturn(List.of("Computer Graphics","Python","cyber Security","BlockChain","Java"));
			boolean results = courses.findCourseName(courseName);
			assertEquals(true, results);
			
		}
}
