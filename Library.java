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
/**
 * QuickRead - Library Class
 * Main class for connection to SQL database.
 * @author SerialSystems
 * 
 */

public class Library {
    
    private ArrayList<Person> people; // every person in library system
    private ArrayList<Book> allBooks; // every book in library system
    private ArrayList<Loan> allLoans; // every loan in library system
    
    public static final double dailyFine = .1; // ten cents a day fine for overdue books
    public static final int checkoutLimit = 30; // 30 day limit for checking out book
    
    // constructor creating new array lists for people, books, and loans
    private Library() {
        people = new ArrayList();
        allBooks = new ArrayList();
        allLoans = new ArrayList();
    }

    /*
     * Getters and Setters
     */
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
    
    //////////////////////////////////////////////////////////
    
    /**
     * add an already created book to array list
     * @param book
     */
    public void addBook(Book book) {
        allBooks.add(book);
    }
    
    /**
     * allows user to search the book array list 
     * @return choice - users search results from ArrayList<Book> 
     * @throws IOException
     */
    public ArrayList<Book> searchBooks() throws IOException {
        String choice;
        String title = "", subject = "", author = "";
        
        return null;
    }
    
    /**
     * allows librarian to create book by providing title, author, and subject 
     * and adds it to the array list
     * @param title
     * @param author
     * @param subject
     */
    public void addBook(String title, String author, String subject) {
        Book book = new Book(-1, title, author, subject, false);
        addBook(book);
    }
    
    /**
     * allows user to login using username and password
     * @return user - Person info
     */
    public Person login() {
        return null;
    }
    
    /**
     * connects to host for SQL 
     * @return
     */
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
