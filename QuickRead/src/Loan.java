import java.util.Date;
/**
 * QuickRead - Loan Class
 * Handles every loan for library users by book
 * @author SerialSystems
 * 
 */
public class Loan {

    private Student student; // student object
    private Book book; // book object
    private Date checkedOut; // date book is checked out
    private Date checkedIn; // date book is checked in
    private boolean fines; // true if student fines is greater than 0
    
    // Constructor
    public Loan(Student student, Book book, Date checkedOut, Date checkedIn,
            boolean fines) {
        student = this.student;
        book = this.book;
        checkedOut = this.checkedOut;
        checkedIn = this.checkedIn;
        fines = this.fines;
          
    }

    // Getters and Setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Date checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Date getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Date checkedIn) {
        this.checkedIn = checkedIn;
    }

    public boolean getFines() {
        return fines;
    }

    public void setFines(boolean fines) {
        this.fines = fines;
    }
    //////////////////////////////////////////////////
    
    /**
     * Calculates fines by each book and adds it to students total fines
     * @return totalFine - double  
     */
    public double addFines() {
        double totalFine = 0;
        if (!fines) {
            Date newCheckedOut = checkedOut;
            Date newCheckedIn = new Date();
            
            long days = (newCheckedIn.getTime() - newCheckedOut.getTime()) / 86400000;
            days = 0 - days;
            days = days - Library.checkoutLimit;
            
            if (days > 0) {
                totalFine = days * Library.dailyFine;
            } else {
                totalFine = 0;       
            }
        }
        return totalFine;   
    }
    
    /**
     * Prompts user to pay fines and allows them to do so 
     */
    public void payFine() {
        double totalFine = addFines();
        
        if (totalFine > 0) {
            fines = true;
        } else {
            System.out.println("no fine");
        }
    }
    
    /**
     * gives a book its new check out date 
     * @param newCheckedOut
     */
    public void renew(Date newCheckedOut) {
        checkedOut = newCheckedOut;
        
    }
}
