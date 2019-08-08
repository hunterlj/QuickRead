import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LibrarianHomePage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblLibrarianAccountPage = new JLabel("Librarian Account Page");
    private final JLabel lblFullName = new JLabel("Full Name:");
    private final JLabel lblUsername = new JLabel("Username:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JButton btnAddBookRequest = new JButton("Send Book Request");
    private final JScrollPane scrollPane = new JScrollPane();
    private final JTable table = new JTable();
    private final JTextField textField = new JTextField();
    private final JTextField textField_1 = new JTextField();
    private final JTextField textField_2 = new JTextField();
    private final JLabel lblAllLibraryAccounts = new JLabel("All Student Accounts:");
    private static String user;
    private final JButton btnNewButton = new JButton("Back to Search Page");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LibrarianHomePage frame = new LibrarianHomePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        user = args[0];
    }

    /**
     * Create the frame.
     */
    public LibrarianHomePage() {
        textField_2.setEditable(false);
        textField_2.setBounds(106, 180, 195, 26);
        textField_2.setColumns(10);
        textField_1.setEditable(false);
        textField_1.setBounds(106, 126, 195, 26);
        textField_1.setColumns(10);
        textField.setEditable(false);
        textField.setBounds(106, 76, 195, 26);
        textField.setColumns(10);
        initGUI();
        
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(model.getRowCount()-1);
        }
        try(Connection conn = LibraryConnection.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE position = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, "student");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int column = rsmd.getColumnCount();          
            String Row[];
            Row = new String[column];
            while (rs.next()) {
                for (int i = 1 ;i <= column; i++) {
                    Row[i-1] = rs.getString(i);
                }
                model.addRow(Row);     
            }
            conn.close();
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 613, 599);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblLibrarianAccountPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLibrarianAccountPage.setBounds(0, 40, 591, 20);
        
        contentPane.add(lblLibrarianAccountPage);
        lblFullName.setBounds(15, 76, 118, 20);
        
        contentPane.add(lblFullName);
        lblUsername.setBounds(15, 129, 104, 20);
        
        contentPane.add(lblUsername);
        lblPassword.setBounds(15, 183, 104, 20);
        
        contentPane.add(lblPassword);
        btnAddBookRequest.setBounds(58, 482, 207, 29);
        
        contentPane.add(btnAddBookRequest);
        scrollPane.setBounds(15, 270, 561, 196);
        
        btnAddBookRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAddBookRequestPerformed(e);
            }

            private void btnAddBookRequestPerformed(ActionEvent e) {
                CreateBookPage.main(new String[] {user});
            }
        });
        
        contentPane.add(scrollPane);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String[] {
                "User ID", "Full Name", "Username", "Password"
            }
        ));
        table.getColumnModel().getColumn(1).setPreferredWidth(161);
        table.getColumnModel().getColumn(2).setPreferredWidth(181);
        table.getColumnModel().getColumn(3).setPreferredWidth(201);
        
        contentPane.add(textField);
        
        contentPane.add(textField_1);
        
        contentPane.add(textField_2);
        lblAllLibraryAccounts.setBounds(15, 234, 184, 20);
        
        contentPane.add(lblAllLibraryAccounts);
        
        try (Connection conn = LibraryConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1,  user);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString(4);
                String username = rs.getString(2);
                String password = rs.getString(3);
                             
                textField.setText(name);
                textField_1.setText(username);
                textField_2.setText(password);

            }            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        btnNewButton.setBounds(319, 482, 184, 29);
        
        
        
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButtonPerformed(e);
            }

            private void btnNewButtonPerformed(ActionEvent e) {
                SearchHomePage.main(new String[] {user});
                dispose();
            }
        });
    }
}
