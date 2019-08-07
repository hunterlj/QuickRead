import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * QuickRead - Book Class
 * Creates book
 * @author SerialSystems
 * 
 */
public class Book {
    
    public static boolean addBook(String title, String author, String subject, String description) {
        boolean status = false;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into books values(?, ?, ?, ?)"); 
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, subject);
            ps.setString(4, description);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static boolean requestBook(String title, String author, String subject, String description) {
        boolean status = false;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into requests values(?, ?, ?, ?)"); 
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, subject);
            ps.setString(4, description);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }     
        return status;
    }
    
    public static boolean denyRequest(String title) {
        boolean status = false;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("delete requests where title = ?"); 
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        } 
        return status;
    }
    
}
