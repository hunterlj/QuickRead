
public abstract class Person {

    protected int id;
    protected String password;
    protected String name;
    protected String position;
    
    static int currentId = 0;
    
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
    
    public void printInfo() {
        
    }

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
    
    
    
}
