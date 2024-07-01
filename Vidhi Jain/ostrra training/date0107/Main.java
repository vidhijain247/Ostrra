package date0107;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("vidhi",99));
        students.add(new Student("disha",98));
        students.add(new Student("aryan",97));
        students.add(new Student("sonu",96));
        students.add(new Student("deepak",95));

        students.forEach(student -> System.out.println(student));
        Collections.sort(students);
        System.out.println("***********sorted marks using comparable********");
        students.forEach(student -> System.out.println(student));
        
        System.out.println("***********sorted marks using comparator********");
        SortByMarks sortmarks = new SortByMarks();
        Collections.sort(students, sortmarks);
        students.forEach(student -> System.out.println(student));

        


    }
}
