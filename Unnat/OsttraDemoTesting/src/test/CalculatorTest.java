package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import demo.Calculator;

class CalculatorTest {

	Calculator calculator = new Calculator();
	Scanner s = new  Scanner(System.in);	
	@Test
	void testAdd() {
		System.out.println("Enter the value of num1");
		int n1 = s.nextInt();
		System.out.println("Enter the value of num2");
		int n2 = s.nextInt();
		System.out.println("Enter the Excepted output");
		int result = s.nextInt();
		assertEquals(result,calculator.add(n1,n2));
		System.out.println("Add Test is passed");
	}
	
	@Test
	void testSubtract() {
		System.out.println("Enter the value of num1");
		int n1 = s.nextInt();
		System.out.println("Enter the value of num2");
		int n2 = s.nextInt();
		System.out.println("Enter the Excepted output");
		int result = s.nextInt();
		assertEquals(result,calculator.subtract(n1,n2));
		System.out.println("Subtract Test is passed");
	}
	
	@Test
	void testMultiply() {
		System.out.println("Enter the value of num1");
		int n1 = s.nextInt();
		System.out.println("Enter the value of num2");
		int n2 = s.nextInt();
		System.out.println("Enter the Excepted output");
		int result = s.nextInt();
		assertEquals(result,calculator.multiply(n1,n2));
		System.out.println("Multiply Test is passed");
	}
	
	@Test
	void testDivide() {
		System.out.println("Enter the value of num1");
		int n1 = s.nextInt();
		System.out.println("Enter the value of num2");
		int n2 = s.nextInt();
		System.out.println("Enter the Excepted output");
		int result = s.nextInt();
		assertEquals(result,calculator.divide(n1,n2));
		System.out.println("Divide Test is passed");
	}
	
	@Test
	void testMod() {
		System.out.println("Enter the value of num1");
		int n1 = s.nextInt();
		System.out.println("Enter the value of num2");
		int n2 = s.nextInt();
		System.out.println("Enter the Excepted output");
		int result = s.nextInt();
		assertEquals(result,calculator.mod(n1,n2));
		System.out.println("Mod Test is passed");
	}
	
	@BeforeEach
	void beforeEachTestCase() {
		System.out.println("Before performing each test case");
	}
	
	@AfterEach
	void afterEachTestCase() {
		System.out.println("After performing each test case");
	}

}
