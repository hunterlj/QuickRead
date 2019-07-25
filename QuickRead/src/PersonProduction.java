/**
 * 
 */

/**
 * @author Keyon
 *
 */
import java.util.*;
public class PersonProduction {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("This is the production code of the Person class. \nPlease enter the name: ");
		String name = input.next();
		
		System.out.println("Now enter the password: ");
		String password = input.next();
		
		System.out.println("Are you a student? (Please type 'yes' or 'no') ");
		String position = input.next();
		if (position.equals("yes")) {
			System.out.println("Welcome! Thank you for registering with us!");
		} else if (position.equals("no")) {
			System.out.println("The rest of the code has yet to be determined......");
		}
		input.close();
		
		Person p = new Person(1, name, password, position);
		p.printInfo();
	}
}
