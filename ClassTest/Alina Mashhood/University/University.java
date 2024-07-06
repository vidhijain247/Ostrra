import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class University {

    public static void main(String[] args) {
        CollegeBO collegeBO = new CollegeBO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of colleges:");
        int numberOfColleges = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Assuming there is a method to add colleges to the database
        for (int i = 0; i < numberOfColleges; i++) {
            System.out.println("Enter college details (name,website,mobile,founder,numberOfDept,location,startingDate): ");
            String collegeDetails = scanner.nextLine();
            String[] details = collegeDetails.split(",");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startingDate = sdf.parse(details[6]);
                College college = new College(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]), details[5], startingDate);
                // Add college to the database (this part is assumed to be handled in CollegeBO)
                // collegeBO.addCollege(college);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Enter choice (1: Sort by Name, 2: Sort by Starting Date, 3: Sort by Number of Departments, 4: Search by Name, 5: Search by Starting Date, 6: Search by Location): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<College> collegeList = null;

        switch (choice) {
            case 1:
                // Fetch all colleges from the database (assuming there is a method in CollegeBO to fetch all colleges)
                // collegeList = collegeBO.getAllColleges();
                Collections.sort(collegeList, (c1, c2) -> c1.getName().compareTo(c2.getName()));
                break;
            case 2:
                // Fetch all colleges from the database (assuming there is a method in CollegeBO to fetch all colleges)
                // collegeList = collegeBO.getAllColleges();
                Collections.sort(collegeList, (c1, c2) -> c1.getStartingDate().compareTo(c2.getStartingDate()));
                break;
            case 3:
                // Fetch all colleges from the database (assuming there is a method in CollegeBO to fetch all colleges)
                // collegeList = collegeBO.getAllColleges();
                Collections.sort(collegeList, (c1, c2) -> c1.getNumberOfDept().compareTo(c2.getNumberOfDept()));
                break;
            case 4:
                System.out.println("Enter college names (comma separated): ");
                String names = scanner.nextLine();
                List<String> nameList = Arrays.asList(names.split(","));
                collegeList = collegeBO.findCollege(nameList);
                break;
            case 5:
                System.out.println("Enter starting date (yyyy-MM-dd): ");
                String dateString = scanner.nextLine();
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                collegeList = collegeBO.findCollege(date);
                break;
            case 6:
                System.out.println("Enter location: ");
                String location = scanner.nextLine();
                collegeList = collegeBO.findCollege(location);
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return; // Exit on invalid choice
        }

        System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n", "Name", "Website", "Mobile", "Founder", "No of Departments", "Location", "Starting Date");
        if (collegeList != null) {
            for (College college : collegeList) {
                System.out.println(college);
            }
        }

        scanner.close();
    }
}
