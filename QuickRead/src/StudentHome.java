import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;

public class StudentHome extends JFrame {

    private JPanel contentPane;
    private final JLabel lblStudentAccount = new JLabel("Student Account ");
    private final JLabel lblName = new JLabel("Name:");
    private final JLabel lblUsername = new JLabel("Username:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JLabel lblCurrentBooksIssued = new JLabel("Current Books Issued:");
    private final JLabel lblFines = new JLabel("Fines:");
    private final JScrollPane scrollPane = new JScrollPane();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentHome frame = new StudentHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public StudentHome() {
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 484);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblStudentAccount.setBounds(145, 16, 121, 20);
        
        contentPane.add(lblStudentAccount);
        lblName.setBounds(15, 53, 95, 20);
        
        contentPane.add(lblName);
        lblUsername.setBounds(15, 89, 95, 20);
        
        contentPane.add(lblUsername);
        lblPassword.setBounds(15, 125, 95, 20);
        
        contentPane.add(lblPassword);
        lblCurrentBooksIssued.setBounds(15, 191, 169, 20);
        
        contentPane.add(lblCurrentBooksIssued);
        lblFines.setBounds(311, 191, 69, 20);
        
        contentPane.add(lblFines);
        scrollPane.setBounds(15, 236, 398, 176);
        
        contentPane.add(scrollPane);
    }
}
