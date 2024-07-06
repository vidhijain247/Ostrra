import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class CollegeBO {
    private List<College> colleges;

    public CollegeBO(List<College> colleges) {
        this.colleges = colleges;
    }

    public List<College> findCollege(List<String> nameList) {
        List<College> result = new ArrayList<>();
        for (College college : colleges) {
            if (nameList.contains(college.getName())) {
                result.add(college);
            }
        }
        return result;
    }

    public List<College> findCollege(Date startingDate) {
        List<College> result = new ArrayList<>();
        for (College college : colleges) {
            if (college.getStartingDate().equals(startingDate)) {
                result.add(college);
            }
        }
        return result;
    }

    public List<College> findCollege(String location) {
        List<College> result = new ArrayList<>();
        for (College college : colleges) {
            if (college.getLocation().equalsIgnoreCase(location)) {
                result.add(college);
            }
        }
        return result;
    }
}