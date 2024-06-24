class SumOfOddSquares {
	public static void main(String[] args){
		int[] arr = new int[]{72,51,30,17,13,47,31,7,15,3};
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i]%2==1){
				System.out.println("Square of " + arr[i] + " is " + (arr[i]*arr[i]));
				sum += arr[i]*arr[i];
			}
		}
		
		System.out.println("Sum of squares is " + sum);
	}
}