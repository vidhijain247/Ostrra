package onejuly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamapiDemo {
  public static void main(String args[])
  {
	  Random r = new Random();
	  List<Integer> nums = new ArrayList<>();
	  for(int i=0;i<10000;i++)
	  {
		  nums.add(r.nextInt(100));
	  }
	  long startNormalStream = System.currentTimeMillis();
	  System.out.println(startNormalStream);
	  nums.stream().map(n->{try{
		  Thread.sleep(1);
	  }
	  catch(InterruptedException e)
	  {
		  System.out.println(e.getMessage());
	  }
	  return n*n;}).mapToInt(i->i).sum();
	  
	  long endNormalStream = System.currentTimeMillis();
	  System.out.println(endNormalStream);
	  System.out.println("Time for normal "+(endNormalStream-startNormalStream));
	  
	  long startParallelStream = System.currentTimeMillis();
	  nums.parallelStream().map(n->{try{
		  Thread.sleep(1);
	  }
	  catch(InterruptedException e)
	  {
		  System.out.println(e.getMessage());
	  }
	  return n*n;}).mapToInt(i->i).sum();
	  long endParallelStream = System.currentTimeMillis();
	  System.out.println("Time for parallel "+(endParallelStream-startParallelStream));
	  
  }
}
