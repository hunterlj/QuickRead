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
 * Main class for handling users and books
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
        // INSERT INTO Users (username, password, name, position) VALUES (librarian.username, librarian.password, librarian.name, 'librarian') 
        librarian = this.librarian;
        allPeople.add(librarian);
        return true;
    }
    
    /**
     * add a student to the list of people
     * @param student
     */
    public void addStudent(Student student) {
        // INSERT INTO Users (username, password, name, position) VALUES (student.username, student.password, student.name, 'student')
        
        // connect to db or use connection parameter
        // run the query
        // fetch sql.lastrowinsert ????
        allPeople.add(student);
    }
    
    /**
     * add a loan to list of loans
     * @param loan
     */
    public void addLoan(Loan loan) {
        // INSERT INTO CheckedBooks (bookId, userId) VALUES (loan.book.id, loan.Student.id)
        allLoans.add(loan);
    }
    
    /**
     * add a book to list of books
     * @param book
     */
    public void addBook(Book book) {
        // INSERT INTO Books (serial, title, author, subject, isCheckedIn) VALUES (book.serial, book.title, book.author, book.subject, book.isCheckedIn);
        allBooks.add(book);
    }
    
    /**
     * find students account by searching their name
     * @return
     */
    public Student findStudent(String name) {
        // SELECT * FROM Users WHERE name LIKE '%?%' AND position = 'student'
        // ? indicates using a prepared statement. 
        return null;
    }
    
    /**
     * allows user to search the book array list 
     * @return choice - users search results from Database
     * @throws IOException
     */
    public Book findBook(String searchQuery) throws IOException {
        // SQL STATEMENT: SELECT * FROM BOOK WHERE NAME LIKE '%searchQuery%'
        String choice;
        String title = "", subject = "", author = "";
        
        return null;
    }
    
    /**
     * constructs table of all books in library showing info
     */
    public void viewAllBooks() {
        // SQL Statement: SELECT * FROM BOOK
    }
    
    /**
     * allows librarian to create book by providing title, author, and subject 
     * and adds it to the array list
     * @param title
     * @param author
     * @param subject
     */
    public void addBook(String title, String author, String subject, String description) {
        // SQL STATEMENT: INSERT INTO BOOK (title, author, subject) VALUES (title, author, subject)
        Book book = new Book(-1, title, author, subject, false, description);
        addBook(book);
    }
    
    /**
     * allows user to login using username and password
     * @return user - Person info
     */
    // possibly change this to boolean
    public Person login(String username, String password) {
        // SQL STATEMENT: SELECT username, password from Users WHERE username = username
        
        // connect
        // fetch username / password from query
        // check password = password
        return null;
    }
    
    /**
     * connects to host for SQL 
     * @return
     */
    public Connection con() {
        try {
            String host = "jdbc:mysql://localhost:3306/LibraryDB?useSSL=false";
            String username = "LibraryUser";
            String password = "Password2525";
            Connection connection = DriverManager.getConnection(host,  username,  password);
            return connection;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
        
//        try {
//            String myDriver = "com.mysql.jdbc.Driver";
//            String myURL = "jdcb:mysql://localhost/libraryDB";
//            Class.forName(myDriver);
//            Connection conn = DriverManager.getConnection(myURL, "libraryUser", "Password2525");
//               String query = "SELECT * FROM books";
//               
//               Statement st = conn.createStatement();
//               ResultSet rs = st.executeQuery(query);
//               while (rs.next()) {
//                   int id = rs.getInt("id");
//                   String title = rs.getString("title");
//                   System.out.println(id + ", " + title);
//               } 
//               
//               st.close();
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        
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
                String description = set.getString("DESCRIPTION");
                boolean isCheckedIn = set.getBoolean("IS_CHECKEDIN");
                Book book = new Book(serial, title, subject, author, isCheckedIn, description);
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
    
    