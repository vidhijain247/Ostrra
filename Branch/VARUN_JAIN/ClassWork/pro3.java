class pro3{

	public static void sort(int[] sq){

        for(int i=0;i<sq.length;i++){
        for(int j=1;j<sq.length;j++){
            if(sq[j]<sq[j-1]){
                int temp=sq[j];
                sq[j]=sq[j-1];
                sq[j-1]=temp;
            }
        }
    }

      for(int i:sq){
	System.out.println(sq[i]);
}


}





	public static void main(String a[]){

	int[] arr = {72,51,30,17,13,47,31,7,15,3};
	int[] sq = new int[10];
	for(int i=0,j=0;i<10;i++){
	if(arr[i]%2 !=0){ sq[j]=(arr[i]*arr[i]);  j++;}
}

	int res=0;
         for(int i:sq){
	  	  res+=i;
}

	System.out.println(res);


       sort(sq);


	}

}