package demo.testing;

import java.util.Scanner;

public class Calc {
	private int a,b;
	public int sum() {return this.a+this.b;}
	public int minus() {return this.a-this.b;}
	public int prod() {return this.a*this.b;}
	public int div() {return this.a/this.b;}
	public int mod() {return this.a%this.b;}
	public int Calcl() {
		 System.out.println("WELCOME /n ENTER FIRST NUMBER");
	        Scanner sc = new Scanner(System.in);
	    int num1=sc.nextInt();
	        a=num1;
	        System.out.println("ENTER SECOND NUMBER");
	        int num2=sc.nextInt();
	        b=num2;
	        System.out.println("ENTER YOUR CHOICE \n"
	                + "+\n-\n*\n/\n%");
	        String op=sc.next();
	        int res=-1;
	        switch(op.charAt(0)) {
	        case '+':res=sum(); break;
	        case '-':res=minus(); break;
	        case '/':res=div(); break;
	        case '*':res=prod(); break;
	        case '%':res=mod(); break;
	        default :System.out.println("INCORRECT CHOICE");
	        }
	        return res;
	}

}
