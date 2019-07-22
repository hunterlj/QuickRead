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
    private boolean getFined = false;
    private int fines; 
    
    // Constructor
    public Loan(Student student, Book book, Date checkedOut, Date checkedIn, boolean getFined,
            int fines) {
        setGetFined(getFined);
        setStudent(student);
        setBook(book);
        setCheckedOut(checkedOut);
        setCheckedIn(checkedIn);
        setFines(fines);
          
    }

    public void setGetFined(boolean getFined) {
        this.getFined = getFined;
        
    }
    
    public Boolean getGetFined() {
        return getFined;
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

    public int getFines() {
        return fines;
    }

    public void setFines(int fines) {
        this.fines = fines;
    }
    //////////////////////////////////////////////////
    
    /**
     * Calculates fines by each book and adds it to students total fines
     * @return totalFine - double  
     */
    public double addFines() {
        double totalFine = 0;
        
            Date newCheckedOut = checkedOut;
            Date newCheckedIn = checkedIn;
            
            long days = (newCheckedOut.getTime() - newCheckedIn.getTime()) / 86400000;
            days = 0 - days;
            days = days - Library.checkoutLimit;
            
            if (days > 0) {
                totalFine = days * Library.dailyFine;
                getFined = true;
            } else {
                totalFine = 0;      
                getFined = false;
            
        }
        return totalFine;   
    }
    
    /**
     * Prompts user to pay fines and allows them to do so 
     */
    public void payFine() {
        double totalFine = addFines();
        
        if (totalFine > 0) {
            getFined = true;
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
    
    public String toString() {
        return student + " " + book + " " + checkedOut + " " + checkedIn + " " + getFined;
    }
}
