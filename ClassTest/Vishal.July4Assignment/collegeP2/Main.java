import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollegeData cd = new CollegeData();

        List<String> nameList = new ArrayList<>();
        nameList.add("Amity");
        
        System.out.println("HI,   Welcome......");

        System.out.println();
        System.out.println();
        List<College> searchByName = cd.findCollege(nameList);
        System.out.println(" Colleges Searched by Name ");
        cd.displayCollegeList("Name", searchByName); 
        
        @SuppressWarnings("deprecation")
        Date startingDate = new Date(0100, 9, 12); 
        
        
        List<College> searchByDate = cd.findCollege(startingDate);
        System.out.println(" Colleges Starting on " + new SimpleDateFormat("yyyy-MM-dd").format(startingDate) );
        cd.displayCollegeList("Starting Date", searchByDate); 
        
        
        String location = "Noida, India";
        List<College> searchByLocation = cd.findCollege(location);
        System.out.println(" Colleges Located in " + location );
        cd.displayCollegeList("Name", searchByLocation); 
    }
}