package question2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ClgData {

    private List<College> collegeList; 

    public ClgData() {
        this.collegeList = new ArrayList<>();
    }

    public List<College> findCollege(List<String> nameList) {
        List<College> matchingColleges = new ArrayList<>();
        for (College college : collegeList) {
            if (nameList.contains(college.getName())) {
                matchingColleges.add(college);
            }
        }
        return matchingColleges;
    }

    public List<College> findCollege(Date startingDate) {
        List<College> matchingColleges = new ArrayList<>();
        for (College college : collegeList) {
            if (college.getStartingDate().equals(startingDate)) {
                matchingColleges.add(college);
            }
        }
        return matchingColleges;
    }

    public List<College> findCollege(String location) {
        List<College> matchingColleges = new ArrayList<>();
        for (College college : collegeList) {
            if (college.getLocation().equals(location)) {
                matchingColleges.add(college);
            }
        }
        return matchingColleges;
    }

    public void sortCollegeByName() {
        Collections.sort(collegeList, (c1, c2) -> c1.getName().compareTo(c2.getName()));
    }

    public void sortByStartingDate() {
        Collections.sort(collegeList, (c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));
    }

    public void sortByNumberOfDept() {
        Collections.sort(collegeList, (c1, c2) -> c1.getNumberOfDept() - c2.getNumberOfDept());
    }

    public void displayCollegeList(String string, List<College> colleges) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
        for (College college : colleges) {
            System.out.format("%-15s %-20s %-15s %-15s%-20d %-15s %s\n",
                    college.getName(), college.getWebsite(), college.getMobile(), college.getFounder(),
                    college.getNumberOfDept(), college.getLocation(), dateFormat.format(college.getStartingDate()));
        }
    }

    
}
