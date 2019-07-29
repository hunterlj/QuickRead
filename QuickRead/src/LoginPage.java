import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;

public class LoginPage {

    private JFrame frame;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JRadioButton btnSignIn;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage window = new LoginPage();
                    window.frame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @wbp.parser.entryPoint
     */
    public LoginPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(153, 204, 255));
        frame.setBounds(100, 100, 476, 388);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblUsername.setBounds(70, 102, 82, 20);
        frame.getContentPane().add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setBackground(new Color(255, 255, 255));
        txtUsername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
        txtUsername.setBounds(153, 99, 178, 26);
        frame.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblPassword.setBounds(70, 149, 82, 20);
        frame.getContentPane().add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setBackground(new Color(255, 255, 255));
        txtPassword.setBounds(153, 146, 178, 26);
        frame.getContentPane().add(txtPassword);
        txtPassword.setColumns(10);
        
        JRadioButton rdbtnStudent = new JRadioButton("Student");
        rdbtnStudent.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        buttonGroup_1.add(rdbtnStudent);
        rdbtnStudent.setBounds(138, 181, 87, 45);
        frame.getContentPane().add(rdbtnStudent);
        
        JRadioButton rdbtnAdmin = new JRadioButton("Admin");
        rdbtnAdmin.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        buttonGroup_1.add(rdbtnAdmin);
        rdbtnAdmin.setBounds(232, 182, 82, 42);
        frame.getContentPane().add(rdbtnAdmin);
        
        JLabel lblQuicksearch = new JLabel("QuickSearch");
        lblQuicksearch.setForeground(new Color(255, 255, 0));
        lblQuicksearch.setBackground(new Color(255, 255, 255));
        lblQuicksearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuicksearch.setBounds(130, 16, 212, 45);
        lblQuicksearch.setFont(new Font("HanziPen TC", Font.BOLD, 24)); //make is bigger
        frame.getContentPane().add(lblQuicksearch);
        
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("HanziPen SC", Font.PLAIN, 16));
        lblLogin.setBounds(219, 63, 69, 20);
        frame.getContentPane().add(lblLogin);
        
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        btnSignIn.setBackground(new Color(255, 255, 102));
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnSignIn.setBounds(183, 238, 115, 29);
        frame.getContentPane().add(btnSignIn);
        
        JLabel lblUser = new JLabel("User:");
        lblUser.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblUser.setBounds(103, 193, 38, 20);
        frame.getContentPane().add(lblUser);
        
        JRadioButton rdbtnLibrarian = new JRadioButton("Librarian");
        rdbtnLibrarian.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        buttonGroup_1.add(rdbtnLibrarian);
        rdbtnLibrarian.setBounds(318, 189, 125, 29);
        frame.getContentPane().add(rdbtnLibrarian);
    }
}
