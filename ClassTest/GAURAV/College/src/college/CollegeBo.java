package college;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CollegeBo {
    public List<College> findCollege(List<String> nameList) {
       
        List<College> colleges = getCollegesFromDatabase();
        List<College> result = new ArrayList<>();
        for (College college : colleges) {
            if (nameList.contains(college.getName())) {
                result.add(college);
            }
        }
        return result;
    }

    public List<College> findCollege(Date startingDate) {
       
        List<College> colleges = getCollegesFromDatabase();
        List<College> result = new ArrayList<>();
        for (College college : colleges) {
            if (college.getStartingDate().equals(startingDate)) {
                result.add(college);
            }
        }
        return result;
    }

    public List<College> findCollege(String location) {
       
        List<College> colleges = getCollegesFromDatabase();
        List<College> result = new ArrayList<>();
        for (College college : colleges) {
            if (college.getLocation().equals(location)) {
                result.add(college);
            }
        }
        return result;
    }

    public void sortCollegesByName(List<College> colleges) {
        Collections.sort(colleges, (c1, c2) -> c1.getName().compareTo(c2.getName()));
    }

    public void sortCollegesByStartingDate(List<College> colleges) {
        Collections.sort(colleges, (c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));
    }

    public void sortCollegesByNumberOfDept(List<College> colleges) {
        Collections.sort(colleges, (c1, c2) -> c1.getNumberOfDept().compareTo(c2.getNumberOfDept()));
    }

    
    List<College> getCollegesFromDatabase() {
        
        List<College> colleges = new ArrayList<>();
        // Add some dummy data
        try {
            colleges.add(new College("MAITCollege", "www.MAIT.ac.edu", "1234567890", "Gaurav", 10, "Delhi", new SimpleDateFormat("yyyy-MM-dd").parse("1998-10-05")));
            colleges.add(new College("CTET Institute", "www.CTET.ic.edu", "0987654321", "Ankit", 8, "Noida", new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-11")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colleges;
    }
}