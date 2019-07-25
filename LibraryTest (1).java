import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LibraryTest {
ArrayList ar=new ArrayList();
	@Test
	void testAddStudent() {
		assertTrue(ar.remove("tom"));
	}
	@Test
	void testAddStudent1() {
		assertTrue(ar.add("TOM"));
		assertTrue(ar.add("Peter"));
	}

	@Test
	void testAddLoan() {
		assertTrue(ar.remove("tom"));
	}
	@Test
	void testAddLoan1() {
		assertTrue(ar.add(1));
	}

	@Test
	void testAddBook() {
		assertTrue(ar.remove("tom"));
	}

	@Test
	void testAddBook1() {
		assertTrue(ar.add("Herry Potter"));
	}


	@Test
	void testAddBookString() {
		assertEquals("Herry Potter","JK.Rowling","Magic novel");
	}
	@Test
	void testAddBookString1() {
		Library bk=new Library();
		bk.addBook("Herry Potter","JK.Rowling","Magic novel",true);
		
	}
}
