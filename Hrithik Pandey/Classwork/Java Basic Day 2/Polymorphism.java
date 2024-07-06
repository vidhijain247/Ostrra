public class Polymorphism extends Polymorphism2{
	
    public static void main(String[] args) {
        Polymorphism p= new Polymorphism();
		System.out.println(p.calRadius(3));
    }
	static int calcArea(int a){
		return a*a;
	}
	static int calcArea(int a, int b){
		return a*b;
	}
	double calRadius(double r)
	{
		return super.calRadius(r);
	}
	
}
