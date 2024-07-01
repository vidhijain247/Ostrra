package date0107;

import java.util.List;
import java.util.ArrayList;

public class Findi {
    public static void main(String[] args) {
    
        List<String> courseNames = new ArrayList<>();
        courseNames.add("Mathematics");
        courseNames.add("Physics");
        courseNames.add("Biology");
        courseNames.add("Chemistry");
        courseNames.add("History");

   
        boolean found = false;

       
        System.out.println("Course names containing 'i':");
        for (String course : courseNames) {
            if (course.contains("i")) {
                System.out.println(course);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    }
}


