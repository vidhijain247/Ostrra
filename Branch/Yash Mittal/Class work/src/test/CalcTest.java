package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import demo.testing.Calc;

class CalcTest {

	@Test
	void test() {
		 System.out.println("ENTER EXCEPTED RESULT");
	        Scanner sc = new Scanner(System.in);
	        int exp=sc.nextInt();
	        Calc c = new Calc();
	        int act = c.Calcl();
	        assertEquals(exp,act);	        

}	
}
