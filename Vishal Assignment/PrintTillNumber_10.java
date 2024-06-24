import java.util.*;

class Demo1
{
	public static void main(String[] args){

		// System.out.println("Hello Java");
		Scanner sc =new Scanner();
		int inp=sc.nextInt();

		int inp=Integer.parseInt(args[0]);

		switch (inp) {
			case 1: System.out.println("1");
			case 2: System.out.println("2");
			case 3: System.out.println("3");
			case 4: System.out.println("4");
			case 5: System.out.println("5");
			case 6: System.out.println("6");
			case 7: System.out.println("7");
			case 8: System.out.println("8");
			case 9: System.out.println("9");
			case 10: System.out.println("10");break;
				
			default: System.out.println("incorrect");
		}

		


	}
}