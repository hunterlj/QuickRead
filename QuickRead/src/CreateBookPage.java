import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateBookPage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblAddBookRequest = new JLabel("Add Book Request");
    private final JLabel lblTitle = new JLabel("Title:");
    private final JLabel lblAuthor = new JLabel("Author:");
    private final JLabel lblSubject = new JLabel("Subject:");
    private final JTextField textField = new JTextField();
    private final JTextField textField_1 = new JTextField();
    private final JTextField textField_2 = new JTextField();
    private final JLabel lblDescription = new JLabel("Description:");
    private final JTextField textField_3 = new JTextField();
    private final JButton btnSendAddRequest = new JButton("Send Add Request");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateBookPage frame = new CreateBookPage();
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
    public CreateBookPage() {
        textField_3.setBounds(119, 302, 500, 26);
        textField_3.setColumns(10);
        textField_2.setBounds(90, 221, 529, 26);
        textField_2.setColumns(10);
        textField_1.setBounds(79, 141, 540, 26);
        textField_1.setColumns(10);
        textField.setBounds(64, 78, 555, 26);
        textField.setColumns(10);
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 674, 489);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblAddBookRequest.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddBookRequest.setBounds(0, 30, 642, 20);
        
        contentPane.add(lblAddBookRequest);
        lblTitle.setBounds(15, 81, 69, 20);
        
        contentPane.add(lblTitle);
        lblAuthor.setBounds(15, 144, 69, 20);
        
        contentPane.add(lblAuthor);
        lblSubject.setBounds(15, 224, 69, 20);
        
        contentPane.add(lblSubject);
        
        contentPane.add(textField);
        
        contentPane.add(textField_1);
        
        contentPane.add(textField_2);
        lblDescription.setBounds(15, 305, 89, 20);
        
        contentPane.add(lblDescription);
        
        contentPane.add(textField_3);
        btnSendAddRequest.setBounds(231, 364, 163, 29);
        
        contentPane.add(btnSendAddRequest);
        
        btnSendAddRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSenAddRequestPerformed(e);
            }
            private void btnSenAddRequestPerformed(ActionEvent e) {
                String title = textField.getText();
                String author = textField_1.getText();
                String subject = textField_2.getText();
                String description = textField_3.getText();
                
                if (Book.requestBook(title, author, subject, description) != 0) {
                    JOptionPane.showMessageDialog(CreateBookPage.this, "Request Sent!", "Thank You!", JOptionPane.INFORMATION_MESSAGE); 
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(CreateBookPage.this, "Request could not be sent!", "Error!", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                    textField_3.setText("");
                }
            }
        });
        
    }
}
