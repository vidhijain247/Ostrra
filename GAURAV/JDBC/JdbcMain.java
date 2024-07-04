package education;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JdbcMain {

    private static final String URL = "jdbc:mysql://localhost:3306/osttra";
    private static final String USER = "root";
    private static final String PASSWORD = "Doghat@123";

    public static void main(String[] args) {
    	  try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/osttra","root", "Doghat@123"))
    	  {
          
              Class.forName("com.mysql.cj.jdbc.Driver");
    	  }
    	  
    	  catch(Exception e) {
              
              System.out.println(e.getMessage());
              
          }
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Student Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String sname = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter marks: ");
                        String marks = scanner.nextLine();
                        addStudent(sname, age, marks);
                        break;
                    case 2:
                        List<String> students = getAllStudents();
                        for (String student : students) {
                            System.out.println(student);
                        }
                        break;
                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine();  
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter new marks: ");
                        String newMarks = scanner.nextLine();
                        updateStudent(idToUpdate, newName, newAge, newMarks);
                        break;
                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        deleteStudent(idToDelete);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } while (choice != 5);

        scanner.close();
    }

    
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void addStudent(String sname, int age, String marks) throws SQLException {
        String query = "INSERT INTO Student (sname, age, marks) VALUES (?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, sname);
            ps.setInt(2, age);
            ps.setString(3, marks);
            ps.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }

   
    private static List<String> getAllStudents() throws SQLException {
        List<String> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Connection connection = getConnection(); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String student = "ID: " + rs.getInt("sid") + ", Name: " + rs.getString("sname") +
                                 ", Age: " + rs.getInt("age") + ", Marks: " + rs.getString("marks");
                students.add(student);
            }
        }
        return students;
    }

    
    private static void updateStudent(int sid, String sname, int age, String marks) throws SQLException {
        String query = "UPDATE Student SET sname = ?, age = ?, marks = ? WHERE sid = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, sname);
            ps.setInt(2, age);
            ps.setString(3, marks);
            ps.setInt(4, sid);
            ps.executeUpdate();
            System.out.println("Student updated successfully.");
        }
    }

    
    private static void deleteStudent(int sid) throws SQLException {
        String query = "DELETE FROM Student WHERE sid = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sid);
            ps.executeUpdate();
            System.out.println("Student deleted successfully.");
        }
    }
}
