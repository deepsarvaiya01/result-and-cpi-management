import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class page2 extends JFrame{
    page2() {
        // JFrame frame = new JFrame("Text Field Example");
        setLayout(null); // Set the layout to null

        // Set the size of the frame
        setSize(700, 350);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 50, 70, 25);
        add(usernameLabel);


        // Create the first text field
        JTextField textField1 = new JTextField();
        textField1.setBounds(100, 50, 80, 25); // Set bounds for the text field
        add(textField1); // Add the text field to the frame

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 100, 80, 25);
        add(passwordLabel);

        // Create the second text field
        JTextField textField2 = new JTextField();
        textField2.setBounds(100, 100, 80, 25); // Set bounds for the text field
        add(textField2); // Add the text field to the frame

        // Create a button
        JButton button = new JButton("Check");
        button.setBounds(50, 150, 150, 25); // Set bounds for the button
        add(button); // Add the button to the frame

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = textField2.getText();
        
                // JDBC code to check username and password in the database
                // JDBC driver name and database URL
                String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                String DB_URL = "jdbc:mysql://localhost/hemli";
        
                // Database credentials
                String USER = "root";
                String PASS = "***********";
        
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                try {
                    // Register JDBC driver
                    Class.forName(JDBC_DRIVER);
        
                    // Open a connection
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
                    // Prepare a statement
                    String sql = "SELECT * FROM faculty WHERE username = ? AND password = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
        
                    // Execute the query
                    rs = pstmt.executeQuery();
        
                    // Process the result
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        page3 page3 = new page3();
                        page3.setSize(700, 350);
                        page3.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    // Close the resources
                    try {
                        if (rs != null) rs.close();
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        // Make the frame visible
        setVisible(true);
    }
}
