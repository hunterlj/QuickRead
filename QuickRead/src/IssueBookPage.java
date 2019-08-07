import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IssueBookPage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblCheckOutBook = new JLabel("Check Out Book");
    private final JLabel lblBookSerial = new JLabel("Book Serial:");
    private final JLabel lblUserId = new JLabel("User ID:");
    private final JLabel lblIssueDate = new JLabel("Issue Date:");
    private final JLabel lblNewLabel = new JLabel("Return Date:");
    private final JTextField textField = new JTextField();
    private final JTextField textField_1 = new JTextField();
    private final JTextField issueMonth = new JTextField();
    private final JTextField returnMonth = new JTextField();
    private final JButton btnConfirmCheckOut = new JButton("Confirm Check Out");
    private final JTextField issueDay = new JTextField();
    private final JTextField issueYear = new JTextField();
    private final JTextField returnDay = new JTextField();
    private final JTextField returnYear = new JTextField();
    
    public static String user;
    public static String book;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IssueBookPage frame = new IssueBookPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        book = args[0];
        user = args[1];
    }

    /**
     * Create the frame.
     */
    public IssueBookPage() throws SQLException {
        returnYear.setEditable(false);
        returnYear.setBounds(252, 194, 42, 26);
        returnYear.setColumns(10);
        returnDay.setEditable(false);
        returnDay.setBounds(195, 194, 42, 26);
        returnDay.setColumns(10);
        issueYear.setEditable(false);
        issueYear.setBounds(252, 147, 42, 26);
        issueYear.setColumns(10);
        issueDay.setEditable(false);
        issueDay.setBounds(195, 147, 42, 26);
        issueDay.setColumns(10);
        returnMonth.setEditable(false);
        returnMonth.setBounds(142, 194, 38, 26);
        returnMonth.setColumns(10);
        issueMonth.setEditable(false);
        issueMonth.setBounds(138, 147, 42, 26);
        issueMonth.setColumns(10);
        textField_1.setEditable(false);
        textField_1.setBounds(116, 97, 158, 26);
        textField_1.setColumns(10);
        textField.setEditable(false);
        textField.setBounds(142, 52, 132, 26);
        textField.setColumns(10);
        initGUI();
        
        textField.setText(book);
        textField_1.setText(user);
        
        int year;
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        String TodayYear;
        TodayYear = String.valueOf(year);
        issueYear.setText(TodayYear);
        String TodayMonth = String.valueOf(cal.get(Calendar.MONTH)+1);
        issueMonth.setText(TodayMonth);
        String TodayDate = String.valueOf(cal.get(Calendar.DATE));
        issueDay.setText(TodayDate);
        
        Calendar addcal = null;
        addcal = cal;
        addcal.add(Calendar.DAY_OF_YEAR,15);
        
        returnDay.setText(String.valueOf(addcal.get(Calendar.DATE)));
        returnMonth.setText(String.valueOf(addcal.get(Calendar.MONTH)+1));
        returnYear.setText(String.valueOf(addcal.get(Calendar.YEAR)));
        
        
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 471);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        
        contentPane.setLayout(null);
        lblCheckOutBook.setHorizontalAlignment(SwingConstants.CENTER);
        lblCheckOutBook.setBounds(132, 16, 142, 20);
        
        contentPane.add(lblCheckOutBook);
        lblBookSerial.setBounds(48, 52, 97, 20);
        
        contentPane.add(lblBookSerial);
        lblUserId.setBounds(48, 100, 69, 20);
        
        contentPane.add(lblUserId);
        lblIssueDate.setBounds(48, 150, 97, 20);
        
        contentPane.add(lblIssueDate);
        lblNewLabel.setBounds(48, 197, 97, 20);
        
        contentPane.add(lblNewLabel);
        
        contentPane.add(textField);
        
        contentPane.add(textField_1);
        
        contentPane.add(issueMonth);
        
        contentPane.add(returnMonth);
        btnConfirmCheckOut.setBounds(132, 269, 185, 29);
        
        contentPane.add(btnConfirmCheckOut);
        
        contentPane.add(issueDay);
        
        contentPane.add(issueYear);
        
        contentPane.add(returnDay);
        
        contentPane.add(returnYear);
        
        btnConfirmCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnConfirmCheckOutPerformed(e);
            }
            private void btnConfirmCheckOutPerformed(ActionEvent e) {
                int bookId = Integer.parseInt(textField.getText());
                int userId = Integer.parseInt(textField_1.getText());
                String issueDate = issueYear.getText() + "-" + issueMonth.getText() + "-"
                + issueDay.getText();
                String returnDate = returnYear.getText() + "-" + returnMonth.getText() + "-"
                + returnDay.getText();
                if(!Loan.CheckIssuedBook(bookId)) {
                    if (Loan.IssueBook(bookId, userId, issueDate, returnDate) != 0) {
                        JOptionPane.showMessageDialog(IssueBookPage.this, "Book has been succesfully checked out.");
                    } else {
                        JOptionPane.showMessageDialog(IssueBookPage.this, "Sorry, this book cannot be issued!","Issuing Book Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(IssueBookPage.this, "Sorry, this book is currently unavailable.");
                    
                }
                
            }
        });
        
    }

}
