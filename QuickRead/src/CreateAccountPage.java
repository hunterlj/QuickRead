import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;

public class CreateAccountPage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblCreateAccount = new JLabel("Create Account");
    private final JLabel lblFullName = new JLabel("Full Name:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JButton btnSignUp = new JButton("Sign Up!");
    private final JTextField textFieldName = new JTextField();
    private final JLabel lblUsername = new JLabel("Username:");
    private final JTextField textFieldUsername = new JTextField();
    private final JLabel lblUser = new JLabel("User:");
    private final JRadioButton rdbtnStudent = new JRadioButton("Student");
    private final JRadioButton rdbtnLibrarian = new JRadioButton("Librarian");
    private final JRadioButton rdbtnAdmin = new JRadioButton("Admin");
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final JTextField textFieldPassword = new JTextField();

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
        textFieldPassword.setBounds(130, 166, 216, 26);
        textFieldPassword.setColumns(10);
        textFieldUsername.setBounds(130, 127, 216, 26);
        textFieldUsername.setColumns(10);
        textFieldName.setBounds(130, 74, 216, 26);
        textFieldName.setColumns(10);
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 498);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateAccount.setBounds(134, 16, 158, 20);
        
        contentPane.add(lblCreateAccount);
        lblFullName.setBounds(37, 77, 100, 20);
        
        contentPane.add(lblFullName);
        lblPassword.setBounds(37, 166, 78, 20);
        
        contentPane.add(lblPassword);
        btnSignUp.setBounds(161, 397, 115, 29);
        
        contentPane.add(btnSignUp);
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSignUpActionPerformed(e);
            }
            private void btnSignUpActionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = textFieldPassword.getText();
                String name = textFieldName.getText();
                String position = null;
                if (rdbtnStudent.isSelected()) {
                    position = "student";
                    ConfirmUser.addUser(username, password, name, position);
                    SearchHomePage.main(new String[] {username});
                }
                else if (rdbtnAdmin.isSelected()) {
                    position = "admin";
                    ConfirmUser.addUser(username, password, name, position);
                }
                else if (rdbtnLibrarian.isSelected()) {
                    position = "librarian";
                    ConfirmUser.addUser(username, password, name, position);
                }
                else {
                    JOptionPane.showMessageDialog(CreateAccountPage.this, "Please select user type!", "Create Account Error", JOptionPane.ERROR_MESSAGE);                  
                }
            }
        });
        
        contentPane.add(textFieldName);
        lblUsername.setBounds(37, 130, 85, 20);
        
        contentPane.add(lblUsername);
        
        contentPane.add(textFieldUsername);
        lblUser.setBounds(68, 228, 69, 20);
        
        contentPane.add(lblUser);
        buttonGroup.add(rdbtnStudent);
        rdbtnStudent.setBounds(134, 224, 155, 29);
        
        contentPane.add(rdbtnStudent);
        buttonGroup.add(rdbtnLibrarian);
        rdbtnLibrarian.setBounds(134, 272, 155, 29);
        
        contentPane.add(rdbtnLibrarian);
        buttonGroup.add(rdbtnAdmin);
        rdbtnAdmin.setBounds(134, 318, 155, 29);
        
        contentPane.add(rdbtnAdmin);
        
        contentPane.add(textFieldPassword);
    }
}
