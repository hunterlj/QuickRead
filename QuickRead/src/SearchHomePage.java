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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
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
        textField.setBounds(645, 27, 232, 26);
        textField.setColumns(10);
        lblQuickread.setBounds(5, 5, 291, 58);
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
        mnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mnCreateAccountActionPerformed(e);
            }
            private void mnCreateAccountActionPerformed(ActionEvent e) {
                CreateAccountPage.main(new String[] {});
            }
        });

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        buttonGroup.add(rdbtnBookAuthor);
        scrollPane.setBounds(32, 142, 940, 491);

        scrollPane.setColumnHeaderView(menuBar_1);

        menuBar_1.add(mnSerial);

        menuBar_1.add(mnTitle);

        menuBar_1.add(mnAuthor);

        menuBar_1.add(mnSubject);

        menuBar_1.add(mnDescription);

        menuBar_1.add(mnCopiesAvaliable);
        contentPane.setLayout(null);
        contentPane.add(lblQuickread);
        layeredPane.setBounds(5, 102, 1, 1);
        contentPane.add(layeredPane);
        lblBy.setBounds(609, 71, 23, 20);
        contentPane.add(lblBy);
        lblSearch.setBounds(581, 30, 58, 20);
        contentPane.add(lblSearch);
        rdbtnBookTitle.setBounds(646, 67, 63, 29);
        contentPane.add(rdbtnBookTitle);
        rdbtnBookAuthor.setBounds(710, 67, 81, 29);
        contentPane.add(rdbtnBookAuthor);
        rdbtnSubject.setBounds(792, 67, 85, 29);
        contentPane.add(rdbtnSubject);
        contentPane.add(textField);

        btnFind.setBounds(886, 26, 63, 29);
        contentPane.add(btnFind);
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnFindActionPerformed(e);
            }
            private void btnFindActionPerformed(ActionEvent e) {
                // show search results
                // use library search book method
            }
        });

        btnSignIn.setBounds(980, 5, 89, 29);
        contentPane.add(btnSignIn);
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSignInActionPerformed(e);
            }
            private void btnSignInActionPerformed(ActionEvent e) {
                LoginPage.main(new String[] {});
            }
        });

        btnSignUp.setBounds(980, 43, 89, 29);
        contentPane.add(btnSignUp);
        contentPane.add(scrollPane);
    }
}
