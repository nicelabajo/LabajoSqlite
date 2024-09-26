
package labajo2d;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Labajo2D {

    //Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:labajo.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    public static void main(String[] args) throws SQLException {
      connectDB();  
      Scanner sc = new Scanner (System.in);
      
        System.out.println("First Name");
       String fn = sc.nextLine();
        System.out.println("Last Name");
        String ln = sc.nextLine();
        System.out.println("Email:");
        String ems = sc.nextLine();
        System.out.println("Status:"); 
        String sts = sc.nextLine();
        
        
       String sql = "INSERT INTO tbl_students (s_fname, s_lname, s_email, s_status) VALUES (?,?,?,?)";
       
       try{
          Connection con = connectDB();
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setString (1, fn);
          pst.setString (2,ln);
          pst.setString (3,ems);
          pst.setString (4,sts);
          pst.executeUpdate();
           System.out.println("Inserted Successfully!!!");
       }catch (SQLException ex) {
           System.out.println("Connection Error:" +ex.getMessage());
           
           
       }
    } 
    
}
