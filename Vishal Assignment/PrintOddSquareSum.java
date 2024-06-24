import java.util.*;

class Demo1
{
	public static void main(String[] args){

		System.out.println("Hello Java");
		
		int arr[]={72,51,30,17,13,47,31,7,15,3};
		int sum=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]%2!=0){
				int x=arr[i]*arr[i];
				sum+=x;
				System.out.print(x+" ");
			}
		}
		System.out.println();
		System.out.println(sum);


	}
}