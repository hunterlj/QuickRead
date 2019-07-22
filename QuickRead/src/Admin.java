/**
 * QuickRead - Admin Class
 * Creates library administrator, extending Person class
 * @author SerialSystems
 * 
 */
public class Admin extends Person {

    public Admin(int id, String password, String name, String position) {
        super(id, password, name, position);
        
    }
    
    /**
     * for approval of librarians request for new book in library
     */
    public void approveRequest() {
        
    }

    
}
