package date2806;
import java.util.Scanner;

class CheckString {

    // Returns true if s1 is substring of s2
	static int isSubstring(String s1, String s2)
	{
		int M = s1.length();
		int N = s2.length();

	
		for (int i = 0; i <= N - M; i++) {
			int j;

		
			for (j = 0; j < M; j++)
				if (s2.charAt(i + j) != s1.charAt(j))
					break;

			if (j == M)
				return i;
		}

		return -1;
	}
   
    public static void main(String args[])
    {
    
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter a string 1: ");  
        String str1= sc.next();   

        System.out.print("Enter a string 2: ");  
        String str2= sc.next();  

        
		int res = isSubstring(str1, str2);

		if (res == -1)
			System.out.println("Not present");
		else
			System.out.println("Present at index " + res);



    }
   

}


