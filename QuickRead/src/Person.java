/**
 * QuickRead - Person Class
 * Standard Person info used by student, admin, and librarian class
 * @author SerialSystems
 * 
 */
public abstract class Person {

    protected int id; // custom id for every person in library system
    protected String password; // custom password for every person in library system
    protected String name; // custom name for every person in library system
    protected String position; // specifies library position of student, admin librarian
    
    static int currentId = 0; // id is incremented by one as each person is created
    
    // constructor for person
    public Person(int id, String password, String name, String position) {
        currentId++;
        if(id == -1) {
            id = currentId;
        } else {
            id = this.id;
        }
        
        password = this.password;
        name = this.name;
        position = this.position;
        
    }
    /**
     * Print person info
     */
    public void printInfo() {
        
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public static void setId(int id) {
        currentId = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    ////////////////////////////////////////////////
    
    
}
