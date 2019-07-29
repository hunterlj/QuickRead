import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;

public class CreateAccountPage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblCreateAccount = new JLabel("Create Account");
    private final JLabel lblFullName = new JLabel("Full Name:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JButton btnSignUp = new JButton("Sign Up!");
    private final JTextField textField = new JTextField();
    private final JLabel lblUsername = new JLabel("Username:");
    private final JTextField textField_2 = new JTextField();
    private final JLabel lblUser = new JLabel("User:");
    private final JRadioButton rdbtnStudent = new JRadioButton("Student");
    private final JRadioButton rdbtnLibrarian = new JRadioButton("Librarian");
    private final JRadioButton rdbtnAdmin = new JRadioButton("Admin");
    private final JPasswordField passwordField = new JPasswordField();
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateAccountPage frame = new CreateAccountPage();
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
    public CreateAccountPage() {
        textField_2.setBounds(130, 127, 162, 26);
        textField_2.setColumns(10);
        textField.setBounds(130, 74, 162, 26);
        textField.setColumns(10);
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 498);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 0));
        contentPane.setBackground(new Color(153, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblCreateAccount.setForeground(new Color(255, 255, 0));
        lblCreateAccount.setFont(new Font("HanziPen SC", Font.PLAIN, 28));
        lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateAccount.setBounds(118, 16, 185, 49);
        
        contentPane.add(lblCreateAccount);
        lblFullName.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblFullName.setBounds(37, 77, 100, 20);
        
        contentPane.add(lblFullName);
        lblPassword.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblPassword.setBounds(37, 166, 78, 20);
        
        contentPane.add(lblPassword);
        btnSignUp.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        btnSignUp.setBackground(new Color(255, 255, 255));
        btnSignUp.setBounds(161, 397, 115, 29);
        
        contentPane.add(btnSignUp);
        
        contentPane.add(textField);
        lblUsername.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblUsername.setBounds(37, 130, 85, 20);
        
        contentPane.add(lblUsername);
        
        contentPane.add(textField_2);
        lblUser.setFont(new Font("HanziPen SC", Font.PLAIN, 16));
        lblUser.setBounds(68, 228, 69, 20);
        
        contentPane.add(lblUser);
        buttonGroup.add(rdbtnStudent);
        rdbtnStudent.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        rdbtnStudent.setBounds(134, 224, 155, 29);
        
        contentPane.add(rdbtnStudent);
        buttonGroup.add(rdbtnLibrarian);
        rdbtnLibrarian.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        rdbtnLibrarian.setBounds(134, 272, 155, 29);
        
        contentPane.add(rdbtnLibrarian);
        buttonGroup.add(rdbtnAdmin);
        rdbtnAdmin.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        rdbtnAdmin.setBounds(134, 318, 155, 29);
        
        contentPane.add(rdbtnAdmin);
        passwordField.setBounds(130, 163, 162, 26);
        
        contentPane.add(passwordField);
    }
}
