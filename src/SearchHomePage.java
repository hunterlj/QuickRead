import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JSplitPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
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
    private final JRadioButton rdbtnSubject = new JRadioButton("Subject");
    private final JTextField textField = new JTextField();
    private final JButton btnFind = new JButton("Find");
    private final JLayeredPane layeredPane = new JLayeredPane();
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTable table = new JTable();
    private final JScrollPane scrollPane = new JScrollPane();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchHomePage frame = new SearchHomePage();
                    frame.setVisible(true);
                    frame.setResizable(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SearchHomePage() throws SQLException {
        buttonGroup.add(rdbtnBookTitle);
        buttonGroup.add(rdbtnSubject);
        textField.setBounds(645, 27, 232, 26);
        textField.setColumns(10);
        lblQuickread.setBounds(5, 5, 291, 58);
        lblQuickread.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblQuickread.setHorizontalAlignment(SwingConstants.CENTER);
        
        initGUI();
        
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        try (Connection conn = LibraryConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from books", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            String Row[];
            Row = new String[columns];
            while(rs.next()) {
                for (int i = 1; i <= columns; i++) {
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
        setBounds(100, 100, 1107, 725);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        buttonGroup.add(rdbtnBookAuthor);
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
                DefaultTableModel model;
                model = (DefaultTableModel) table.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(model.getRowCount()-1);
                }
                
                String search = "%" + textField.getText() + "%";
                try (Connection con = LibraryConnection.getConnection()){
                    if (rdbtnBookTitle.isSelected()) {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE title LIKE ?", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ps.setString(1, search);
                    ResultSet rs = ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columns = rsmd.getColumnCount();
                            
                    String Row[];
                    Row = new String[columns];
                    while(rs.next()){
                        for(int i=1;i<=columns;i++){
                            Row[i-1]=rs.getString(i);
                            }
                         model.addRow(Row);
                    }
                    int rowcount = model.getRowCount();
                     System.out.println(rowcount);
                    if(rowcount==0)
                    {
                        String NoRow[];
                        NoRow = new String[7];
                        NoRow[3]="NO";
                        NoRow[4]="RESULT";
                        NoRow[0]="";
                        NoRow[1]="";
                        NoRow[2]="";
                        NoRow[5]="";
                        NoRow[6]="";
                        model.addRow(NoRow);
                             
                    }
                
                } else if (rdbtnBookAuthor.isSelected()){
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE author LIKE ?", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ps.setString(1, search);
                    ResultSet rs = ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columns = rsmd.getColumnCount();
                            
                    String Row[];
                    Row = new String[columns];
                    while(rs.next()){
                        for(int i=1;i<=columns;i++){
                            Row[i-1]=rs.getString(i);
                            }
                         model.addRow(Row);
                    }
                    int rowcount = model.getRowCount();
                     System.out.println(rowcount);
                    if(rowcount==0)
                    {
                        String NoRow[];
                        NoRow = new String[7];
                        NoRow[3]="NO";
                        NoRow[4]="RESULT";
                        NoRow[0]="";
                        NoRow[1]="";
                        NoRow[2]="";
                        NoRow[5]="";
                        NoRow[6]="";
                        model.addRow(NoRow);
                             
                    }
                }
                    
                    con.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                
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
        scrollPane.setBounds(15, 123, 1054, 516);
        
        contentPane.add(scrollPane);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null},
                {null, null, null, "", null, null},
                {null, null, null, null, null, null},
                {null, "", null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String[] {
                "Serial", "Title", "Author", "Subject", "Description", "Status"
            }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(35);
        table.getColumnModel().getColumn(1).setPreferredWidth(135);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        scrollPane.setViewportView(table);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JPopupMenu popMenu = new JPopupMenu();    
        JMenuItem menuItem1 = new JMenuItem("Check out this book");
        popMenu.add(menuItem1);
        
        table.setComponentPopupMenu(popMenu);
//        
//        table.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                pointPressed(e);
//            }
//            private void pointPressed(MouseEvent e) {
//                Point point = e.getPoint();
//                int currentRow = table.rowAtPoint(point);
//                int currentColumn = 0;
//                table.setRowSelectionInterval(currentRow, currentRow);
//                table.setColumnSelectionInterval(0,1);
//                
//                int selected = (int) table.getValueAt(currentRow, currentColumn);
//                
//                try (Connection con = LibraryConnection.getConnection()){
//                    if (rdbtnBookTitle.isSelected()) {
//                    PreparedStatement ps = con.prepareStatement("SELECT id FROM books WHERE books.id = issuedbook.bookId", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//                    ResultSet rs = ps.executeQuery();                
//                if(rs = ) {
//                    
//                    
//                } else {
//                    JOptionPane.showMessageDialog(contentPane, "This book is currently unavailable", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        });
        
        
        
    }
}
    
    
       
        
        