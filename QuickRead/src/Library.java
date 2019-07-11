import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;


public class Library {
    
    private ArrayList<Person> people;
    private ArrayList<Book> allBooks;
    private ArrayList<Loan> allLoans;
    
    public static final double dailyFine = .1; // ten cents a day
    public static final int checkoutLimit = 30; // 30 day limit
    
    private Library() {
        people = new ArrayList();
        allBooks = new ArrayList();
        allLoans = new ArrayList();
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public ArrayList<Loan> getAllLoans() {
        return allLoans;
    }

    public void setAllLoans(ArrayList<Loan> allLoans) {
        this.allLoans = allLoans;
    }
    
    public void addBook(Book book) {
        allBooks.add(book);
    }
    
    public ArrayList<Book> searchBooks() throws IOException {
        String choice;
        String title = "", subject = "", author = "";
        
        return null;
    }
    
    public void addBook(String title, String author, String subject) {
        Book book = new Book(-1, title, author, subject, false);
        addBook(book);
    }
    
    public Person login() {
        return null;
    }
    
    public Connection connect() {
        try {
            String host = "";
            String username = "QuickSearch";
            String password = "SerialSystems";
            Connection connection = DriverManager.getConnection(host,  username,  password);
            return connection;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;   
        }
    }
    
    
    
//    public void makeLibrary(Connection connection) throws SQLException, IOException {
//        Library library = this;
//        Statement statement = connection.createStatement();
//        
//        String SQL = "SELECT * FROM BOOK";
//        ResultSet set = statement.executeQuery(SQL);
//        
//        if (!set.next()) {
//            System.out.println("no books");
//        } else {
//            int topID = 0;
//        }
//        do {
//            if(statement.getInt("ID") != 0 && statement.getString("TITLE") != null 
//                    && statement.getString("AUTHOR") != null && statement.getString("SUBJECT")) {
//                String title = statement.getString("TITLE");
//                
//            }
//        }
//        
//    }
    
    
}
