class NoLoop {

	public static void print(int num){
		
		if(num <= 10){
			System.out.println(num);
			num=num+1;
			print(num);
		}
	}	

	public static void main(String[] args){
	
		print(Integer.parseInt(args[0]));	
	
	}

}
