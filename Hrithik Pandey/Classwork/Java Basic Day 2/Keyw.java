public class Keyw {
	static int i;
	final int fi=5;
	static final void cantO(){
		System.out.println("You cant override me");
	}
	static void printT(){
		System.out.println(i);
	}
	static{
		System.out.println("I am static block");
	}
    public static void main(String[] args) {
        printT();
		cantO();
		fi=2; //you cant do this
    }
}
