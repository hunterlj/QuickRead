import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
/**
 * QuickRead - LoginPage Class
 * Login window GUI
 * @author LoginPage
 * 
 */
public class SearchHomePage extends JFrame {

    private JPanel contentPane;
    private JScrollPane scrollBooks;
    private final JLabel lblSearch = new JLabel("Search: ");
    private final JRadioButton rdbtnBookTitle = new JRadioButton("Title");
    private final JRadioButton rdbtnBookAuthor = new JRadioButton("Author");
    private final JLabel lblBy = new JLabel("By:");
    private final JLabel lblQuickread = new JLabel("QuickRead Library System");
    private final JButton btnSignIn = new JButton("Sign In");
    private final JButton btnSignUp = new JButton("Sign Up");
    private final JMenuBar menuBar = new JMenuBar();
    private final JRadioButton rdbtnSubject = new JRadioButton("Subject");
    private final JTextField textField = new JTextField();
    private final JButton btnFind = new JButton("Find");
    private final JLayeredPane layeredPane = new JLayeredPane();
    private final JScrollPane scrollPane = new JScrollPane();
    private final JMenu mnSignIn = new JMenu("Sign In");
    private final JMenu mnCreateAccount = new JMenu("Create Account");
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchHomePage frame = new SearchHomePage();
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
    public SearchHomePage() {
        textField.setColumns(10);
        lblQuickread.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblQuickread.setHorizontalAlignment(SwingConstants.CENTER);
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1107, 725);
        
        setJMenuBar(menuBar);
        
        menuBar.add(mnSignIn);
        
        menuBar.add(mnCreateAccount);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblQuickread, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                                .addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(225)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(88)
                                    .addComponent(lblBy))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(60)
                                    .addComponent(lblSearch)))
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(7)
                                    .addComponent(rdbtnBookTitle)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(rdbtnBookAuthor)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(rdbtnSubject))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(textField)))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnFind)
                            .addGap(31)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(btnSignIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSignUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(15)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 940, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(21)
                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblSearch)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnFind))
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(rdbtnBookAuthor)
                                        .addComponent(rdbtnBookTitle)
                                        .addComponent(lblBy)
                                        .addComponent(rdbtnSubject)))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(btnSignIn)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(btnSignUp)))
                            .addGap(6)
                            .addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblQuickread, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE)
                    .addGap(28))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
