class pro{

	public static void rec(int num,int step){
	step--;
	 if(step<0){ return;}
	 System.out.println(num);
	rec(num+1,step);

	}


	public static void main(String a[]){
	int num = Integer.parseInt(a[0]);
	int step =num;
	rec(num,step+1);
	}



}