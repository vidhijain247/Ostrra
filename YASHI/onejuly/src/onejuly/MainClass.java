package onejuly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
  public static void main(String args[]) {
	  List<Student> st = new ArrayList<>();
	  st.add(new Student("Yashi",85));
	  st.add(new Student("Vishal",90));
	  st.forEach(student-> System.out.println(student));
	  
	 // sortByName sort = new sortByName();
	 
	  
	  Collections.sort(st,(s1,s2)->s1.getName().compareTo(s2.getName()));
	  
	  st.forEach(student->System.out.println(student));
	  
   Collections.sort(st,(s1,s2)->s1.getMarks()>s2.getMarks()?1:-1);
	  
	  st.forEach(student->System.out.println(student));
  }
}
