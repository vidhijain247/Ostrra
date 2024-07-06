import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String csv = "CollegeA,websiteA,mobileA,founderA,10,locationA,2001-09-11\n" +
                         "CollegeB,websiteB,mobileB,founderB,15,locationB,2024-06-04\n" +
                         "CollegeC,websiteC,mobileC,founderC,20,locationC,2011-05-02";

        List<College> colleges = new ArrayList<>();

        String[] lines = csv.split("\n");
        for (String line : lines) {
            College college = College.fromCSV(line);
            colleges.add(college);
        }

        Collections.sort(colleges, (c1, c2) -> c1.getName().compareTo(c2.getName()));

        for (College college : colleges) {
            System.out.println("Name: " + college.getName());
        }

        Collections.sort(colleges, (c1, c2) -> c1.getName().compareTo(c2.getName()));

        System.out.println("Sorted by Name:");
        for (College college : colleges) {
            System.out.println(college.getName());
        }

        Collections.sort(colleges, (c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));

        System.out.println("\nSorted by Starting Date:");
        for (College college : colleges) {
            System.out.println(college.getName() + " - " + college.getStartingDate());
        }

        Collections.sort(colleges, (c1, c2) -> c1.getNumberOfDepts() - c2.getNumberOfDepts());

        System.out.println("\nSorted by Number of Departments:");
        for (College college : colleges) {
            System.out.println(college.getName() + " - " + college.getNumberOfDepts());
        }
    }
}