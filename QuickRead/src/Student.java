import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Loan> borrowedResources;
    
    public Student(int id, String password, String name, String position) {
        super(id, password, name, position);
        
        borrowedResources = new ArrayList();
        
    }
    
    public void printBorrowedResources() {
        if(!borrowedResources.isEmpty()) {
            System.out.println();
            
            
        } else {
            System.out.println("none");
        }
    }
    
    public void checkOutResources(Loan resource) {
        borrowedResources.add(resource);
    }
    
    public void checkInResources(Loan resource) {
        borrowedResources.remove(resource);
    }
    
    public ArrayList<Loan> getBorrowedResources() {
        return borrowedResources;
    }
}
