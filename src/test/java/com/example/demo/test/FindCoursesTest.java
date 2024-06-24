package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.service.FindCourse;
import com.example.demo.service.FindCourses;

@ExtendWith(MockitoExtension.class)
class FindCoursesTest {

    @Mock
    private FindCourse fc;
    
    @InjectMocks
    private FindCourses fcs;
    
    @Test
    void test() {
        when(fc.cour()).thenReturn(new String []{"mca","btech","mtech"});
        boolean ans= fcs.find();
        assertEquals(true,ans);
        
        
    }
}