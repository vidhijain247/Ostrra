package college;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollegeBo collegeBo = new CollegeBo();

        List<College> colleges = collegeBo.getCollegesFromDatabase();

        System.out.println("Colleges sorted by name:");
        collegeBo.sortCollegesByName(colleges);
        for (College college : colleges) {
            System.out.print(college);
        }

        System.out.println("\nColleges sorted by starting date:");
        collegeBo.sortCollegesByStartingDate(colleges);
        for (College college : colleges) {
            System.out.print(college);
        }

        System.out.println("\nColleges sorted by number of departments:");
        collegeBo.sortCollegesByNumberOfDept(colleges);
        for (College college : colleges) {
            System.out.print(college);
        }
    }
}