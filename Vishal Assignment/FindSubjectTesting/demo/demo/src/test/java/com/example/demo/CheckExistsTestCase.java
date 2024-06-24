package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckExistsTestCase {
	@Mock
	private AllSubject sub;
	
	@InjectMocks
	private CheckExists chckEx;
	
	
	@Test
	void test() {
		when(sub.getSubjectDetails()).thenReturn(new String[] {"Math","Eng","Hindi"});
		boolean ans=chckEx.check("Math");
		System.out.println("Hello. It got passed !");
		assertEquals(true,ans);
	}

}
