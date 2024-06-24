package edu.training.osttra;

public class PackageDemo
{
 public void sum()
	{
		
		int a = 2;
		int b = 3;
		String x= "+";
		int ans=0;
		if(x.equals("+"))
		{
			ans=a+b;
		}
		if(x.equals("-"))
		{
			ans=a-b;
		}
		if(x.equals("/"))
		{
			ans=a/b;
		}
		if(x.equals("x"))
		{
			ans=a*b;
		}
		System.out.println(" ans is " + ans);
	}
}	 