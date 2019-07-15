import java.util.ArrayList;
/**
 * QuickRead - Student Class
 * Creates library student users, extending Person class and allows them specified access
 * @author SerialSystems
 * 
 */
public class Student extends Person {

    private ArrayList<Loan> borrowedBooks; // list of books borrrowed by each user
    
    // constructor using person info and giving a list in which borrowed books can be stored
    public Student(int id, String password, String name, String position) {
        super(id, password, name, position);
        
        borrowedBooks = new ArrayList<Loan>();    
    }
    
    /**
     * Prints the list of borrowed books
     */
    public void printBorrowedResources() {
        if(!borrowedBooks.isEmpty()) {
            System.out.println(borrowedBooks);
            
            
        } else {
            System.out.println("No Books Borrowed");
        }
    }
    
    /**
     * adds a book to the users borrowed book list
     * @param resource
     */
    public void checkOutResources(Loan resource) {
        borrowedBooks.add(resource);
    }
    
    /**
     * removes a book from the users borrowed book list
     * @param resource
     */
    public void checkInResources(Loan resource) {
        borrowedBooks.remove(resource);
    }
    
    // Getter
    public ArrayList<Loan> getBorrowedResources() {
        return borrowedBooks;
    }
}
