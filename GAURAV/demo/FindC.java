package Training.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class Course {

    @Mock
    private FindCourse1 Test;
    
    @InjectMocks
    private FindCourse Test2;
    
    @Test
    void testfunc() {
        when(Test.cour()).thenReturn(new String []{"CSE","IT","ECE","MECH"});
        boolean ans= Test2.course();
        assertEquals(true,ans);
        
        
    }
}
