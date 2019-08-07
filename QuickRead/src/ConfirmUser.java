import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConfirmUser {


    public static boolean validate(String username,String password, String position){
        boolean status = false;
        try {
            Connection con = LibraryConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Users where username=? and password=? and position=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, position);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int addUser(String username, String password, String name, String position) {     
        int status = 0;
        try {       
            Connection con = LibraryConnection.getConnection();
            PreparedStatement ps= con.prepareStatement("INSERT INTO Users(username, password, name, position) values(?,?,?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,name);
            ps.setString(4,position);
            status = ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status; 
    }
    
    public static String getPosition(String user) {
        String position = "";
        try {
            Connection con = LibraryConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select position from Users where username = ?");
            ps.setString(1, user);            
            ResultSet rs = ps.executeQuery();
            position = rs.getString(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return position;
    }
}

