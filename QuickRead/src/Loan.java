import java.util.Date;

public class Loan {

    private Student student;
    private Book book;
    private Date checkedOut;
    private Date checkedIn;
    private boolean fines;
    
    public Loan(Student student, Book book, Date checkedOut, Date checkedIn,
            boolean fines) {
        student = this.student;
        book = this.book;
        checkedOut = this.checkedOut;
        checkedIn = this.checkedIn;
        fines = this.fines;
          
    }

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

    public boolean isFines() {
        return fines;
    }

    public void setFines(boolean fines) {
        this.fines = fines;
    }
    
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
    
    public void payFine() {
        double totalFine = addFines();
        
        if (totalFine > 0) {
            fines = true;
        } else {
            System.out.println("no fine");
        }
    }
    
    public void renew(Date newCheckedOut) {
        checkedOut = newCheckedOut;
        
    }
}
