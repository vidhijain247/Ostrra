package Training.demo;

import java.util.List;
import java.util.Scanner;

public class FindCourse {
    private FindCourse1 Tech;
    public FindCourse(FindCourse1 Tech) {
        this.Tech=Tech;
    }
    public boolean course() {
        String[] dl= Tech.cour();
        Scanner sc= new Scanner(System.in);
        System.out.println("What Courses are available");
        String s= sc.nextLine();
        for(String x : dl)
        {
            if(s.equals(x))
                return true;
        }
        return false;
    }
}