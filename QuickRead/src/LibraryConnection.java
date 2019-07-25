import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LibraryConnection {

    public static void main(String[] args) {
      
      try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryDB", "root", "Password2525");
             String query = "SELECT * FROM books";
             
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while (rs.next()) {
                 int id = rs.getInt("id");
                 String title = rs.getString("title");
                 System.out.println(id + ", " + title);
                 conn.close();
             }      

      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
      
  }
}
