import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class AdminHomePage extends JFrame {

    private JPanel contentPane;
    private final JLabel lblAdminAccount = new JLabel("Administrator Home Page");
    private final JLabel lblName = new JLabel("Name:");
    private final JLabel lblUsername = new JLabel("Username:");
    private final JLabel lblPassword = new JLabel("Password:");
    private final JLabel lblAddBookRequests = new JLabel("Add Book Requests:");
    private final JTextField textField = new JTextField();
    private final JTextField textField_1 = new JTextField();
    private final JTextField textField_2 = new JTextField();
    private final JTable table = new JTable();
    private final JScrollPane scrollPane = new JScrollPane();
    public static String user;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminHomePage frame = new AdminHomePage();
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
    public AdminHomePage() {
        textField_2.setEditable(false);
        textField_2.setBounds(101, 167, 241, 26);
        textField_2.setColumns(10);
        textField_1.setEditable(false);
        textField_1.setBounds(101, 112, 241, 26);
        textField_1.setColumns(10);
        textField.setEditable(false);
        textField.setBounds(71, 56, 271, 26);
        textField.setColumns(10);
        initGUI();
        
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        try(Connection conn = LibraryConnection.getConnection()) {   
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM requests", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        setBounds(100, 100, 651, 696);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblAdminAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdminAccount.setBounds(202, 16, 216, 20);
        
        contentPane.add(lblAdminAccount);
        lblName.setBounds(15, 59, 69, 20);
        
        contentPane.add(lblName);
        lblUsername.setBounds(15, 115, 91, 20);
        
        contentPane.add(lblUsername);
        lblPassword.setBounds(15, 170, 91, 20);
        
        contentPane.add(lblPassword);
        lblAddBookRequests.setBounds(15, 234, 173, 20);
        
        contentPane.add(lblAddBookRequests);
        
        contentPane.add(textField);
        
        contentPane.add(textField_1);
        
        contentPane.add(textField_2);
        scrollPane.setBounds(15, 270, 599, 118);
        
        contentPane.add(scrollPane);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
                {null, "", null},
                {null, null, ""},
                {null, null, null},
                {null, null, null},
            },
            new String[] {
                "Request No.", "Book", "Status"
            }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(130);
        table.getColumnModel().getColumn(1).setPreferredWidth(596);
        table.getColumnModel().getColumn(2).setPreferredWidth(78);
        
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
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pointPressed(e);
            }
            private void pointPressed(MouseEvent e) {
                Point point = e.getPoint();
                int currentRow = table.rowAtPoint(point);
                int currentColumn = 1;
                table.setRowSelectionInterval(currentRow, currentRow);
                table.setColumnSelectionInterval(1,1);

                String selected = (String) table.getValueAt(currentRow, currentColumn);

                String title = null;
                String author = null;
                String subject = null;
                String description = null;
                try(Connection conn = LibraryConnection.getConnection()) {
                    PreparedStatement ps1 = conn.prepareStatement("SELECT title, author, subject, description FROM requests WHERE title = ?");
                    ps1.setString(1, selected);
                    ResultSet rs1 = ps1.executeQuery();
                    while(rs1.next()) {
                        title = rs1.getString(1);
                        author = rs1.getString(2);
                        subject = rs1.getString(3);
                        description = rs1.getString(4);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                Book.addBook(title, author, subject, description);
              //  IssueBookPage.main(new String[] {selected, id});                                
            }
        });
    }
}
