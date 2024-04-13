import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class page6 extends JFrame {
    String gr_no1;
    page6(String gr_no){
        gr_no1=gr_no;
        // Set the size of the frame
        setSize(700, 700);
        setLayout(null);

        JLabel label1 = new JLabel("Name:");
        label1.setBounds(10, 50, 100, 25);
        add(label1);

        JLabel label2 = new JLabel("JAVA:");
        label2.setBounds(10, 100, 100, 25);
        add(label2);

        JLabel label3 = new JLabel("OS:");
        label3.setBounds(10, 150, 100, 25);
        add(label3);

        JLabel label4 = new JLabel("DM:");
        label4.setBounds(10, 200, 100, 25);
        add(label4);

        JLabel label5 = new JLabel("ADA:");
        label5.setBounds(10, 250, 100, 25);
        add(label5);

        JLabel label6 = new JLabel("CN:");
        label6.setBounds(10, 300, 100, 25);
        add(label6);

        // Create text fields
        JTextField textField1 = new JTextField();
        textField1.setBounds(50, 50, 200, 25);
        add(textField1);

        JTextField textField2 = new JTextField();
        textField2.setBounds(50, 100, 200, 25);
        add(textField2);

        JTextField textField3 = new JTextField();
        textField3.setBounds(50, 150, 200, 25);
        add(textField3);

        JTextField textField4 = new JTextField();
        textField4.setBounds(50, 200, 200, 25);
        add(textField4);

        JTextField textField5 = new JTextField();
        textField5.setBounds(50, 250, 200, 25);
        add(textField5);

        JTextField textField6 = new JTextField();
        textField6.setBounds(50, 300, 200, 25);
        add(textField6);

        // Create a button
        JButton button = new JButton("Save");
        button.setBounds(50, 350, 100, 25);
        add(button);

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String value1 = textField1.getText();
                String value2 = textField2.getText();
                String value3 = textField3.getText();
                String value4 = textField4.getText();
                String value5 = textField5.getText();
                String value6 = textField6.getText();

                int sum;
                sum = Integer.parseInt(value2) + Integer.parseInt(value3)+ Integer.parseInt(value4)+Integer.parseInt(value5)+Integer.parseInt(value6);
                float sum2 = sum;
                float cgpa1 = (sum2/500)*9.5f;
                String cvalue = String.format("%.2f", cgpa1);
                // System.out.print(cgpa1);

                try {
                    // Connect to the database
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemli", "root", "*********");

                    // Insert values into the table
                    String query = "INSERT INTO `sem2` (gr_no, Name, java, os, dm, ada, cn, cgpa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1, gr_no1);
                    preparedStatement.setString(2, textField1.getText());
                    preparedStatement.setString(3, textField2.getText());
                    preparedStatement.setString(4, textField3.getText());
                    preparedStatement.setString(5, textField4.getText());
                    preparedStatement.setString(6, textField5.getText());
                    preparedStatement.setString(7, textField6.getText());
                    preparedStatement.setString(8, cvalue);

                    // Execute the query
                    preparedStatement.executeUpdate();

                    // Close the connection
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Added Successfuliy");
                    // System.out.println("Inserted values into database successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR" + ex.getMessage());
                    // System.out.println("Error inserting values into database: " + ex.getMessage());
                }
            }
        });

        // Make the frame visible
        setVisible(true);
    }
}
