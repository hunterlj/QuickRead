/**
 * QuickRead - Book Class
 * Creates book
 * @author SerialSystems
 * 
 */
public class Book {

    private int serial; // serial number for book
    private String title; // title of book
    private String author; // author of book
    private String subject; // subject of book
    private boolean isCheckedIn; // true if checked out, false otherwise
    
    static int currentSerial = 0; // serial iterated by 1 for each new book
    
    // Constructor for book assigning info and setting status to checked in
    public Book(int serial, String title, String author, String subject, 
            boolean checkedIn) {
        
        currentSerial++;
        
        if (serial == -1) {
            serial = currentSerial;
        } else {
            serial = this.serial;
        }
        
        title = this.title;
        author = this.author;
        subject = this.subject;
        isCheckedIn = checkedIn;
        
    }
    
    // Getters and Setters
    public static void setSerial(int serial) {
        currentSerial = serial;
    }
    
    public int getSerial() {
        return serial;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setStatus(boolean status) {
        isCheckedIn = status;
    }
    
    public boolean getStatus() {
        return isCheckedIn;
    }   
    /////////////////////////////////////////////////////////
    
    // Print book info seperated by a space;
    public void printInfo() {
        
        System.out.println(serial + " " + title + " " + author + " " + subject);
        
    }
    
    /**
     * allows student to check out a book if it is checked in and sets status of checked in to false;
     * @param student
     */
    public void checkOut(Student student) {
        if (!isCheckedIn) {
            System.out.println("ERROR");
        } else {
            setStatus(false);
            // change loan
            
        }
    }
    
    /**
     * allows student to check in a book, and changes status of checked in to true;
     * @param student
     */
    public void checkIn(Student student) {
        setStatus(true);
    }
    
    
}
