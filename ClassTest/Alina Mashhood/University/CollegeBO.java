import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CollegeBO {
    private static final String URL = "jdbc:mysql://localhost:3306/college_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "Alina@07"; 
    public List<College> findCollege(List<String> nameList) {
        List<College> colleges = new ArrayList<>();
        String query = "SELECT * FROM colleges WHERE name IN (" + String.join(",", nameList) + ")";        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();           
            while (rs.next()) {
                colleges.add(new College(
                    rs.getString("name"),
                    rs.getString("website"),
                    rs.getString("mobile"),
                    rs.getString("founder"),
                    rs.getInt("numberOfDept"),
                    rs.getString("location"),
                    rs.getDate("startingDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return colleges;
    }    
    public List<College> findCollege(Date startingDate) {
        List<College> colleges = new ArrayList<>();
        String query = "SELECT * FROM colleges WHERE startingDate = ?";        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDate(1, new java.sql.Date(startingDate.getTime()));
            ResultSet rs = pst.executeQuery();            
            while (rs.next()) {
                colleges.add(new College(
                    rs.getString("name"),
                    rs.getString("website"),
                    rs.getString("mobile"),
                    rs.getString("founder"),
                    rs.getInt("numberOfDept"),
                    rs.getString("location"),
                    rs.getDate("startingDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return colleges;
    }    
    public List<College> findCollege(String location) {
        List<College> colleges = new ArrayList<>();
        String query = "SELECT * FROM colleges WHERE location = ?";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, location);
            ResultSet rs = pst.executeQuery();            
            while (rs.next()) {
                colleges.add(new College(
                    rs.getString("name"),
                    rs.getString("website"),
                    rs.getString("mobile"),
                    rs.getString("founder"),
                    rs.getInt("numberOfDept"),
                    rs.getString("location"),
                    rs.getDate("startingDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return colleges;
    }
}

