package date2806;
import java.util.*; 

class Exercise6 { 

	public static void sort(int arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
	
	public static void sortedMerge(int a[], int b[], int res[], int n, int m) 
	{ 
	
		sort(a); 
		sort(b); 
	
		int i = 0, j = 0, k = 0; 
		while (i < n && j < m) { 
			if (a[i] <= b[j]) { 
				res[k] = a[i]; 
				i += 1; 
				k += 1; 
			} else { 
				res[k] = b[j]; 
				j += 1; 
				k += 1; 
			} 
		}	 
		
		while (i < n) { 
			res[k] = a[i]; 
			i += 1; 
			k += 1; 
		}	 
		while (j < m) { 
			res[k] = b[j]; 
			j += 1; 
			k += 1; 
		} 
	} 
	
	
	public static void main(String[] args) 
	{ 
		int a[] = { 10, 5, 15, 67, 54, 23, 87, 12, 31, 90 }; 
		int b[] = { 20, 3, 2, 12, 56, 60, 39, 71, 50, 19 }; 
		int n = a.length; 
		int m = b.length; 
	
		
		int res[] = new int[n + m]; 
		sortedMerge(a, b, res, n, m); 
	
		System.out.print( "Sorted merged list :"); 
		for (int i = 0; i < n + m; i++) 
			System.out.print(" " + res[i]); 
	} 
} 

