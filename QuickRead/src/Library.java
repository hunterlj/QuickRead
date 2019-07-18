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
    
    private ArrayList<Person> allPeople; // every person in library system
    private ArrayList<Book> allBooks; // every book in library system
    private ArrayList<Loan> allLoans; // every loan in library system
    
    private Librarian librarian;
    private Admin admin;
    public static final double dailyFine = .1; // ten cents a day fine for overdue books
    public static final int checkoutLimit = 30; // 30 day limit for checking out book
    
    // constructor creating new array lists for people, books, and loans
    private Library() {
        allPeople = new ArrayList();
        allBooks = new ArrayList();
        allLoans = new ArrayList();
        
        librarian = null;
        admin = null;
    }

    /*
     * Getters and Setters
     */
    public ArrayList<Person> getPeople() {
        return allPeople;
    }

    public void setPeople(ArrayList<Person> allPeople) {
        this.allPeople = allPeople;
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
    
    public Librarian getLibrarian() {
        return librarian;
    }
    
    
    
    //////////////////////////////////////////////////////////
    /**
     * add a librarian to the list of people
     * @param librarian
     * @return true 
     */
    public boolean addLibrarian(Librarian librarian) {
        librarian = this.librarian;
        allPeople.add(librarian);
        return true;
    }
    
    /**
     * add a student to the list of people
     * @param student
     */
    public void addStudent(Student student) {
        allPeople.add(student);
    }
    
    /**
     * add a loan to list of loans
     * @param loan
     */
    public void addLoan(Loan loan) {
        allLoans.add(loan);
    }
    
    /**
     * add a book to list of books
     * @param book
     */
    public void addBook(Book book) {
        allBooks.add(book);
    }
    
    /**
     * find students account by searching their name
     * @return
     */
    public Student findStudent() {
        return null;
    }
    
    /**
     * allows user to search the book array list 
     * @return choice - users search results from ArrayList<Book> 
     * @throws IOException
     */
    public ArrayList<Book> findBook() throws IOException {
        String choice;
        String title = "", subject = "", author = "";
        
        return null;
    }
    
    /**
     * constructs table of all books in library showing info
     */
    public void viewAllBooks() {
        
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
    
    
    
    public void makeLibrary(Connection connection) throws SQLException, IOException {
        Library library = this;
        Statement statement = connection.createStatement();
        
        String SQL = "SELECT * FROM BOOK";
        ResultSet set = statement.executeQuery(SQL);
        
        if (!set.next()) {
            System.out.println("no books");
        } else {
            int topSerial = 0;
        do {
            if (set.getInt("ID") != 0 && set.getString("TITLE") != null 
                    && set.getString("AUTHOR") != null && set.getString("SUBJECT") != null) {
                int serial = set.getInt("ID");
                String title = set.getString("TITLE");
                String author = set.getString("AUTHOR");
                String subject = set.getString("SUBJECT");
                boolean isCheckedIn = set.getBoolean("IS_CHECKEDIN");
                Book book = new Book(serial, title, subject, author, isCheckedIn);
                addBook(book);
                
                if(topSerial < serial) {
                    topSerial = serial;
                }                                
            }
        }while(set.next());
        
        Book.setSerial(topSerial);
        }
        
        // Create Loan
        SQL = "SELECT * FROM LOAN";
        
        set = statement.executeQuery(SQL);
        if(!set.next()) {
            System.out.println("No Books Issued Yet!");
        }
        
    }
}
    
    