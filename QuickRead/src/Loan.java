import java.sql.*;
import javax.swing.JTextField;

public class Loan {

    public static int IssueBook(int bookId, int userId, String issueDate, String returnDate) {
        int status = 0;
        try (Connection con = LibraryConnection.getConnection()){           
            PreparedStatement ps = con.prepareStatement("insert into issuedbook values(?, ?, ?, ?)");
            ps.setInt(1,bookId);
            ps.setInt(2, userId);
            ps.setString(3, issueDate);
            ps.setString(4, returnDate);
            status = ps.executeUpdate();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }


    public static int ReturnBook(int bookId,int userId) {
        int status = 0;
        try (Connection con = LibraryConnection.getConnection()){     
            PreparedStatement ps = con.prepareStatement("delete from issuedbook where bookId = ? and userId = ?");
            ps.setInt(1, bookId);
            ps.setInt(2, userId);
            status = ps.executeUpdate();
            con.close();
        } catch(Exception e) { 
            System.out.println(e);
        }
        return status;
    }

    public static boolean CheckIssuedBook(int BookID) {
        boolean status = false;
        try (Connection con = LibraryConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from issuedbook where bookId = ?"); 
            ps.setInt(1, BookID);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }

}
