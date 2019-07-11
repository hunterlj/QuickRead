
public class Book {

    private int serial;
    private String title;
    private String author;
    private String subject;
    private boolean isCheckedIn; // true if checked out, false otherwise
    
    static int currentSerial = 0;
    
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
    
    public void printInfo() {
        
        System.out.println(serial + " " + title + " " + author + " " + subject);
        
    }
    
    public void checkOut(Student student) {
        if (!isCheckedIn) {
            System.out.println("ERROR");
        } else {
            setStatus(false);
            // change loan
            
        }
    }
    
    public void checkIn(Student student) {
        setStatus(true);
    }
    
    
}
