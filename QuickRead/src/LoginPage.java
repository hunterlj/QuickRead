import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class LoginPage extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField password;
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
                    LoginPage frame = new LoginPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LoginPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 476, 388);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setBounds(70, 102, 82, 20);
        getContentPane().add(lblUsername);

        username = new JTextField();
        username.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameActionPerformed(e);
            }

            private void usernameActionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        username.setHorizontalAlignment(SwingConstants.LEFT);
        username.setBounds(153, 99, 178, 26);
        getContentPane().add(username);
        username.setColumns(10);

        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(70, 149, 82, 20);
        getContentPane().add(lblPassword);

        password = new JTextField();
        password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordActionPerformed(e);
            }

            private void passwordActionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        password.setBounds(153, 146, 178, 26);
        getContentPane().add(password);
        password.setColumns(10);

        JRadioButton rdbtnStudent = new JRadioButton("Student");
        buttonGroup_1.add(rdbtnStudent);
        rdbtnStudent.setBounds(138, 181, 87, 45);
        getContentPane().add(rdbtnStudent);

        JRadioButton rdbtnAdmin = new JRadioButton("Admin");
        buttonGroup_1.add(rdbtnAdmin);
        rdbtnAdmin.setBounds(232, 182, 82, 42);
        getContentPane().add(rdbtnAdmin);

        JRadioButton rdbtnLibrarian = new JRadioButton("Librarian");
        buttonGroup_1.add(rdbtnLibrarian);
        rdbtnLibrarian.setBounds(318, 189, 125, 29);
        getContentPane().add(rdbtnLibrarian);



        JLabel lblQuicksearch = new JLabel("QuickSearch");
        lblQuicksearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuicksearch.setBounds(186, 16, 112, 45);
        getContentPane().add(lblQuicksearch);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(219, 63, 69, 20);
        getContentPane().add(lblLogin);

        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSignInActionPerformed(e);
            }

            private void btnSignInActionPerformed(ActionEvent e) {
                String user = username.getText();
                String pass = password.getText();
                String pos = null;
                if (rdbtnStudent.isSelected()) {
                    pos = "student";
                }
                else if (rdbtnAdmin.isSelected()) {
                    pos = "admin";
                }
                else if (rdbtnLibrarian.isSelected()) {
                    pos = "librarian";
                }
                else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Please select user type!", "Login Error", JOptionPane.ERROR_MESSAGE);                  
                }
                ConfirmUser.validate(user, pass, pos);
                if (ConfirmUser.validate(user, pass, pos)) {
                    dispose(); 
                    SearchHomePage.main(new String[] {user});
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Incorrect username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
                    username.setText("");
                    password.setText("");
                }

            }
        });
        btnSignIn.setBounds(183, 238, 115, 29);
        getContentPane().add(btnSignIn);

        JLabel lblUser = new JLabel("User:");
        lblUser.setBounds(103, 193, 38, 20);
        getContentPane().add(lblUser);


    }
}
