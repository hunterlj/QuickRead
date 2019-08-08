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
    
    public static int addBook(String title, String author, String subject, String description) {
        int status = 0;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into books (title, author, subject, description) values(?, ?, ?, ?)"); 
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, subject);
            ps.setString(4, description);
            status = ps.executeUpdate();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public static int requestBook(String title, String author, String subject, String description) {
        int status = 0;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into requests (title, author, subject, description) values(?, ?, ?, ?)"); 
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, subject);
            ps.setString(4, description);
            status = ps.executeUpdate();         
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }     
        return status;
    }
    
    public static int denyRequest(String title) {
        int status = 0;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("delete from requests where title = ?"); 
            ps.setString(1, title);
            status = ps.executeUpdate();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        } 
        return status;
    }
    
    
    
}
