import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * QuickRead - LibraryConnection Class
 * Main class for connection to SQL database.
 * @author SerialSystems
 * 
 */
public class LibraryConnection {

//    public static void main(String[] args) {
//      
//      try {
//          Class.forName("com.mysql.jdbc.Driver");
//          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryDB", "root", "Password2525");
//             String query = "SELECT * FROM books";
//             
//             Statement st = conn.createStatement();
//             ResultSet rs = st.executeQuery(query);
//             while (rs.next()) {
//                 int id = rs.getInt("id");
//                 String title = rs.getString("title");
//                 System.out.println(id + ", " + title);
//                 conn.close();
//             }      
//
//      } catch (Exception e) {
//          System.out.println(e.getMessage());
//      }
//      
//  }
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryDB", "root", "Password2525");
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
