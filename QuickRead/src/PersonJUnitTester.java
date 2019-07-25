import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Keyon
 * First flaw: Found that the person class was an abstract class. You cannot
 * instantiate abstract classes.
 * 
 * Second flaw: In the Person.java class the "this." instances were switched around.
 * I switched them back.
 * EDIT: AND IT WAS AFTER MULTIPLE SYSOUTS!!
 * 
 * 
 *
 */
public class PersonJUnitTester {

	@Test
	public void testPerson() {
		Person p = new Person(43, "password", "Jackson", "student");
		
		assertEquals("password", p.getPassword());
	}

	@Test
	public void testGetId() {
		Person pe = new Person(43, "password", "Jackson", "student");
		
		assertEquals(43, pe.getId());
	}

	@Test
	public void testGetName() {
		Person perr = new Person(43, "password", "Jackson", "student");
		
		assertEquals("Jackson", perr.getName());
	}

	@Test
	public void testGetPosition() {
		Person per = new Person(43, "password", "Jackson", "student");
		
		assertEquals("student", per.getPosition());
	}

}
