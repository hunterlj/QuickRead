import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class StudentHome extends JFrame {

    private JPanel contentPane;
    private final JLabel lblStudentAccount = new JLabel("Student Account ");
    private final JLabel lblName = new JLabel("Name:");
    private final JLabel lblUsername = new JLabel("Username:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JLabel lblCurrentBooksIssued = new JLabel("Current Books Issued:");
    private final JScrollPane scrollPane = new JScrollPane();
    private final JTextField textField = new JTextField();
    private final JTextField textField_1 = new JTextField();
    private final JTextField textField_2 = new JTextField();
    String name = "";
    String username = "";
    String password = "";
    private final JTable table = new JTable();

    public static String user;
    private final JButton btnBackToSearch = new JButton("Back to Search Page");
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentHome frame = new StudentHome();
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
    public StudentHome() throws SQLException {
        textField_2.setBounds(95, 125, 313, 26);
        textField_2.setColumns(10);
        textField_1.setBounds(96, 86, 312, 26);
        textField_1.setColumns(10);
        textField.setBounds(96, 50, 312, 26);
        textField.setColumns(10);
        initGUI();
        
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(model.getRowCount()-1);
        }
        int id = 0;
        try(Connection conn = LibraryConnection.getConnection()) {
            PreparedStatement ps1 = conn.prepareStatement("SELECT id FROM users WHERE username = ?");
            ps1.setString(1, user);
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()) {
                id = rs1.getInt(1);
            }
                  
            
            PreparedStatement ps = conn.prepareStatement("SELECT bookId, issueddate, returndate FROM issuedbook WHERE userId = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int column = rsmd.getColumnCount();
            
            String Row[];
            Row = new String[column];
            while (rs.next()) {
                for ( int i =1 ;i <= column; i++) {
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
        setBounds(100, 100, 638, 533);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblStudentAccount.setBounds(233, 16, 121, 20);
        
        contentPane.add(lblStudentAccount);
        lblName.setBounds(15, 53, 95, 20);
        
        contentPane.add(lblName);
        lblUsername.setBounds(15, 89, 95, 20);
        
        contentPane.add(lblUsername);
        lblPassword.setBounds(15, 125, 95, 20);
        
        contentPane.add(lblPassword);
        lblCurrentBooksIssued.setBounds(15, 191, 169, 20);
        
        contentPane.add(lblCurrentBooksIssued);
        scrollPane.setBounds(15, 236, 586, 197);
        
        contentPane.add(scrollPane);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
            },
            new String[] {
                "Book Serial", "Issued Date", "Return Date"
            }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(106);
        table.getColumnModel().getColumn(0).setMinWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(202);
        table.getColumnModel().getColumn(2).setPreferredWidth(194);
        
        scrollPane.setViewportView(table);
        
        
        
        contentPane.add(textField);
        textField.setEditable(false);
        contentPane.add(textField_1);
        textField_1.setEditable(false);
        contentPane.add(textField_2);
        textField_2.setEditable(false);
        btnBackToSearch.setBounds(200, 448, 201, 29);
        
        contentPane.add(btnBackToSearch);
        
        btnBackToSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnBackToSearchPerformed(e);
            }

            private void btnBackToSearchPerformed(ActionEvent e) {
                dispose();
                SearchHomePage.main(new String[] {user});
                
            }
        });

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
        
    
    }
}
