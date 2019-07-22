import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LibraryConnection {

    public static void main(String[] args) {
      
      try {
          String myDriver = "com.mysql.jdbc.Driver";
          String myURL = "jdcb:mysql://localhost/libraryDB";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myURL, "root", "root");
             String query = "SELECT * FROM books";
             
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
                 int id = rs.getInt("id");
                 String title = rs.getString("title");
                 System.out.println(id + ", " + title);
             } 
             
             st.close();

      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
      
  }
}
