import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CreateAccountPage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblCreateAccount = new JLabel("Create Account");
    private final JLabel lblFullName = new JLabel("Full Name:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JButton btnSignUp = new JButton("Sign Up!");
    private final JTextField textField = new JTextField();
    private final JTextField textField_1 = new JTextField();

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
        textField_1.setBounds(130, 110, 146, 26);
        textField_1.setColumns(10);
        textField.setBounds(130, 74, 146, 26);
        textField.setColumns(10);
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
        lblPassword.setBounds(37, 113, 78, 20);
        
        contentPane.add(lblPassword);
        btnSignUp.setBounds(161, 397, 115, 29);
        
        contentPane.add(btnSignUp);
        
        contentPane.add(textField);
        
        contentPane.add(textField_1);
    }

}
