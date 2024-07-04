
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
class javacon{
    public static void main(String[] args) {
        Connection c;
       Statement stmt;   
       ResultSet rs; 
        try{
            Properties p = new Properties();
            FileInputStream in = new FileInputStream("db.properties");
            p.load(in);
            String url = p.getProperty("db.url");
            String user = p.getProperty("db.user");
            String pass = p.getProperty("db.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, user, pass);
            stmt = c.createStatement();
            String str = "CREATE TABLE Student " +
                                    "(sid INTEGER PRIMARY KEY, " +
                                    "name VARCHAR(255))";
            int i=stmt.executeUpdate(str);
            rs = stmt.executeQuery("SELECT * FROM persons");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) +"  " + rs.getString(3) + " " + rs.getString(4));
            }       
        } 
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}