package Test;

import java.util.Scanner;

public class Cal {
    int a=0; 
    int b=0;
    int c=0;
    
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Num1");
        a=sc.nextInt();
        System.out.println("Enter Num2");
        b=sc.nextInt();
        System.out.println("Enter Operator= 1 for +, 2 for -, 3 for*, 4 for / , 5 for %");
        c=sc.nextInt();
    }
    public float Calc(int a, int b, int c) {
        int r=0;
        switch(c) {
        case 1: r =a+b; break;
        case 2: r=a-b; break;
        case 3: r=a*b; break;
        case 4: r=a/b; break;
        case 5: r=a%b; break;
        default: System.out.println("Enter Valid Operators");
        }
        return r;
    }
    public static void main(String[] args) {
        Cal C = new Cal();
    }
 
}