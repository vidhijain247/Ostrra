package testq2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollegeData cd = new CollegeData();

        List<String> nameList = new ArrayList<>();
        nameList.add("MIT");
        
        
        List<College> searchByName = cd.findCollege(nameList);
        System.out.println(" Colleges Searched by Name ");
        cd.displayCollegeList("Name", searchByName); 
        
        @SuppressWarnings("deprecation")
        Date startingDate = new Date(1861, 2, 10); 
        
        
        List<College> searchByDate = cd.findCollege(startingDate);
        System.out.println(" Colleges Starting on " + new SimpleDateFormat("yyyy-MM-dd").format(startingDate) );
        cd.displayCollegeList("Starting Date", searchByDate); 
        
        
        String location = "Cambridge, MA";
        List<College> searchByLocation = cd.findCollege(location);
        System.out.println(" Colleges Located in " + location );
        cd.displayCollegeList("Name", searchByLocation); 
    }
}
