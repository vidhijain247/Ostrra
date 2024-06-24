import java.util.Scanner;

public class sortingListSquares {
	public static void main(String args[]) {
		int arr[] = {72,51,30,17,13,47,31,7,15,3};
		int arr2[] = {0,0,0,0,0,0,0,0,0,0};
		int sum=0;
		for(int count=0;count<arr.length;count++) {
			if(arr[count]%2==1) {
				System.out.println(arr[count]*arr[count]);
				sum+=arr[count]*arr[count];
				arr2[count]=arr[count];
			}
		}
		System.out.println("Sum="+sum);
        	for (int j = 1; j < arr2.length; j++) {
			int key = arr2[j];
			int i = j-1;  
			while ( (i > -1) && ( arr2 [i] > key ) ) {  
				arr2 [i+1] = arr2 [i];
				i--;
			}
			arr2[i+1] = key;  
        	}
		for(int count=0;count<arr2.length;count++) {
			if(arr2[count]!=0) {
				System.out.println(arr2[count]*arr2[count]);
			}
		}
	}
}
