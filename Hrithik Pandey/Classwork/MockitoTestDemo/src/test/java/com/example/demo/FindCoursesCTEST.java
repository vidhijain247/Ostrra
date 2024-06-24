package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindCoursesCTEST {

	@Mock
	private FindCourse fc;
	
	@InjectMocks
	private FindCoursesC fCC;
	
	@Test
	void testfunc() {
		when(fc.cour()).thenReturn(new String []{"mca","bca","mba"});
		boolean ans= fCC.isItThere();
		assertEquals(true,ans);
		
		
	}
}
