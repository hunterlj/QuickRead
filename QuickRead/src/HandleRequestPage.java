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

public class HandleRequestPage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblConfirmOrDeny = new JLabel("Confirm or Deny Request");
    private final JButton btnNewButton = new JButton("Confirm");
    private final JButton btnNewButton_1 = new JButton("Deny");
    public static String title;
    public static String author;
    public static String subject;
    public static String description;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HandleRequestPage frame = new HandleRequestPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        title = args[0];
        author = args[1];
        subject = args[2];
        description = args[3];
    }

    /**
     * Create the frame.
     */
    public HandleRequestPage() {
        initGUI();
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblConfirmOrDeny.setBounds(5, 5, 418, 20);
        lblConfirmOrDeny.setHorizontalAlignment(SwingConstants.CENTER);
        
        contentPane.add(lblConfirmOrDeny);
        btnNewButton.setBounds(63, 100, 115, 65);
        
        contentPane.add(btnNewButton);
        btnNewButton_1.setBounds(243, 100, 115, 65);
        
        contentPane.add(btnNewButton_1);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButtonActionPerformed(e);
            }

            private void btnNewButtonActionPerformed(ActionEvent e) {                
                Book.addBook(title, author, subject, description);
                Book.denyRequest(title);
                JOptionPane.showMessageDialog(HandleRequestPage.this, "Book had been added to library.", "Book Created", JOptionPane.INFORMATION_MESSAGE);;
                dispose();
            }
        });
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_1ActionPerformed(e);
            }

            private void btnNewButton_1ActionPerformed(ActionEvent e) {                
                Book.denyRequest(title);
                JOptionPane.showMessageDialog(HandleRequestPage.this, "Request had been denied and removed.", "Request Denied", JOptionPane.INFORMATION_MESSAGE);;
                dispose();
            }
        });
    }
}
