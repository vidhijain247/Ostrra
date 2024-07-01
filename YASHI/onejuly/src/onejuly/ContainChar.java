package onejuly;

import java.util.ArrayList;
import java.util.List;

public class ContainChar {
   public static void main(String args[])
   {
	   List<String> names = new ArrayList<>();
	   names.add("Yashi");
	   names.add("Vidhi");
//	   for(int i=0;i<names.size();i++)
//	   {
//		   if(names.get(i).indexOf("d")>=0)
//		   {
//			   System.out.println(names.get(i));
//			   return;
//		   }
////		   else
////		   {
////		   System.out.println();
////		   }
//	   }
//	   System.out.println("Not found");
	   String str = names.stream().filter(name->name.contains("m")).findFirst().orElse("Not found");
	   System.out.println(str);
   }
}
