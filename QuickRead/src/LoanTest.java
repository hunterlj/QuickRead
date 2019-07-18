import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class LoanTest {
    int serial = 1;
    String title = "Dracula";
    String author = "Bram Stoker";
    String subject = "Fiction";
    Boolean isCheckedIn = true;
    
    Book newBook = new Book(serial, title, author, subject, isCheckedIn);
    
    int id = 1;
    String password = "password123";
    String name = "John Smith";
    String position = "Student"; 
    
    Student newStudent = new Student(id, password, name, position);
    
    
    Date checkedOutDate = new Date(2019, 07, 01);
    Date checkedInDate = new Date(2019, 07, 20);
    Boolean fines = false;
    
    Loan newLoan = new Loan(newStudent, newBook, checkedOutDate, checkedInDate, fines);
    
    @Test
    public void testLoan() {
        assertEquals(newLoan.getStudent(), "John Smith");
        assertEquals(newLoan.getBook(), "Dracula");
        assertEquals(newLoan.getFines(), false);
    }

    @Test
    public void testAddFines() {
        fail("Not yet implemented");
    }

    @Test
    public void testPayFine() {
        fail("Not yet implemented");
    }

    @Test
    public void testRenew() {
        fail("Not yet implemented");
    }

}
