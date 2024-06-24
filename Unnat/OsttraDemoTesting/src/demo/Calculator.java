package demo;

import java.util.Scanner;

public class Calculator {

	
	public static int add(int n1, int n2) {
		return n1+n2;
	}
	
	public static int subtract(int n1, int n2) {
		return n1-n2;
	}
	
	public static int multiply(int n1, int n2) {
		return n1*n2;
	}
	
	public static int divide(int n1, int n2) {
		return n1/n2;
	}
	
	public static int mod(int n1, int n2) {
		return n1%n2;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.print("Enter number 1: ");
		int n1=sc.nextInt();
		System.out.print("Enter number 2: ");
		int n2=sc.nextInt();
		System.out.print("Enter operator: ");
		int op=sc.nextInt();
		int result;
		switch(op) {
			case 1:
				result=add(n1,n2);
				break;
			case 2:
				result=subtract(n1,n2);
				break;
			case 3:
				result=multiply(n1,n2);
				break;
			case 4:
				result=divide(n1,n2);
				break;
			case 5:
				result=mod(n1,n2);
				break;
			default:
				System.out.println("Incorrect operator choice");
				result=-1;
				break;
		}
		if(result!=-1) {
			System.out.println("Result="+result);
		} else {
			System.out.println("Cannot calculate result");
		}
	}
}
