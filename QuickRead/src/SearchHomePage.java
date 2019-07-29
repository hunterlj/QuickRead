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
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.UIManager;
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
    private final JMenuBar menuBar_1 = new JMenuBar();
    private final JMenu mnSerial = new JMenu("Serial");
    private final JMenu mnTitle = new JMenu("Title");
    private final JMenu mnAuthor = new JMenu("Author");
    private final JMenu mnSubject = new JMenu("Subject");
    private final JMenu mnDescription = new JMenu("Description");
    private final JMenu mnCopiesAvaliable = new JMenu("Copies Avaliable");
    private final ButtonGroup buttonGroup = new ButtonGroup();
    
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
        buttonGroup.add(rdbtnBookTitle);
        buttonGroup.add(rdbtnSubject);
        textField.setColumns(10);
        lblQuickread.setForeground(new Color(255, 255, 0));
        lblQuickread.setFont(new Font("HanziPen SC", Font.BOLD, 35));
        lblQuickread.setHorizontalAlignment(SwingConstants.CENTER);
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1107, 725);
        menuBar.setFont(new Font("Skia", Font.PLAIN, 14));
        menuBar.setBackground(new Color(255, 255, 255));
        
        setJMenuBar(menuBar);
        mnSignIn.setBackground(new Color(255, 255, 255));
        mnSignIn.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 14));
        
        menuBar.add(mnSignIn);
        mnCreateAccount.setFont(new Font("AppleGothic", Font.PLAIN, 14));
        
        menuBar.add(mnCreateAccount);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(46)
        					.addComponent(lblQuickread, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
        					.addGap(60)
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
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnSignIn)
        						.addComponent(btnSignUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(27)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 940, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(32, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(21)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblSearch)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnFind)
        						.addComponent(btnSignIn))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(rdbtnBookAuthor)
        						.addComponent(rdbtnBookTitle)
        						.addComponent(lblBy)
        						.addComponent(rdbtnSubject)
        						.addComponent(btnSignUp))
        					.addGap(6)
        					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(22)
        					.addComponent(lblQuickread, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE))
        );
        btnSignIn.setBackground(new Color(51, 102, 255));
        lblSearch.setFont(new Font("STHeiti", Font.PLAIN, 13));
        lblBy.setFont(new Font("STHeiti", Font.PLAIN, 13));
        rdbtnBookTitle.setFont(new Font("STHeiti", Font.PLAIN, 13));
        rdbtnBookAuthor.setFont(new Font("STHeiti", Font.PLAIN, 13));
        rdbtnSubject.setFont(new Font("STHeiti", Font.PLAIN, 13));
        btnFind.setBackground(new Color(255, 255, 102));
        buttonGroup.add(rdbtnBookAuthor);
        menuBar_1.setBackground(new Color(51, 153, 255));
        
        scrollPane.setColumnHeaderView(menuBar_1);
        
        menuBar_1.add(mnSerial);
        
        menuBar_1.add(mnTitle);
        
        menuBar_1.add(mnAuthor);
        
        menuBar_1.add(mnSubject);
        
        menuBar_1.add(mnDescription);
        
        menuBar_1.add(mnCopiesAvaliable);
        contentPane.setLayout(gl_contentPane);
    }
}

