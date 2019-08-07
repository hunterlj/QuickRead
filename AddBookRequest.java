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

public class AddBookRequest {

    private JFrame frame;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JRadioButton btnSignIn;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private JTextField textField;
    private JTextField textField_1;

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
    public AddBookRequest() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setBounds(100, 100, 476, 388);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblUsername = new JLabel("Title: ");
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
        
        JLabel lblPassword = new JLabel("Author: ");
        lblPassword.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblPassword.setBounds(70, 149, 82, 20);
        frame.getContentPane().add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setBackground(new Color(255, 255, 255));
        txtPassword.setBounds(153, 146, 178, 26);
        frame.getContentPane().add(txtPassword);
        txtPassword.setColumns(10);
        
        JLabel lblQuicksearch = new JLabel("Add Book Request");
        lblQuicksearch.setForeground(Color.BLACK);
        lblQuicksearch.setBackground(new Color(255, 255, 255));
        lblQuicksearch.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuicksearch.setBounds(128, 16, 214, 52);
        lblQuicksearch.setFont(new Font("HanziPen TC", Font.BOLD, 24)); 
        frame.getContentPane().add(lblQuicksearch);
        
        JButton btnSignIn = new JButton("Search");
        btnSignIn.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        btnSignIn.setBackground(new Color(255, 255, 102));
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        btnSignIn.setBounds(179, 295, 115, 29);
        frame.getContentPane().add(btnSignIn);
        
        JLabel lblUser = new JLabel("Subject:");
        lblUser.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblUser.setBounds(70, 194, 49, 20);
        frame.getContentPane().add(lblUser);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBackground(Color.WHITE);
        textField.setBounds(153, 191, 178, 26);
        frame.getContentPane().add(textField);
        
        JLabel lblDes = new JLabel("Description:");
        lblDes.setFont(new Font("HanziPen SC", Font.PLAIN, 15));
        lblDes.setBounds(70, 244, 70, 20);
        frame.getContentPane().add(lblDes);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBackground(Color.WHITE);
        textField_1.setBounds(153, 241, 178, 26);
        frame.getContentPane().add(textField_1);
    }
}

