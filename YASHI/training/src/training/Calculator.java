package training;

import java.util.Scanner;

public class Calculator {
	public int calc()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter num1");
		int a = sc.nextInt();
		System.out.println("Enter num2");
		int b = sc.nextInt();
        System.out.println("Enter operator: 1= + , 2= - , 3= * , 4= / ,5= % ");
        int c = sc.nextInt();
        int r=0;
        switch (c){
        case 1:r = a+b;break;
        case 2:r = a-b;break;
        case 3:r = a*b;break;
        case 4:r = a/b;break;
        case 5:r = a%b;break;
        default:System.out.println("Enter the valid operator");
        }
        System.out.println(r);
        return r;
              
	}
	
}
