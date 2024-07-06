
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> keyNames=Arrays.asList("College3","College1","College6");
        CollegeBO.findCollege("Location1").forEach(System.out::println);
       
       
        List<College> collegeList = CollegeBO.findCollege(keyNames);
        Collections.sort(collegeList,(a,b)->a.getName().compareTo(b.getName()));
        collegeList.forEach(System.out::println);

        
        List<College> collegeList2 = CollegeBO.findCollege(keyNames);
        Collections.sort(collegeList2,(a,b)->a.getStartingDate().compareTo(b.getStartingDate()));
        collegeList2.forEach(System.out::println);
        
        
       
        List<College> collegeList3 = CollegeBO.findCollege(keyNames);
        Collections.sort(collegeList3,(a,b)->a.getNumberOfDept()<b.getNumberOfDept()?-1:1);
        collegeList3.forEach(System.out::println);
    }
}
