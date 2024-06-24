import First.PackageFirst;


class first{
	public static void main(String a[]){
	
	int c = Integer.parseInt(a[0]);
	int b = Integer.parseInt(a[1]);
	
	PackageFirst f= new PackageFirst();
	f.print();

	 switch(a[2]){
	   case"+": System.out.println(c+b); break;
	   case"-": System.out.println(c-b); break;
	   case"*": System.out.println(c*b); break;
	   case"/": System.out.println(c/b); break;
	   default: System.out.println("INVALID INPUT");
	}
	}
}